

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="handleCustomer?action=search">
            <input type="hidden" name="action" value="search">
            Search User ID: <br/>
            <input type="text" name="name" value=""/>
            <input type="submit" value="search"/>
        </form>
    </body>
</html>
