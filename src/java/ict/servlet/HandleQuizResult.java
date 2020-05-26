/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.db.SectionDB;
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
@WebServlet(name = "HandleQuizResult", urlPatterns = {"/HandleQuizResult"})
public class HandleQuizResult extends HttpServlet {
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
        String [] output= new String[2];
        String questionNo = request.getParameter("questionNo");
        String quizNo = request.getParameter("quizNo");
        int QN= Integer.parseInt(questionNo);
        int QuizN= Integer.parseInt(quizNo);
        double rightNo=0;
        for(int i=1; i<=QN;i++){
           if((request.getParameter("A"+i)).equals(request.getParameter("Q"+i)))
                rightNo++;
        }

        int countMark=(int)Math.round(rightNo/QN*100);
        output[0]="\""+countMark+"\"";
        output[1]="\""+QuizN+"\"";
        request.setAttribute("output", output);
        
        if(db.quizResult(countMark,QuizN,"123")){
        targetURL = "Student\\quizResult.jsp";
        forwardTo(targetURL, request, response);
        }

    }
   
   private void forwardTo(String targetURL, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
}
