<%-- 
    Document   : home
    Created on : 28/05/2016, 10:34:29
    Author     : rafael
--%>

<%@page import="classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        HttpSession sessao = (HttpSession) request.getSession();
        Usuario usr = (Usuario) sessao.getAttribute("usr");
        
    %>
    <head>
        <title>Clinica</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="main.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="./javascript/main.js"></script>
        <script>
            $(document).ready(function(){
                 exibeMenu(determinaTipo(<%= usr.getTipo()%>));        
            });
        </script>
    </head>
    <body>
        <div class="container">
            <%@include file="includes/menu.jsp"%>
        </div>
        <div>
            <h1>Bem vindo a sua Home</h1>
        </div>
        <a href="index.html">Logout</a>
    </body>
</html>
