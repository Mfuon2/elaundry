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

import elaundry.user.bean.UserBeanI;

@SuppressWarnings("serial")
@WebServlet("/main")
public class UserLogin extends HttpServlet {
	
	@EJB
	private UserBeanI userBean;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
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
				
			}else{
				respons.println("<p> Invalid Login</p>");
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			respons.println("<p>An error occured: "+e.getMessage()+"</p>");
		}
	}

}
