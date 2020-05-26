<%-- 
    Document   : addQuiz
    Created on : Dec 2, 2017, 7:12:17 PM
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
        <form action='../../HandleQuizAdd' method='get'>
            Quiz Name:<input type='text' name='quizName' required /><br/>
            Question Amount : <input type='number' name='qN' required /><br/>
            Request Time(minute) : <input type='number' name='rT' required /><br/>
            <input type='submit' value='Add'/>
            <input type='reset' />
        </form>
    </body>
</html>
