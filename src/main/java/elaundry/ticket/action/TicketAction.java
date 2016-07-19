package elaundry.ticket.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elaundry.ticket.bean.TicketBeanI;
import elaundry.ticket.model.Ticket;

@SuppressWarnings("serial")
@WebServlet("/ticket/*")
public class TicketAction extends HttpServlet {
	
	private Ticket ticket;
	
	@EJB
	private TicketBeanI ticketBean;
	
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
		
		Ticket ticket = new Ticket();
		
		if(request.getParameter("id") != null 
				&& !request.getParameter("id").equals("undefined"))
			ticket.setId(Long.parseLong(request.getParameter("id")));
		
		ticket.setTitle(request.getParameter("title"));
		ticket.setReportedby(request.getParameter("reportedby"));
		ticket.setDescr(request.getParameter("descr"));
		ticket.setStatus(request.getParameter("status"));
		ticket.setAssign(request.getParameter("assign"));
	
		ticketBean.add(ticket);
		
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long clientId = Long.parseLong(request.getParameter("id"));
		ticketBean.delete(clientId);
		
	}
	
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(ticketBean.listInJson());
	}
	
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(ticketBean.load(Long.parseLong(request.getParameter("id"))));
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	

}
