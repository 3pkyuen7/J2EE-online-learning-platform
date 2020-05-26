<%-- 
    Document   : showQuizList
    Created on : Dec 2, 2017, 5:45:28 PM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.quiz"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href='Teacher//addQuiz.jsp' >Add Quiz</a>
        <%

            ArrayList<quiz> quizs =(ArrayList<quiz> )request.getAttribute("quizs");
          //  int t= (int)request.getAttribute("timeSet");
            out.println("<table border='1'>");
            out.println("<tr><th>Quiz ID</th><th>Question Name</th><th>Time Limit</th><th>Attempt Amount</th><th>Start date</th><th>End date</th><th>Module</th><th>Edit</th><th>Remove</th></tr>");
            for (int i = 0; i < quizs.size(); i++) {
                quiz c = quizs.get(i);
                out.println("<tr>");
                out.println("<td>"+c.getQuizID()+"</td>");
                out.println("<td>"+c.getQuizName()+"</td>");
                out.println("<td>"+c.getRequestTime()+"</td>");
                out.println("<td>"+c.getAttemptAmount()+"</td>");
                out.println("<td>"+c.getStartTime()+"</td>");
                out.println("<td>"+c.getEndTime()+"</td>");
                out.println("<td>"+c.getModuleId()+"</td>");
                out.println("<td><a href='HandleAddQuiz?quizID="+c.getQuizID()  +"' >Edit</a></td>");
                out.println("<td><a href='HandleRemoveQuiz?quizID="+c.getQuizID()  +"' >Remove</a></td></tr>");
            }
            out.println("</table>");
           %>
    </body>
</html>
