/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ict.servlet;

import ict.bean.Module;
import ict.bean.UserInfo;
import ict.db.UserDB;
import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ljp85
 */

@WebServlet(name = "loginServlet", urlPatterns = {"/main"})

public class LoginController extends HttpServlet {

    private UserDB db;

    public UserDB getDb() {
        return db;
    }

    @Override
    public void init() {
        String dbUrl, dbUser, dbPassword;
        dbUrl = this.getServletContext().getInitParameter("dbUrl");
        dbUser = this.getServletContext().getInitParameter("dbUser");
        dbPassword = this.getServletContext().getInitParameter("dbPassword");
        db = new UserDB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (!isAuthenticated(request) && !("authenticate".equals(action))) {
            doLogin(request, response);
            return;
        }
        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        } else if ("logout".equals(action)) {
            doLogout(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        return request.getSession().getAttribute("userInfo") != null;
    }

    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String role="";
        String targetURL = "";
        boolean isValid = db.isValidUser(username, password);
        if (isValid) {
                HttpSession session = request.getSession(true);
            UserInfo bean = new UserInfo();
            //bean.setUsername(username);
            //bean.setPassword(password);
            bean=db.checkUserRole(username, password);
            session.setAttribute("userInfo", bean);
            System.out.println(role);
            
            if(bean.getRole().equals("A"))
                targetURL = "Admin\\Admin.jsp";
            else if(bean.getRole().equals("T")){
                ArrayList<Module> modules = db.queryModule();
                request.setAttribute("modules", modules);
                targetURL = "Teacher\\TeacherModule.jsp";
            }else if(bean.getRole().equals("S")){
                 ArrayList<Module> modules = db.queryModule(username);
                request.setAttribute("modules", modules);
                targetURL = "Student\\StudentModule.jsp";
            }
        }else{
            targetURL = "loginError.jsp?" + username + "&pass" + password;
        }
        forwardTo(targetURL, request, response);
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String targetURL = "login.jsp";
        forwardTo(targetURL, request, response);
    }

    private void forwardTo(String targetURL, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userInfo");
            session.invalidate();
        }
        doLogin(request, response);
    }


}


