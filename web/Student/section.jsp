<%-- 
    Document   : session.jsp
    Created on : Nov 24, 2017, 10:43:44 PM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.Section"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>aaaa</h1>
        <%

            ArrayList<Section> sections = (ArrayList<Section>) request.getAttribute("sections");
            out.println("<h1>Sections</h1>");
            out.println("<table border='0' >");
            
            out.println("<tr>");
            // out.println("<th>CustId</th> <th> name</th><th> tel</th><th> age</th >");
            out.println("</tr>");
            // loop through the customer array to display each customer record'
            for (int i = 0; i < sections.size(); i++) {
                if(i==0)
                    out.println("<hr>");
                Section c = sections.get(i);
                out.println("<tr><td>");
                out.println("<h3>" + c.getTitle() + "</h3>" + c.getContent());
                if(c.getQuizID()!=0)
                    out.println("<p><a href='HandleQuiz?action=" + c.getQuizID() + "'>Quiz</a></p>");
                out.println("<hr></td></tr>");
            }
            out.println("</table>");

        %>
    </body>
</html>
