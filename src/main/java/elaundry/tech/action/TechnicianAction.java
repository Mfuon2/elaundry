package elaundry.tech.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elaundry.tech.bean.TechnicianBeanI;
import elaundry.tech.model.Technician;

@SuppressWarnings("serial")
@WebServlet("/technician/*")
public class TechnicianAction extends HttpServlet {

	
	private Technician techs;
	
	@EJB	
	private TechnicianBeanI technicianBean;
	
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
		
		Technician tech = new Technician();
		
		if(request.getParameter("id") != null 
				&& !request.getParameter("id").equals("undefined"))
			tech.setId(Long.parseLong(request.getParameter("id")));
		
		tech.setFullname(request.getParameter("fullname").toUpperCase());
		tech.setNationalid(Long.parseLong(request.getParameter("nationalid")));
		tech.setEmail(request.getParameter("email"));
		
		String techid = request.getParameter("techid");
		String firstLetter = String.valueOf(techid.charAt(0));
		
		if(firstLetter.equals("T")){
			tech.setTechid(request.getParameter("techid").toUpperCase());
			
		}else{
			tech.setTechid("TCN"+ request.getParameter("techid").toUpperCase());
			
		}
		
		String phoneNo = request.getParameter("phoneNo");
		String firstChar = String.valueOf(phoneNo.charAt(0));
		
		if(firstChar.equals("+")){
			tech.setPhoneNo(request.getParameter("phoneNo").toUpperCase());
			
		}else{
			tech.setPhoneNo("+254"+request.getParameter("phoneNo").toUpperCase());
			
		}
		
		technicianBean.add(tech);
		
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long techId = Long.parseLong(request.getParameter("id"));
		System.out.println("what is the ID ===>>>>" + techId);
		technicianBean.delete(techId);
		
	}
	
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(technicianBean.listInJson());
        
	}
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
		resp.println(technicianBean.load(Long.parseLong(request.getParameter("id"))));
	}

	public Technician getTechs() {
		return techs;
	}

	public void setTechs(Technician techs) {
		this.techs = techs;
	}
}
	
