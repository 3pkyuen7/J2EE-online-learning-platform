<%-- 
    Document   : listCustomer
    Created on : Nov 21, 2017, 11:26:03 AM
    Author     : a1
--%>

<%@page import="ict.db.UserDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.UserInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>list customer</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }
            th, td {
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even){background-color: #f2f2f2}
            th {
                background-color: #4CAF50;
                color: white;
            }
        </style>
    </head>
    <body>
        <%ArrayList customers
                    = (ArrayList<UserInfo>) request.getAttribute("customers");
            out.println("<h1>User List</h1>");
        %>
        <jsp:include page="UserSerach.jsp"></jsp:include></br>
        <%
            out.println("<table border='1' >");
            out.println("<tr>");
            out.println("<th>UserID</th> <th>StudID</th><th>Name</th><th>GroupID</th><th>Password</th><th></th><th></th>");
            out.println("</tr>");
            //CustomerBean a = customers.get(0);
            //out.println(a.getCustomerID());
            // loop through the customer array to display each customer record
            // out.print(c.getCustomerID());
            for (int i = 0; i < customers.size(); i++) {
                UserInfo c = (UserInfo) customers.get(i);
                //out.println(c);
                out.println("<tr>");
                out.println("<td>" + c.getUserId() + "</td>");
                out.println("<td>" + c.getRoleId() + "</td>");
                out.println("<td>" + c.getUsername() + "</td>");
                out.println("<td>" + c.getGroupId() + "</td>");
                out.println("<td>" + c.getPassword() + "</td>");
                if(c.getGroupId()==0){
                    out.println("<td><a href=\"HandleCustomer?action=deleteT&id=" + c.getUserId() + "\">delete</a></td>");
                    out.println("<td><a href=\"HandleCustomer?action=getEditTeacher&id=" + c.getUserId() + "\">edit</a></td>");
                }else{
                    out.println("<td><a href=\"HandleCustomer?action=deleteS&id=" + c.getUserId() + "\">delete</a></td>");
                    out.println("<td><a href=\"HandleCustomer?action=getEditStudent&id=" + c.getUserId() + "\">edit</a></td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
        %>
        <br><button type="button" name="back" onclick="history.back()">back</button>
    </body>
</html>
