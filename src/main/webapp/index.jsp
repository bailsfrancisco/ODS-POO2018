<%-- 
    Document   : login
    Created on : 19/10/2018, 11:17:53
    Author     : bailsfrancisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/js/script.js"></script>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1><center><h2><u>Iniciar sesión</u></h2></center>
            <form action="/ODS-POO2018-TP3/loginController" method="post" name="form" onsubmit="return validateLogin();">
                <label>E-mail</label>
                <input type="text" name="email" placeholder="Ingresar e-mail"/> <br>
                <label>Password</label>
                <input type="password" name="password" placeholder="Ingresar password"/> <br>
                <input type="submit" value="Ingresar"/>

            </form> </h1>
    </body>
</html>