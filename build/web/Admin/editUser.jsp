

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="c" scope="request" class ="ict.bean.UserInfo"/>
        <%
            String type = c.getUserId() != null ? "edit" : "add";
            String id = c.getUserId() != null ? c.getUserId() : "";
        %>
        <form method="get" action="handleEdit">
            <input type="hidden" name="action" value=<%=type%> />
            UserID <input name="id" type="text" value="<%=id%>" readonly ="readonly"/> <br>
            <% String Rid = Character.toString(id.charAt(0));
                if (Rid.equals("S"))
            %>
            StudentID <input name="rid" type="text" value="<%=id%>" readonly ="readonly"/> <br>
            <%else if (Rid.equals("T")%>
            TeacherID <input name="rid" type="text" value="<%=id%>" readonly ="readonly"/> <br>
            <%else if (Rid.equals("A")%>
            AdminID <input name="rid" type="text" value="<%=id%>" readonly ="readonly"/> <br>
            Name <input name="name" type="text" value="<%=c.getUsername()%>"/> <br>
            GroupID <input name="tel" type="text" value="<%=c.getGroupId()%>"/> <br>
            Age <input name="age" type="text" value="<%=c.getPassword()%>"/> <br>
            <td ><input type="submit" value="submit"/> <br>
        </form>
    </body>
</html>
