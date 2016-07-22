package elaundry.clientreport.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elaundry.clientreport.bean.ClientReportBeanI;
import elaundry.ticket.model.Ticket;

@WebServlet("/repoticket/*")
public class ClientsReport extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private Ticket ticket;

	
	@EJB
	private ClientReportBeanI clientsReportBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter resp = response.getWriter();
		
		String [] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Ticket ticket = new Ticket();
		
		if(req.getParameter("id") != null 
				&& !req.getParameter("id").equals("undefined"))
			
			ticket.setId(Long.parseLong(req.getParameter("id")));
		
		ticket.setTitle(req.getParameter("title").toUpperCase());
		ticket.setReportedby(req.getParameter("reportedby"));
		ticket.setPriority(req.getParameter("priority"));
		ticket.setDescr(req.getParameter("descr"));
		
		clientsReportBean.add(ticket);
				
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	

}
