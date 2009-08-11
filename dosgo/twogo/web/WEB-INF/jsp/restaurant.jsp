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
            <div class="round" style="text-align:center">
                Domino's Pizza
            </div>



            <div id="detail">
                <div id="logoandrate">
                    <img src="testimages/logodominos.png" alt="logodelrestaurant" />
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
            </div>    <!-- detail -->


                <div class="cleared"></div>

                
                <twogo:outer_round_opens/>

                <div id="onlinemenucategories">
                    <div id="logomenuonline">
                        <img src="images/btn_menuonline.png" alt="boton"/>

                        <!--                 <div class="round">
                                             Men&uacute; Online
                                         </div>  -->

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

                </div>     <!-- onlinemenucategories -->


                <div id="content">

                    <div id="dishes">
                        <div id="singledish">
                            <div id="dishphoto">
                                <img  src="testimages/pizzathumb.png" alt="thumb" >
                            </div>
                            <div id="dishname">
                                Pizza Mexicana
                            </div>
                            <div id="dishdescription">
                                Nuestra exquisita pizza con un toque de lo nuestro: Chile, tomate y cebolla
                            </div>
                            <div id="dishdetails">
                                Chica $25 Mediana $35 Grande $42
                            </div>
                        </div>  <!--singledish-->

                        <div id="singledish">
                            <div id="dishphoto">
                                <img src="testimages/pizzathumb.png" alt="thumb" />
                            </div>
                            <div id="dishname">
                                Pizza Italiana
                            </div>
                            <div id="dishdescription">
                                Nuestra original pizza con peperoni, tomates deshidratados y albahaca
                            </div>
                            <div id="dishdetails">
                                Chica $25 Mediana $35 Grande $42
                            </div>
                        </div>  <!--singledish-->

                        <div id="singledish">
                            <div id="dishphoto">
                                <img src="testimages/pizzathumb.png"  alt="thumb" />
                            </div>
                            <div id="dishname">
                                Dominator
                            </div>
                            <div id="dishdescription">
                                La mas grande y deliciosa pizza que jamás encontrarás, ármala tu mismo eligiendo 4 ingredientes de nuestro menú
                            </div>
                            <div id="dishdetails">
                                Chica $25 Mediana $35 Grande $42
                            </div>
                        </div>  <!--singledish-->

                    </div>  <!--dishes-->



                </div> <!-- content -->


                <br>
            <div class="round" style="text-align:center">
                Calificaciones
            </div>


            <!-- Recuadro de última calificación -->

            <table width="400" cellpadding="0" cellspacing="0" border="0"
                                   style="background-color: #FFFFFF">
                                <tr>
                                    <td width="16"><img src="images/wbcorner1.png" width="16"
                                                        height="16" border="0" alt="..." /></td>

                                    <td width="368"  style="background-image: url('images/topmargin.png');"  >
                                        <img src="images/blank.png" width="1" height="16" border="0" alt="..." />
                                    </td>

                                    <td width="16"><img src="images/wbcorner2.png" width="16"
                                                        height="16" border="0" alt="..." /></td>

                                </tr>




                                <tr>

                                    <td style="background-image: url('images/ltmargin.png');">
                                        <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                                    </td>

                                    <td><font color="purple">Martín Domínguez</font>   </td>

                                    <td style="background-image: url('images/rtmargin.png');">
                                       <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                                    </td>

                                </tr>



                                <tr>

                                    <td style="background-image: url('images/ltmargin.png');">
                                       <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                                    </td>
                                    <td>Lunes 15 de Junio de 2009 a las 15:53:30</td>


                                    <td style="background-image: url('images/rtmargin.png');">
                                       <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                                    </td>

                                </tr>

                                





                                <tr>

                                    <td><img src="images/wbcorner3.png" width="16" height="16"
                                             border="0" alt="..." /></td>

                                    <td style="background-image: url('images/botmargin.png');">
                                        <img src="images/blank.png" width="1" height="16" border="0" alt="..." />
                                    </td>

                                    <td><img src="images/wbcorner4.png" width="16" height="16"
                                             border="0" alt="..." /></td>

                                </tr>
                            </table>


            <!-- termina recuadro de última calificación -->

         <table width="650">
             <tr><td width="75%">
            Muy buena la comida pero el restaurant se ve viejo y en mal estado, urge una remodelación
            </td>
            <td>
                <img src="testimages/stars.png" alt="stars" />
            </td>
            </tr>
        </table>
            <br>


        <!-- comienza Servicios que se ofrecen -->

        <div id="multicols">

            <strong>Estilos de Cocina</strong><br>
            <a href="restaurant#">Italiana</a><br>
            <a href="restaurant#">Pizzas</a><br>
            <a href="restaurant#">Carnes</a><br>
            <a href="restaurant#">Ensaladas</a><br>
            <a href="restaurant#">Pastas</a><br>
            <br>
            <strong>Ocasiones Especiales</strong><br>
            <a href="restaurant#">Romántica</a><br>
            <a href="restaurant#">Familiar</a><br>
            <a href="restaurant#">Negocios</a><br>
            <br>
            <strong>Servicios</strong><br>
            <a href="restaurant#">Banquetes</a><br>
            <a href="restaurant#">Comedor</a><br>
            <a href="restaurant#">Servicio a Domicilio</a><br>
            <a href="restaurant#">Para llevar</a><br>
            <a href="restaurant#">Servicio de Bar</a><br>
            <a href="restaurant#">Carta de Vinos</a><br>
            <a href="restaurant#">Salones para eventos</a><br>
            <a href="restaurant#">Servicio de Catering</a><br>
            <br>
            <strong>Necesidades Especiales</strong><br>
            <a href="restaurant#">Internet inalámbrico</a><br>
            <a href="restaurant#">Área para fumadores</a><br>
            <a href="restaurant#">Platillos Vegetarianos</a><br>
            <a href="restaurant#">Periqueras</a><br>
            <br>
            <strong>Formas de Pago</strong><br>
            <a href="restaurant#">Visa</a><br>
            <a href="restaurant#">MasterCard</a><br>
            <a href="restaurant#">American Express</a><br>
            <br>
            <strong>Entretenimiento</strong><br>
            <a href="restaurant#">Música ambiental</a><br>
            <a href="restaurant#">Televisión</a><br>
            <br>
            <strong>Vestimenta</strong><br>
            <a href="restaurant#">Casual</a><br>

            

        </div>  <!-- multicols -->

        <!-- termina Servicios que se ofrecen -->


        <br>

            <twogo:outer_round_closes/>
                
<br>



 <div class="gray-bar"></div>





            <twogo:lowerband/>

            <div class="cleared"></div>



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
