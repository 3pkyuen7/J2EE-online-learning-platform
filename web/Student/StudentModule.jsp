<%-- 
    Document   : StudentModule
    Created on : Nov 20, 2017, 11:21:19 PM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.Module"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Module</title>
    </head>
    <body>
        <h1>Student!</h1>
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
        <%! ArrayList<Module> modules; %>
        <%

            modules =(ArrayList<Module> )request.getAttribute("modules");
            out.println("<h1>Modules</h1>");
            out.println("<table border='0' >");
            out.println("<tr>");
           
            
            out.println("</tr>");
            // loop through the customer array to display each customer record
            for (int i = 0; i < modules.size(); i++) {
                Module c = modules.get(i);
                out.println("<tr>");
                out.println("<td><h3><a href=\"HandleSection?action="+c.getModuleID()+"\" >(" + c.getModuleID() + ") "+c.getTitle()+ "</a></h3>Teacher : "+c.getTeacherName()+"</td>");

                out.println("</tr>");
            }
            out.println("</table>");
      
           %>
    </body>
</html>
