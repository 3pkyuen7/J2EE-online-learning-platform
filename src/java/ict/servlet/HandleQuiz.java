/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.quiz;
import ict.db.SectionDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ljp85
 */
@WebServlet(name = "HandleQuiz", urlPatterns = {"/HandleQuiz"})
public class HandleQuiz extends HttpServlet {
    private SectionDB db;
    
    @Override
    public void init() {
        String dbUrl, dbUser, dbPassword;
        dbUrl = this.getServletContext().getInitParameter("dbUrl");
        dbUser = this.getServletContext().getInitParameter("dbUser");
        dbPassword = this.getServletContext().getInitParameter("dbPassword");
        db = new SectionDB(dbUrl, dbUser, dbPassword);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
   protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String targetURL = "";
        String [] output=new String[2];
        String action = request.getParameter("action");
        int id= Integer.parseInt(action);
        quiz q = db.getQuizDB(id);
        request.setAttribute("quiz", q);
        if(db.checkDoneQuiz(q.getQuizID(),"123")){
            output[0]="\""+db.getMark(q.getQuizID(),"123")+"\"";
            output[1]="\""+q.getQuizID()+"\"";
            request.setAttribute("output", output);
            targetURL = "Student\\quizResult.jsp";
        }
        else
            targetURL = "Student\\displayQuiz.jsp";
        forwardTo(targetURL, request, response);

    }
   
   private void forwardTo(String targetURL, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
}
