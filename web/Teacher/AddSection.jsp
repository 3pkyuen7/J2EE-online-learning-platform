<%-- 
    Document   : AddSection
    Created on : Dec 3, 2017, 3:25:49 AM
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
         <% String mId= request.getParameter("mId"); %>
        <form action='../../HandleAddSection' method='get'>
            <input type='text' name='mId' value='<% out.println(mId); %>'  hidden />
            Title<input type='text' name='title' required /><br/>
            Content : <input type='text' name='content'  required /><br/>
            
            <br/>
            <input type='submit' value='Add'/>
            <input type='reset' />
        </form>
    </body>
</html>
