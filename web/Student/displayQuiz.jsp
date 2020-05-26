<%-- 
    Document   : displayQuiz
    Created on : Nov 27, 2017, 5:53:21 PM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ict.bean.quiz"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            quiz q =(quiz)request.getAttribute("quiz");
            out.println("<h1>Quiz</h1>");
            out.println("<p>Quiz ID :"+q.getQuizID()+"</p>");
            out.println("<p>Time limit :"+q.getRequestTime()+" mins</p>");
            out.println("<p>quiz Number :"+q.getAttemptAmount()+" </p>");
            %>

            <form action="./HandleQuestion" method="get" >
                <input type="text" name="timeSet" value=<% out.print(q.getRequestTime()); %> hidden />
                <input type="text" name="action" value=<% out.print(q.getQuizID()); %> hidden />
                <input type="submit" value="Start" />
            </form>
    </body>
</html>
