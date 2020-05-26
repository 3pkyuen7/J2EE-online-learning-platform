<%-- 
    Document   : AddSectionQuiz
    Created on : Dec 3, 2017, 4:44:10 AM
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
        <% int sId= Integer.parseInt(request.getParameter("sectionID")); %>
         <% String mId=request.getParameter("mId"); %>
        <form action='HandleSectionAddQuiz' method='get'>
            
            <input type='text' name='sId' value='<% out.println(sId); %>'  hidden />
            <input type='text' name='mId' value='<% out.println(mId); %>'  hidden />

            <% 
               ArrayList<quiz> quizs =(ArrayList<quiz> )request.getAttribute("quizs");
               out.println("<select name='quizID' >");
               for (int i = 0; i < quizs.size(); i++) {
                quiz c = quizs.get(i);
                out.println("<option value="+c.getQuizID()+" >"+c.getQuizName()+" </option> ");
               }
               out.println("</select>");
            %>
            
           
            <br/>
            <input type='submit' value='Add'/>
            <input type='reset' />
        </form>
    </body>
</html>
