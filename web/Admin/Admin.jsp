<%-- 
    Document   : Admin
    Created on : Nov 21, 2017, 2:10:06 PM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }
            li {
                float: left;
            }
            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }
            li a:hover:not(.active) {
                background-color: #111;
            }
            .active {
                background-color: #4CAF50;
            }
        </style>
    </head>
    <body>
        <h1>Admin!</h1>
        <ul>
            <li><a href="." class="active">Home</a></li>
            <li><a href="HandleCustomer?action=listStud">Student Management</a></li>
            <li><a href="HandleCustomer?action=listTeacher">Teacher Management</a></li>
            <li><a href="HandleCustomer?action=listAll">List All Usert</a></li>
        </ul></br>
        <form method="post" action="main">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
    </body>
</html>
