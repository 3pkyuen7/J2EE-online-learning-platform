/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.UserInfo;
import ict.db.UserDB;
import java.io.*;
import java.util.ArrayList;
/*
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
*/

/**
 *
 * @author KKBOSS
 */

/*
@WebServlet(name = "handleEdit", urlPatterns = {"/handleEdit"})
*/
public class handleEdit {/*extends HttpServlet {

    private UserDB db;
/*
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB(dbUrl, dbUser, dbPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        int age = Integer.parseInt(request.getParameter("age"));
        if ("add".equalsIgnoreCase(action)) {
            //db.addRecord(id, name, tel, age);
            response.sendRedirect("HandleCustomer?action=list");
        } else if ("edit".equalsIgnoreCase(action)) {
            //CustomerBean cb = new CustomerBean(id, name, tel, age);
            //db.editRecord(cb);
            response.sendRedirect("HandleCustomer?action=list");
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
    }*/

}
