package elaundry.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import elaundry.user.bean.UserBeanI;

@SuppressWarnings("serial")
@WebServlet("/main")
public class UserLogin extends HttpServlet {
	
	@EJB
	private UserBeanI userBean;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			
		String username, password;
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		PrintWriter respons = response.getWriter();
		Boolean status;
		RequestDispatcher req = request.getRequestDispatcher("index.jsp");
		
		try {
			status = userBean.login(username, password);
			
			if(status == true){
				req.forward(request, response);
				 HttpSession session = request.getSession();
		            session.setAttribute("user", username);
		            session.setAttribute("user", username);
		            System.out.println("Session set +++++++++++++++++++++++++++++++++++++++++++++");
		            
				
			}else{
				
				respons.println("<p> Invalid Login</p>");
				System.out.println("" +password +"  "+username);
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			respons.println("<p>An error occured: "+e.getMessage()+"</p>");
		}
	}
}
