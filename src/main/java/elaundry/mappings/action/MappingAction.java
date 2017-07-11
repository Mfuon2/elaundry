package elaundry.mappings.action;

import elaundry.user.bean.UserBeanI;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by root on 10/21/16.
 */
@SuppressWarnings("serial")
@WebServlet("/mappings/*")
public class MappingAction extends HttpServlet {

    @EJB
    private UserBeanI userBean;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] pathCmp = request.getRequestURI().split("/");
        String path = pathCmp[pathCmp.length - 1];
        if (path.equalsIgnoreCase("users")) {
            this.listInactive(request, resp);
        }
    }

    private void listInactive(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter print = resp.getWriter();
        print.println(userBean.listInJson());
    }
}
