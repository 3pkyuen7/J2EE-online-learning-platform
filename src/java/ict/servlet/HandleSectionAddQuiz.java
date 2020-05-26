/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.db.QuestionDB;
import java.io.IOException;
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
@WebServlet(name = "HandleSectionAddQuiz", urlPatterns = {"/HandleSectionAddQuiz"})
public class HandleSectionAddQuiz  extends HttpServlet{
    private QuestionDB db;
    
    @Override
    public void init() {
        String dbUrl, dbUser, dbPassword;
        dbUrl = this.getServletContext().getInitParameter("dbUrl");
        dbUser = this.getServletContext().getInitParameter("dbUser");
        dbPassword = this.getServletContext().getInitParameter("dbPassword");
        db = new QuestionDB(dbUrl, dbUser, dbPassword);
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
        int quizID=Integer.parseInt(request.getParameter("quizID"));
        String mId=request.getParameter("mId");
        int id=Integer.parseInt(request.getParameter("sId"));
        
        
        targetURL = "TeacherHandleSection?action="+mId;
        if(db.AddQuizFromSection(id,quizID))
            targetURL = "TeacherHandleSection?action="+mId;

        forwardTo(targetURL, request, response);

    }
   
   private void forwardTo(String targetURL, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
}
