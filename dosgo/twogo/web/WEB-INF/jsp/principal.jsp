<%-- 
    Document   : principal
    Created on : 13/07/2009, 12:12:13 PM
    Author     : caguirre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div id="banner">
                <img src="images/banner.png" width="750" height="90" alt="banner"/>
            </div>
            <div id="header">
                
                <div id="menu">
                    <ul>
                        <li><a href="#">Inicio</a></li>
                        <li><a href="#">Promociones</a></li>
                        <li><a href="#">Lo mas nuevo</a></li>
                        <li><a href="#">Anunciate aquí</a></li>
                        <li><a href="#">Contáctanos</a></li>
                    </ul>                
                </div>

                <div id="logo_principal">
                    <img src="images/logo2go_chico.png" alt="Logo 2Go"/>
                </div>               

            </div>
            <div id="flash">
                    <img src="images/flash.png" width="756" height="230" alt="flash"/>
            </div>
            <div id="content">
                content
            </div>
            <div id="footer">
                footer
            </div>
        </div>
    </body>
</html>
