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
        Usuario usr = (Usuario) request.getAttribute("usr");
    %>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/main.js"/>
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
            <%@page import="./includes/menu.jsp"%>
        </div>
        <div>
            <h1>Bem vindo a sua Home</h1>
        </div>
    </body>
</html>
