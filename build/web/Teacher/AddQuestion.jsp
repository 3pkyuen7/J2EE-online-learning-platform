<%-- 
    Document   : AddQuestion
    Created on : Dec 3, 2017, 1:01:54 AM
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
        <% int id= Integer.parseInt(request.getParameter("id")); %>
        <form action='../../HandleAddQuestion' method='get'>
            <input type='text' name='id' value='<% out.println(id); %>'  hidden />
            Content:<input type='text' name='content' required /><br/>
            Option A : <input type='text' name='A'  required /><br/>
            Option B : <input type='text' name='B' required /><br/>
            Option C : <input type='text' name='C' required /><br/>
            Option D : <input type='text' name='D'  required /><br/>
            Answer: <Select   name='Answer' required >
                        <option value='A'>A</option>
                         <option value='C'>B</option>
                         <option value='B'>C</option>
                           <option value='D'>D</option>
                        </select>
            <br/>
            <input type='submit' value='Add'/>
            <input type='reset' />
        </form>
    </body>
</html>
