<%-- 
    Document   : login
    Created on : Nov 14, 2017, 10:34:35 AM
    Author     : ljp85
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

           <form action="./main" method="post" >
            <input type='hidden' name="action" value='authenticate'/>
            <table border="0">
                <tr>
                    <td><p align="right"><b>login:</b></td>
                    <td><p><input type="text" name="username"></p></td>
                </tr>
                <tr>
                    <td><p align="right"><b>passsword:</b></td>
                    <td><p><input type="password" name="password" ></td>
                </tr>
                <tr>
                    <td colspan="2"><p align="center"><input type="submit" value="Login"></p></td>
                </tr>
            </table>
        </form>
    </body>
</html>
