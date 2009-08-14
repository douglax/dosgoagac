<%-- 
    Document   : busqueda
    Created on : Jul 15, 2009, 12:24:36 PM
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
        <link rel="stylesheet" type="text/css" href="css/multicolumns.css"/>

        <style type="text/css">
            body{
                background-image:url('images/bg.png');
            }
        </style>
        <script src="js/css3-multi-column.js" type="text/javascript"></script>
        <script src="js/jquery-latest.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("div#banner").fadeIn("slow");
            });
        </script>
        <title>Resultados de la busqueda</title>
    </head>
    <body>
        <div id="main">
            <twogo:header/>

            <div class="round">
                Resultados
            </div><br>

            <strong>Resultados para</strong><br>

            Estilos de cocina: <a href="#">Pizzas</a> <br>
 


            <div id="searchresultspanel">





                <div class="twocols">


                    <!-- Inicia prueba con tabla -->


                    <!-- comienza resultBox1 -->
                    <table width="300" cellpadding="0" cellspacing="0" border="0"
                           style="background-color: #FFFFFF" align="center">
                        <tr>
                            <td width="16"><img src="images/wbcorner1.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                            <td width="268" colspan="2" style="background-image: url('images/topmargin.png');"  >
                                <!--            <img src="images/blank.png" width="1" height="16" border="0" alt="..." />  -->
                            </td>

                            <td width="16"><img src="images/wbcorner2.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                        </tr>

                        <tr>

                            <td style="background-image: url('images/ltmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                            <!-- celda para logo y calificación-->
                            <td align="center"> <img src="testimages/logodominos.png" width="95" height="95" alt="logorestaurant" /> <br>
                                <img src="testimages/stars.png" alt="calificacion">
                            </td>


                            <!-- celda para información-->
                            <td>
                                <font color="#f7730" size="2"><strong>Domino's Pizza</strong></font><br>
                                Sucursal: <br>
                                <hr>
                                Domicilio:<br>
                                Av. Mirador# 3425<br>
                                Col. Mirador<br>
                                <hr>
                                Tel.- 410-70-35<br>
                                <hr>
                                <a href="busqueda.htm#">Ver micrositio</a>
                            </td>

                            <td style="background-image: url('images/rtmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                        </tr>

                        <tr>

                            <td><img src="images/wbcorner3.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                            <td colspan="2" style="background-image: url('images/botmargin.png');">
                                <!--         <img src="images/blank.png" width="1" height="16" border="0" alt="..." />     -->
                            </td>

                            <td><img src="images/wbcorner4.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                        </tr>
                    </table>
                    <!-- termina resultBox1 -->

                    <br>

                    <!-- comienza resultBox2 -->
                    <table width="300" cellpadding="0" cellspacing="0" border="0"
                           style="background-color: #FFFFFF" align="center">
                        <tr>
                            <td width="16"><img src="images/wbcorner1.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                            <td width="268" colspan="2" style="background-image: url('images/topmargin.png');"  >
                                <!--            <img src="images/blank.png" width="1" height="16" border="0" alt="..." />  -->
                            </td>

                            <td width="16"><img src="images/wbcorner2.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                        </tr>

                        <tr>

                            <td style="background-image: url('images/ltmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                            <!-- celda para logo y calificación-->
                            <td align="center"> <img src="testimages/logoPeterPiper.png" width="95" height="95" alt="logorestaurant" /> <br>
                                <img src="testimages/stars.png" alt="calificacion">
                            </td>


                            <!-- celda para información-->
                            <td>
                                <font color="#f7730" size="2"><strong>Peter Piper Pizza</strong></font><br>
                                Sucursal: <br>
                                <hr>
                                Domicilio:<br>
                                Av. Mirador# 3425<br>
                                Col. Mirador<br>
                                <hr>
                                Tel.- 410-70-35<br>
                                <hr>
                                <a href="busqueda.htm#">Ver micrositio</a>
                            </td>

                            <td style="background-image: url('images/rtmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                        </tr>

                        <tr>

                            <td><img src="images/wbcorner3.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                            <td colspan="2" style="background-image: url('images/botmargin.png');">
                                <!--         <img src="images/blank.png" width="1" height="16" border="0" alt="..." />     -->
                            </td>

                            <td><img src="images/wbcorner4.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                        </tr>
                    </table>
                    <!-- termina resultBox2 -->

                    <br>

                    <!-- comienza resultBox3 -->
                    <table width="300" cellpadding="0" cellspacing="0" border="0"
                           style="background-color: #FFFFFF" align="center">
                        <tr>
                            <td width="16"><img src="images/wbcorner1.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                            <td width="268" colspan="2" style="background-image: url('images/topmargin.png');"  >
                                <!--            <img src="images/blank.png" width="1" height="16" border="0" alt="..." />  -->
                            </td>

                            <td width="16"><img src="images/wbcorner2.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                        </tr>

                        <tr>

                            <td style="background-image: url('images/ltmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                            <!-- celda para logo y calificación-->
                            <td align="center"> <img src="testimages/logoPizzaHut.png" width="95" height="95" alt="logorestaurant" /> <br>
                                <img src="testimages/stars.png" alt="calificacion">
                            </td>


                            <!-- celda para información-->
                            <td>
                                <font color="#f7730" size="2"><strong>Pizza Hut</strong></font><br>
                                Sucursal: <br>
                                <hr>
                                Domicilio:<br>
                                Av. Mirador# 3425<br>
                                Col. Mirador<br>
                                <hr>
                                Tel.- 410-70-35<br>
                                <hr>
                                <a href="busqueda.htm#">Ver micrositio</a>
                            </td>

                            <td style="background-image: url('images/rtmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                        </tr>

                        <tr>

                            <td><img src="images/wbcorner3.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                            <td colspan="2" style="background-image: url('images/botmargin.png');">
                                <!--         <img src="images/blank.png" width="1" height="16" border="0" alt="..." />     -->
                            </td>

                            <td><img src="images/wbcorner4.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                        </tr>
                    </table>
                    <!-- termina resultBox3 -->

                    <br>

                    <!-- comienza resultBox4 -->
                    <table width="300" cellpadding="0" cellspacing="0" border="0"
                           style="background-color: #FFFFFF" align="center">
                        <tr>
                            <td width="16"><img src="images/wbcorner1.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                            <td width="268" colspan="2" style="background-image: url('images/topmargin.png');"  >
                                <!--            <img src="images/blank.png" width="1" height="16" border="0" alt="..." />  -->
                            </td>

                            <td width="16"><img src="images/wbcorner2.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                        </tr>

                        <tr>

                            <td style="background-image: url('images/ltmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                            <!-- celda para logo y calificación-->
                            <td align="center"> <img src="testimages/logoPizzadelRey.png" width="95" height="95" alt="logorestaurant" /> <br>
                                <img src="testimages/stars.png" alt="calificacion">
                            </td>


                            <!-- celda para información-->
                            <td>
                                <font color="#f7730" size="2"><strong>Pizza del Rey</strong></font><br>
                                Sucursal: <br>
                                <hr>
                                Domicilio:<br>
                                Av. Mirador# 3425<br>
                                Col. Mirador<br>
                                <hr>
                                Tel.- 410-70-35<br>
                                <hr>
                                <a href="busqueda.htm#">Ver micrositio</a>
                            </td>

                            <td style="background-image: url('images/rtmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                        </tr>

                        <tr>

                            <td><img src="images/wbcorner3.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                            <td colspan="2" style="background-image: url('images/botmargin.png');">
                                <!--         <img src="images/blank.png" width="1" height="16" border="0" alt="..." />     -->
                            </td>

                            <td><img src="images/wbcorner4.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                        </tr>
                    </table>
                    <!-- termina resultBox4 -->

                    <br>

                    <!-- comienza resultBox5 -->
                    <table width="300" cellpadding="0" cellspacing="0" border="0"
                           style="background-color: #FFFFFF" align="center">
                        <tr>
                            <td width="16"><img src="images/wbcorner1.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                            <td width="268" colspan="2" style="background-image: url('images/topmargin.png');"  >
                                <!--            <img src="images/blank.png" width="1" height="16" border="0" alt="..." />  -->
                            </td>

                            <td width="16"><img src="images/wbcorner2.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                        </tr>

                        <tr>

                            <td style="background-image: url('images/ltmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                            <!-- celda para logo y calificación-->
                            <td align="center"> <img src="testimages/logodominos.png" width="95" height="95" alt="logorestaurant" /> <br>
                                <img src="testimages/stars.png" alt="calificacion">
                            </td>


                            <!-- celda para información-->
                            <td>
                                <font color="#f7730" size="2"><strong>Domino's Pizza</strong></font><br>
                                Sucursal: <br>
                                <hr>
                                Domicilio:<br>
                                Av. Mirador# 3425<br>
                                Col. Mirador<br>
                                <hr>
                                Tel.- 410-70-35<br>
                                <hr>
                                <a href="busqueda.htm#">Ver micrositio</a>
                            </td>

                            <td style="background-image: url('images/rtmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                        </tr>

                        <tr>

                            <td><img src="images/wbcorner3.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                            <td colspan="2" style="background-image: url('images/botmargin.png');">
                                <!--         <img src="images/blank.png" width="1" height="16" border="0" alt="..." />     -->
                            </td>

                            <td><img src="images/wbcorner4.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                        </tr>
                    </table>
                    <!-- termina resultBox5 -->

                    <br>

                    <!-- comienza resultBox6 -->
                    <table width="300" cellpadding="0" cellspacing="0" border="0"
                           style="background-color: #FFFFFF" align="center">
                        <tr>
                            <td width="16"><img src="images/wbcorner1.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                            <td width="268" colspan="2" style="background-image: url('images/topmargin.png');"  >
                                <!--            <img src="images/blank.png" width="1" height="16" border="0" alt="..." />  -->
                            </td>

                            <td width="16"><img src="images/wbcorner2.png" width="16"
                                                height="16" border="0" alt="..." /></td>

                        </tr>

                        <tr>

                            <td style="background-image: url('images/ltmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                            <!-- celda para logo y calificación-->
                            <td align="center"> <img src="testimages/logodominos.png" width="95" height="95" alt="logorestaurant" /> <br>
                                <img src="testimages/stars.png" alt="calificacion">
                            </td>


                            <!-- celda para información-->
                            <td>
                                <font color="#f7730" size="2"><strong>Domino's Pizza</strong></font><br>
                                Sucursal: <br>
                                <hr>
                                Domicilio:<br>
                                Av. Mirador# 3425<br>
                                Col. Mirador<br>
                                <hr>
                                Tel.- 410-70-35<br>
                                <hr>
                                <a href="busqueda.htm#">Ver micrositio</a>
                            </td>

                            <td style="background-image: url('images/rtmargin.png');">
                                <img src="images/blank.png" width="16" height="1" border="0" alt="..." />
                            </td>

                        </tr>

                        <tr>

                            <td><img src="images/wbcorner3.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                            <td colspan="2" style="background-image: url('images/botmargin.png');">
                                <!--         <img src="images/blank.png" width="1" height="16" border="0" alt="..." />     -->
                            </td>

                            <td><img src="images/wbcorner4.png" width="16" height="16"
                                     border="0" alt="..." /></td>

                        </tr>
                    </table>
                    <!-- termina resultBox6 -->

                    <!-- Termina prueba con tabla -->


                    <!-- pruebas con imagenes
                                        <img src ="testimages/searchresult1.png" alt="searchresults" /><br><br>
                                        <img src ="testimages/searchresult2.png" alt="searchresults" /><br><br>
                                        <img src ="testimages/searchresult3.png" alt="searchresults" /><br><br>
                                        <img src ="testimages/searchresult4.png" alt="searchresults" /><br><br>
                                        <img src ="testimages/searchresult4.png" alt="searchresults" /><br><br>
                                        <img src ="testimages/searchresult1.png" alt="searchresults" /><br><br>
                                        <img src ="testimages/searchresult2.png" alt="searchresults" /><br><br>
                                        <img src ="testimages/searchresult3.png" alt="searchresults" /><br><br>
                    -->

                </div>  <!-- searchresults -->

            </div> <!-- searchresultspanel -->



            <twogo:lowerband/>

            <twogo:footer/>
        </div>
    </body>
</html>
