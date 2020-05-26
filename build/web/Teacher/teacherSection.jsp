<%-- 
    Document   : teacherSection
    Created on : Nov 30, 2017, 7:41:49 PM
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
        <h1>Hello World!</h1>
        <%

            ArrayList<Section> sections = (ArrayList<Section>) request.getAttribute("sections");
            String mID="";
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
                out.println("<h3>" + c.getTitle() + "<a href='HandleRemoveSection?sId="+c.getSecID()+"&mId="+c.getModuleId()+"' >Remove Section</a></h3>" + c.getContent());
              //  out.println("<p><a href='HandleAddQuiz?sectionID=" + c.getSecID() + " '>Add Quiz</a></p>");
                out.println("<p><a href='HandleAddMateria?sectionID=" + c.getSecID() + "'>Add Materia</a></p>");
                if(c.getQuizID()!=0)
                    out.println("<p><a href='HandleQuiz?action=" + c.getQuizID() + "'>Quiz</a>  <a href='HandleRemoveSectionQuiz?sectionID=" + c.getSecID() + "&mId="+c.getModuleId()+"' >remove Quiz</a>  </p>");
                else
                     out.println("<p><a href='HandleShowQuiz?sectionID=" + c.getSecID() + "&mId="+c.getModuleId()+"' >Add Quiz</a></p>");
                out.println("<hr></td></tr>");
                mID=c.getModuleId();
            }
            out.println("</table>"); 
            out.println("<a href='Teacher//AddSection.jsp?mId="+mID+"'>Add Section</a>");

        %>
    </body>
</html>
