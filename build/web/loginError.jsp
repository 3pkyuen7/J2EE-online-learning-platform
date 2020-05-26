<%-- 
    Document   : loginError
    Created on : Nov 14, 2017, 10:44:16 AM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error</title>
    </head>
    <body>
        <p>Incorrect Password</p>
        <p>
             <% out.print(" <a href=\"" + request.getContextPath() + "/main\">Login again</a>");%> 
        </p>
    </body>
</html>
