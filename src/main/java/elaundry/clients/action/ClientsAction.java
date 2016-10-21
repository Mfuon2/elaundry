package elaundry.clients.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elaundry.clients.bean.ClientsBeanI;
import elaundry.clients.model.Clients;

@SuppressWarnings("serial")
@WebServlet("/clients/*")
public class ClientsAction extends HttpServlet {

    private Clients clients;

    @EJB
    private ClientsBeanI clientsBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] pathCmp = request.getRequestURI().split("/");
        String path = pathCmp[pathCmp.length - 1];

        if (path.equalsIgnoreCase("load"))
            this.load(request, response);
        else
            this.list(response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Clients client = new Clients();

        if (request.getParameter("id") != null
                && !request.getParameter("id").equals("undefined"))
            client.setId(Long.parseLong(request.getParameter("id")));

        client.setFullname(request.getParameter("fullname").toUpperCase());
        client.setEmail(request.getParameter("email"));

        String nationalid = request.getParameter("nationalid");
        String firstLet = String.valueOf(nationalid.charAt(0));

        if (firstLet.equals("S"))
            client.setNationalid(request.getParameter("nationalid").toUpperCase());
        else
            client.setNationalid("KEN" + request.getParameter("nationalid").toUpperCase());

        String clientid = request.getParameter("clientid");
        String firstLetter = String.valueOf(clientid.charAt(0));
        if (firstLetter.equals("C"))
            client.setClientid(request.getParameter("clientid").toUpperCase());
        else
            client.setClientid("CLNT" + request.getParameter("clientid").toUpperCase());

        String phoneNo = request.getParameter("phoneNo");
        String firstChar = String.valueOf(phoneNo.charAt(0));
        if (firstChar.equals("+"))
            client.setPhoneNo(request.getParameter("phoneNo").toUpperCase());
        else
            client.setPhoneNo("+254 " + request.getParameter("phoneNo").toUpperCase());

        clientsBean.add(client);

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long clientId = Long.parseLong(request.getParameter("id"));
        clientsBean.delete(clientId);

    }

    private void list(HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter resp = response.getWriter();
        resp.println(clientsBean.listInJson());
    }

    private void load(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter resp = response.getWriter();
        resp.println(clientsBean.load(Long.parseLong(request.getParameter("id"))));
    }


}
