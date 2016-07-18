package elaundry.clients.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elaundry.clients.bean.ClientsBeanI;
import elaundry.clients.model.Clients;
import elaundry.common.model.Address;

@SuppressWarnings("serial")
@WebServlet("/clients/*")
public class ClientsAction extends HttpServlet{
	
	private Clients clients;
	
	@EJB	
	private ClientsBeanI clientsBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException{
		String [] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		
		if(path.equalsIgnoreCase("load"))
			this.load(request, response);
		else
			this.list(response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Clients client = new Clients();
		
		if(request.getParameter("id") != null 
				&& !request.getParameter("id").equals("undefined"))
			client.setId(Long.parseLong(request.getParameter("id")));
		
		client.setFullname(request.getParameter("fullname"));
		client.setClientid(request.getParameter("clientid"));
		client.setNationalid(Long.parseLong(request.getParameter("nationalid")));
		
		client.setAddress(new Address());
		client.getAddress().setPhoneNo(request.getParameter("phoneNo"));
		client.getAddress().setEmail(request.getParameter("email"));
		client.getAddress().setTown(request.getParameter("town"));
		client.getAddress().setCountry(request.getParameter("country"));
		client.getAddress().setBox(request.getParameter("box"));
		
		clientsBean.add(client);
		
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long clientId = Long.parseLong(request.getParameter("id"));
		clientsBean.delete(clientId);
		
	}
	
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(clientsBean.listInJson());
	}
	
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(clientsBean.load(Long.parseLong(request.getParameter("id"))));
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}
	
}
