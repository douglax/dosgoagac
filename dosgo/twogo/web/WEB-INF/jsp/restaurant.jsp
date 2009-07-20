<%-- 
    Document   : restaurant
    Created on : Jul 19, 2009, 8:14:38 PM
    Author     : alex
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
        <title>Detalle del Restaurant</title>
    </head>
    <body>
        <div id="main">
            <twogo:header/>

            <div id="detail">
               <div id="logoandrate">
                   <img src="testimages/logodominos.png">

               </div>

               <div id="info">
                   <div id="description">
                       Bajo la premisa de "Si no te llega en 30 minutos es grátis"
                       Dominos Pizza se ha convertido en uno de los restaurantes de
                       comida rápida preferidos de los chihuahuenses en lo que a pizzas se refiere.
                       Con su gran variedad de pizzas y postres, Domino's Pizza
                       es una excelente opción para ese antojo delicioso y sin duda rápido! <br>
                       <hr>
                       <div id="directions">
                           <strong>Sucursal:</strong><br>
                           <strong>Dirección:</strong><br>
                           Av. Mirador #1234<br>
                           Col. Mirador<br>
                           <hr>
                           <strong>Horarios:</strong><br>
                           lunes a viernes de 11:00 a 22:00<br>
                           <hr>
                           Si cuenta con servicio a domicilio<br>
                           <hr>
                           <strong>Sitio web:</strong><br>
                           <a href="http://www.dominospizza.com.mx">http://www.dominospizza.com.mx</a>
                           

                       </div>
                       <div id="rest_picture">
                           <img src="testimages/dominospic.png"><br>
                           Teléfonos: (614) 410-7035<br>
                           01-800-DOMINOS
                       </div>
                   </div>



               </div>



            </div>


            <div id="lowerband">
                <div id="leftcol">
                    lineas<br>
                    lineas<br>
                    lineas<br>
                    lineas<br>
                    lineas<br>
                </div>
                <div id="rightcol">
                    lineas<br>
                    lineas<br>
                    lineas<br>
                    lineas<br>
                    lineas<br>
                </div>


            </div>

            <div id="footer">
                footer
            </div>
        </div>
    </body>
</html>
