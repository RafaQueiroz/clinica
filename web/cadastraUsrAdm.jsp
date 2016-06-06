<%-- 
    Document   : cadastraUsrAdm
    Created on : 05/06/2016, 15:22:27
    Author     : rafaelqueiroz
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastra Usuario | ADM</title>
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
        <div>
            <%@include file="/includes/menu.jsp"%>
        </div>
        <div class="container">
            <h1>Cadastro de Usuários</h1>
            <form action="CadastraUsrAdm" method="post">
                <label>Nome:
                    <input type="text" name="nomeUsr">
                </label>
                <label>E-mail:
                    <input type="text" name="emailUsr">
                </label>
                <label>Senha:
                    <input type="password" name="senhaUsr">
                </label>
                <select name="tipoUsr">
                    <option value="1">Usuario</option>
                    <option value="3">Administrador</option>
                    <option value="4">Médico</option>
                </select>
                <input type="submit" name="cadastraUsr">
            </form>
        </div>
    </body>
</html>
