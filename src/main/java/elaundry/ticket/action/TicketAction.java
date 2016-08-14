package elaundry.ticket.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elaundry.ticket.bean.TicketBeanI;
import elaundry.ticket.model.Ticket;
import elaundry.tickets.days.NumberOfDays;

@SuppressWarnings("serial")
@WebServlet("/ticket/*")
public class TicketAction extends HttpServlet {
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
	
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
		ticket.setPriority(request.getParameter("priority"));
		String dateValue = request.getParameter("postdate");
		
		String today = df.format(new Date());
		Date d3 = new Date();
		Date d4 = new Date();
		Date d5 = new Date();
						
		if(dateValue.equals(null) || dateValue.equals("null") & dateValue.isEmpty() || dateValue.length() <= 4){
			ticket.setPostdate(today);
			Calendar cal3 = Calendar.getInstance();cal3.setTime(d3);
			Calendar cal4 = Calendar.getInstance();cal4.setTime(d4);
		   Long days = NumberOfDays.daysBetween(cal3, cal4);
		   System.out.println("========================================"+days);
		   ticket.setDays(days);
		
		}else{
			Date postdate;
			try {
				postdate = df.parse(dateValue);
				
				Calendar cal3 = Calendar.getInstance();cal3.setTime(postdate);
				Calendar cal4 = Calendar.getInstance();cal4.setTime(d5);
			   Long days = NumberOfDays.daysBetween(cal3, cal4);
			   System.out.println("========================================"+days);
			   
			   ticket.setDays(days);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ticket.setPostdate(dateValue);
			
		}
		
		ticket.setUpdatetime(today);
		String updater = request.getSession().getAttribute("user").toString().toUpperCase();
		ticket.setUpdatedby(updater);
		
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
