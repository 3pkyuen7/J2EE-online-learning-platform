<%-- 
    Document   : welcome.jsp
    Created on : Nov 14, 2017, 10:47:53 AM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.Module"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="HandleShowQuizList" >Create quiz</a><br>
<br><br><br>
        <form action="HandleSearchModule" method="get" >
            <table>
                <tr><td>Search Course : </td><td><input type="text" name="keyword" /></td></tr>
                <tr><td>Search By : </td><td>
                            <select name="searchBy">
                            <option value="moduleID">ID</option>
                            <option value="Title">Name</option>
                          </select>
                </td></tr>
                <tr align="right"><td><input type="submit" value="Search" /></td><td><a href="HandleSearchModule?action=all"><button>All</button></a></td></tr>
            </table>
        </form>
        <h1>Teacher</h1>
         <%

            ArrayList<Module> modules =(ArrayList<Module> )request.getAttribute("modules");
            out.println("<h1>Modules</h1>");
            out.println("<table border='0' >");
            out.println("<tr>");
           
            
            out.println("</tr>");
            // loop through the customer array to display each customer record
            for (int i = 0; i < modules.size(); i++) {
                Module c = modules.get(i);
                out.println("<tr>");
                out.println("<td><h3><a href=\"TeacherHandleSection?action="+c.getModuleID()+"\" >" + c.getModuleID() + " "+c.getTitle()+ "</a></h3>Teacher : "+c.getTeacherName()+"</td>");

                out.println("</tr>");
            }
            out.println("</table>");
      
           %>
    </body>
</html>
