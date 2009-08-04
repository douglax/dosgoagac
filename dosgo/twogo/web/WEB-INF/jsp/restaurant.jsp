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
        <script src="js/round.js" type="text/javascript"></script>
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
            <div id="content">
                <div class="round" style="text-align:center">
                    Domino's Pizza
                </div>
                <div>
                <div id="detail">
                    <div id="logoandrate">
                        <img src="testimages/logodominos.png">
                    </div>
                    <div id="info">
                        <div id="description">
                            <p><b>Descripcion General:</b></p>
                            <p/>
                            Bajo la premisa de "Si no te llega en 30 minutos es grátis"
                            Dominos Pizza se ha convertido en uno de los restaurantes de
                            comida rápida preferidos de los chihuahuenses en lo que a pizzas se refiere.
                            Con su gran variedad de pizzas y postres, Domino's Pizza
                            es una excelente opción para ese antojo delicioso y sin duda rápido! <br/>
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
                                <br> otra linea y
                                <br> otra linea
                            </div>
                            <div id="rest_picture">
                                <img src="testimages/dominospic.png"/><br>
                                Teléfonos: (614) 410-7035<br>
                                01-800-DOMINOS
                            </div>
                        </div>
                    </div>
                    <div class="cleared"></div>
                </div>
                
                </div>
                    <div id="onlinemenucategories">
                        <div id="logomenuonline">
                            <img src="images/btn_menuonline.png"/>
                        </div>
                        <div id="category">
                            <ul>
                                <li><a href="#">Entradas</a>
                                <li><a href="#">Pizzas</a>
                                <li><a href="#">Pastas</a>
                                <li><a href="#">Postres</a>
                                <li><a href="#">Bebidas</a>
                            </ul>
                        </div>

                    </div>
                
                <table border=2 width="100%" align="center">
                    <tr>
                        <td>A</td>
                        <td>B</td>
                        <td>C</td>
                    </tr>
                    <tr>
                        <td>D</td>
                        <td>E</td>
                        <td>F</td>
                    </tr>
                    <tr>
                        <td>G</td>
                        <td>H</td>
                        <td>I</td>
                    </tr>
                </table>


          <div id="lowerband">
                <div id="leftcol">

                     <form>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>Restaurante</td>
                                        <td><input type="text" name="rest" value="" size="20" /></td>
                                    </tr>
                                    <tr>
                                        <td>Alg&uacute;n antojo?</td>
                                        <td><input type="text" name="some" value="" size="20" /></td>
                                    </tr>
                                </tbody>
                            </table>
                            <input type="submit" value="Buscar" />
                        </form>


                </div>

                <div id="rightcol">
                    <img align="center" src="images/losmas2go.png" alt="losmas2go" height="50" ><br>

                    <table align="center" width="100%" >
                        <tr align="center" bgcolor="lightgrey">
                            <td><b>Los más visitados</b></td>
                        <td><b>Los más nuevos</b></td>
                        <td><b>Los más comentados</b></td>
                        </tr>
                        <tr>
                            <!-- los mas visitados -->
                            <td><a href="#">Barrigas </a><br>
                                <a href="#">Applebee's </a><br>
                                <a href="#">Chilangos </a><br>
                                <a href="#">Rosa Canela </a><br>
                                <a href="#">Sushi Land </a><br></td>

                            <!-- los mas nuevos -->
                            <td><a href="#">DiMerlo</a><br>
                                <a href="#">ComeCamila </a><br>
                                <a href="#">Burger King </a><br>
                                <a href="#">Starbucks </a><br>
                                <a href="#">Bernardis </a><br></td>

                            <!-- los mas comentados -->
                            <td><a href="#">El Portón </a><br>
                                <a href="#">Applebee's </a><br>
                                <a href="#">Las Tapas </a><br>
                                <a href="#">Rosa Canela </a><br>
                                <a href="#">La Casa del Dragón </a><br></td>
                        </tr>
                    </table>

                </div>


            </div>


 
                    <div class="cleared"></div>
                
            </div>
            <div id="footer">
                <!--<div>
                    <b class="rbottom"><b class="r1"/><b class="r2"/><b class="r3"/><b class="r4"/></b>
                    uy uy
                    <b class="rbottom"><b class="r4"/><b class="r3"/><b class="r2"/><b class="r1"/></b>
                </div>-->
                footer
            </div>
        </div>
    </body>
</html>
