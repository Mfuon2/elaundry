package elaundry.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elaundry.user.bean.UserBeanI;
import elaundry.user.model.User;

import static java.util.logging.Logger.*;

@SuppressWarnings("serial")
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(getClass());
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@EJB
	private UserBeanI userBean;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		//this.list(resp);
		String [] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		
		if(path.equalsIgnoreCase("load"))
			this.load(request, resp);
		else
			this.list(resp);
	}

	private void load(HttpServletRequest request, HttpServletResponse resp) 
	throws ServletException, IOException{
		PrintWriter response = resp.getWriter();
		response.println(userBean.load(Long.parseLong(request.getParameter("id"))));
		
	}

	private void list(HttpServletResponse resp) 
			throws ServletException,IOException {
		PrintWriter response = resp.getWriter();
        response.println(userBean.listInJson());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		User user = new User();
		if(request.getParameter("id") != null && !request.getParameter("id").equals("undefined"))
			user.setId(Long.parseLong(request.getParameter("id")));
		user.setFullname(request.getParameter("fullname"));
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		String password = request.getParameter("password");
		//user.setPassword(password);
        log.info(" ======================== " + user.getFullname());
        log.info(" ======================== " + user.getUsername());
        log.info(" ======================== " + user.getEmail());
        log.info(" ======================== " + user.getUsertype());
        log.info(" ======================== " + user.getPassword());
		if(password.length() > 20){
			user.setPassword(password);
		}else{
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				String text = password;
				md.update(text.getBytes("UTF-8"));
				byte[] digest = md.digest();
				String sha = String.format("%064x", new java.math.BigInteger(1, digest));
				user.setPassword(sha);
				
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			
			
		}

		if(request.getParameter("usertype") != null )
		    user.setUsertype(request.getParameter("usertype"));
        else
            user.setUsertype("InActive");

		PrintWriter writer = response.getWriter();
		RequestDispatcher rq = request.getRequestDispatcher("login.jsp");
		try {
			userBean.create(user);
		} catch (Exception e) {
			writer.println("<pre>Some Errror "+ e.getMessage()+"<pre>");
		}			
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long user = Long.parseLong(request.getParameter("id"));
		System.out.println("what is the ID ===>>>>" + user);
		userBean.delete(user);
		
	}
}
