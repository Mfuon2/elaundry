package elaundry.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException ,IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("REdirected");
		response.sendRedirect("login.jsp");
		return;
		
		
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			
		String username, password, usertype;
		username = request.getParameter("username");
		password = request.getParameter("password");
		usertype = request.getParameter("usertype");
		
		MessageDigest md;
		try {
			
			md = MessageDigest.getInstance("SHA-256");
			String text = password;
			md.update(text.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String sha = String.format("%064x", new java.math.BigInteger(1, digest));
		
		PrintWriter respons = response.getWriter();
		Boolean status;
		
		status = userBean.login(username, sha, usertype);
		HttpSession session = request.getSession();
        session.setAttribute("user", username);
		
		try {
			if(status == true){
				System.out.println("+++++++++++++++++++++++++++++++++++"+usertype+"+++++++++++++++");
				
				if("support".equals(usertype) || "admin".equals(usertype)){	
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
				
				respons.println("<script type='text/javascript'>"
						+ "alert(\"Invalid Login Credentials OR Contact Admin for Account Activation\");"
						+ "window.location=\"http://localhost:8080/elaundry/\";"
						+ "</script>");
				
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			respons.println("<p>An error occured: "+e.getMessage()+"</p>");
		}
		
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
	}
}
