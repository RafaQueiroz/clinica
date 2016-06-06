<%-- 
    Document   : med.jsp
    Created on : 20/05/2016, 01:28:59
    Author     : rafaelqueiroz
--%>

<%@page import="conexao.UsuarioCrud"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="classes.Exame"%>
<%@page import="classes.Conexao"%>
<%@page import="classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Médico</title>
        <script src="/javascript/main.js"></script>
    </head>
    <body>
        <%
            List<Exame> exames = new ArrayList<Exame>();
            Usuario usr = (Usuario) request.getSession().getAttribute("usr");            
            exames = UsuarioCrud.buscaExame(usr.getNome());
        %>
        <h1 align="center">Olá, doutor <%= usr.getNome()%></h1>
        
        <table align="center" cellspacing="2" cellpadding="5" border="1">
            <tr>
                <th>Data</th>
                <th>Exame</th>
                <th>Preparação</th>
            </tr>
            <%
                for(Exame ex : exames){
                    if(ex.getPrioridadeExame() == 1)
                        out.println("<tr style='background-color:yellow;'>");
                    else if(ex.getPrioridadeExame() == 0)
                        out.println("<tr style='background-color:red;'>");
                    else
                        out.println("<tr style='background-color:green;'>");
                    out.println("<td>"+ex.getDataExame()+"</td>");
                    out.println("<td>"+ex.getNomeExame()+"</td>");
                    out.println("<td>"+ex.getExamePrep()+"</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <a href="home.jsp">Voltar</a>
        
    </body>
</html>
