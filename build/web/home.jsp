<%-- 
    Document   : home
    Created on : 28/05/2016, 10:34:29
    Author     : rafael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <style>
            .menu-top li{
                display:none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <nav class="menu-top">
                <ul>
                    <li class="adm"><a href="cadastraUsrAdm.html">Cadastro de Usuario</a></li>
                    <li class="adm"><a href="cadastraExame.html">Cadastro de Exame</a></li>
                    <li class="usr"><a href="agendaUsr.jsp">Agenda de Consultas</a></li>
                    <li class="med"><a href="agendaMed.jsp">Agenda Médico</a></li>
                </ul>
            </nav>
        </div>
        <script>
            $(document).ready(function(){
                    exibeMenu(determinaTipo(0));        
            });
            
            function determinaTipo(tipoNum){
                switch(tipoNum){
                    case 0: 
                        return 'adm';
                        break;
                    case 1:
                        return 'med';
                        break;
                    default:
                        return 'usr';
                        break;
                }
            }
            
            function exibeMenu(tipo){
             
               $('li').each(function(i){
                                       
                    if($(this).hasClass(tipo)){
                        $(this).css('display','inline-block');
                    }
               });           

            }
        </script>
    </body>
</html>
