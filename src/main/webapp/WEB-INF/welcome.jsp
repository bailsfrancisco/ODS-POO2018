<%-- 
    Document   : welcome
    Created on : 19/10/2018, 17:38:23
    Author     : bailsfrancisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import= "ar.edu.unnoba.poo2018.ods.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
    </head>
    <body>

        <h1> Hola <%= ((Usuario) session.getAttribute("user")).getEmail()%>!</h1>

    </body>
</html>
