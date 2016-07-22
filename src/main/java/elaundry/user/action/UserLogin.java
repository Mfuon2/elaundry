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
			
		String username, password, usertype;
		username = request.getParameter("username");
		password = request.getParameter("password");
		usertype = request.getParameter("usertype");
		
		PrintWriter respons = response.getWriter();
		Boolean status;
		
		status = userBean.login(username, password, usertype);
		HttpSession session = request.getSession();
        session.setAttribute("user", username);
		
		try {
			if(status == true){
				System.out.println("+++++++++++++++++++++++++++++++++++"+usertype+"+++++++++++++++");
				
				if("admin".equals(usertype)){	
				RequestDispatcher req = request.getRequestDispatcher("index.jsp");
				req.forward(request, response);  
				}
				
				if("tech".equalsIgnoreCase(usertype)){
					RequestDispatcher req = request.getRequestDispatcher("tech.jsp");
					req.forward(request, response);
					
					
				}
				if("client".equalsIgnoreCase(usertype)){
					
					RequestDispatcher req = request.getRequestDispatcher("client.jsp");
					req.forward(request, response);
					
				}
				
			}else{
				
				respons.println("<p> Invalid Login</p>");
				
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			respons.println("<p>An error occured: "+e.getMessage()+"</p>");
		}
	}
}
