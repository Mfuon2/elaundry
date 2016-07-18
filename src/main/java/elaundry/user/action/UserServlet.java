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
import elaundry.user.model.User;

@SuppressWarnings("serial")
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

	@EJB
	private UserBeanI userBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		this.list(resp);
	}

	private void list(HttpServletResponse resp) 
			throws ServletException,IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		User user = new User();
		user.setFullname(request.getParameter("fullname"));
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		//user.setPhone(Long.parseLong(request.getParameter("phonenumber")));
		//user.setUsertype(request.getParameter("usertype"));
		
		PrintWriter writer = response.getWriter();
		RequestDispatcher rq = request.getRequestDispatcher("login.jsp");
		try {
			
			userBean.create(user);
			
			//writer.println("<pre>Register Success<pre>");
			
		} catch (Exception e) {
			
			writer.println("<pre>Some Errror "+ e.getMessage()+"<pre>");
		}	
				
				
	}

}
