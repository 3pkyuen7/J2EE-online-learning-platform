<%-- 
    Document   : quizResult
    Created on : Nov 28, 2017, 3:01:14 PM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quiz Result</h1>
        <% 
            String [] output =(String [])request.getAttribute("output");
            out.print("The quiz mark is "+output[0]+ " of total 100.");
        %>
    </body>
</html>
