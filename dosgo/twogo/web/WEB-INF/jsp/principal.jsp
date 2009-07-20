<%-- 
    Document   : principal
    Created on : 13/07/2009, 12:12:13 PM
    Author     : caguirre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="twogo" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
        <style type="text/css">
            body{
                background-image:url('images/bg.png');
            }
        </style>
        <script src="js/jquery-latest.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("div#banner").fadeIn("slow");
            });
        </script>
        <title>Bienvenido!!</title>
    </head>
    <body>
        <div id="main">

            <twogo:header/>

            <div id="flash">
                    <img src="images/flash.png" width="756" height="230" alt="flash"/>
            </div>
            <div id="content">
                content<br>
                <a href="busqueda.htm">Busqueda</a>  
            </div>
            <div id="footer">
                footer
            </div>
        </div>
    </body>
</html>
