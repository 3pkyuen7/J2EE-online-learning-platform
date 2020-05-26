<%-- 
    Document   : asignQuestionToQuiz
    Created on : Nov 30, 2017, 8:20:37 PM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.QuestionBean"%>
<%@page import="ict.bean.quiz"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% quiz qu =(quiz)request.getAttribute("quizInfo");%>
        <a href="HandleShowQuizList" >Back To Quiz List</a>
        <table><tr><td>
        <form action='HandleCreateQuiz' method='get' >
            quizName:  <% out.println(qu.getQuizName()); %><br>
          <input type="submit" value="Create" />
           <input type="reset" value="Reset"/>
           <%
            
            ArrayList<QuestionBean> QuizQuestions =(ArrayList<QuestionBean> )request.getAttribute("AssignQuestion");
            out.println("<table border='1'>");
            out.println("<tr><th>Question ID</th><th>Content</th><th>Option A</th><th>Option B</th><th>Option C</th><th>Option D</th><th>Answer</th><th>Remove</th></tr>");
            for (int i = 0; i < QuizQuestions.size(); i++) {
                QuestionBean c = QuizQuestions.get(i);
                out.println("<td>"+c.getQuesID()+"</td>");
                out.println("<td>"+c.getContent()+"</td>");
                out.println("<td>A."+c.getOptionA()+"</td>");
                out.println("<td>B."+c.getOptionB()+"</td>");
                out.println("<td>C."+c.getOptionC()+"</td>");
                out.println("<td>D."+c.getOptionD()+"</td>");
                out.println("<td>Answer:"+c.getAnswer()+"</td>");
                out.println("<td><a href='HandleRemoveQuestion?quesID="+c.getQuesID()+"&qID="+qu.getQuizID() +"' />Remove</a></tr>");
            }   
            out.println("</table>");
           %>
           
           
        </form>
        </td>
            <td>
                <a href="Teacher//AddQuestion.jsp?id=<% out.println(qu.getQuizID()); %>" >Add Question</a>
         <form action='HandleAddQuesToQuiz' method='get' >
             <input type="text" name='quizID' value="<% out.println(qu.getQuizID()); %>" />
        <%
            
            ArrayList<QuestionBean> questions =(ArrayList<QuestionBean> )request.getAttribute("UnAssignQuestion");
          //  int t= (int)request.getAttribute("timeSet");
            out.println("<table border='1'>");
            out.println("<tr><th>Assign To Quiz</th><th>Question ID</th><th>Content</th><th>Option A</th><th>Option B</th><th>Option C</th><th>Option D</th><th>Answer</th><th>Remove</th></tr>");
            for (int i = 0; i < questions.size(); i++) {
                QuestionBean c = questions.get(i);
                out.println("<tr><td><input type='checkbox' name='Q' value="+c.getQuesID()+" /></td>");
                out.println("<td>"+c.getQuesID()+"</td>");
                out.println("<td>"+c.getContent()+"</td>");
                out.println("<td>A."+c.getOptionA()+"</td>");
                out.println("<td>B."+c.getOptionB()+"</td>");
                out.println("<td>C."+c.getOptionC()+"</td>");
                out.println("<td>D."+c.getOptionD()+"</td>");
                
                out.println("<td>Answer:"+c.getAnswer()+"</td>");
                out.println("<td><a href='HandleRemoveQuestion2?quesID="+c.getQuesID()+"&qID="+qu.getQuizID() +"' />Remove</a></tr>");
            }
            out.println("</table>");
           %>
           <input type="submit"/>
           </form>
           </td></tr></table>
    </body>
</html>
