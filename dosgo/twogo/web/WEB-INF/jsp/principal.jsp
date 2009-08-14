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
        <script src="js/round.js" type="text/javascript"></script>
        <script src="js/niftycube.js" type="text/javascript"></script>

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
            <div class="gray-bar"></div>
            <div id="content">
                <div id="leftcol">
                    <div class="round">
                        B&uacute;squeda R&aacute;pida                        
                    </div>
                    <div class="box" style="width:350px">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <form>
                                <table>
                                    <tbody>
                                        <tr>
                                            <td style="font-size:large; font-weight:bold">Restaurante</td>
                                            <td><input type="text" name="rest" value="" size="20" /></td>
                                        </tr>
                                        <tr>
                                            <td style="font-size:large; font-weight:bold">Alg&uacute;n antojo?</td>
                                            <td><input type="text" name="some" value="" size="20" /></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <input type="submit" value="Buscar" />
                            </form>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>
                    <div class="round">
                        B&uacute;squeda por zona                        
                    </div>
                    <div class="box">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <img src="images/mapa.png" width="372" height="225" alt="mapa"/>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>
                    <div class="round">Restaurante del Mes</div>
                </div>
                <div id="rightcol">
                    <div class="round">
                        B&uacute;squeda por categor&iacute;a                        
                    </div>
                    <div class="box">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <table>
                                <tr>
                                    <td>
                                        <a href="#">Asiatica</a>
                                    </td>
                                    <td>
                                        <a href="#">Mexicana</a>
                                    </td>
                                    <td>
                                        <a href="#">Italiana</a>
                                    </td>
                                </tr>
                                <tr>

                                    <td>
                                        <a href="#">Rapida</a>
                                    </td>
                                    <td>
                                        <a href="#">Vegetariana</a>
                                    </td>
                                    <td>
                                        <a href="#">Hamburguesas</a>
                                    </td>

                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Hamburguesas</a>
                                    </td>
                                    <td>
                                        <a href="#">Pizzas</a>
                                    </td>
                                    <td>
                                        <a href="#">Casera</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Naturista</a>
                                    </td>
                                    <td>
                                        <a href="#">Oriental</a>
                                    </td>
                                    <td>
                                        <a href="#">Postres</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Saludable</a>
                                    </td>
                                    <td>
                                        <a href="#">Sushi</a>
                                    </td>
                                    <td>
                                        <a href="#">Mediterraneo</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Francesa</a>
                                    </td>
                                    <td>
                                        <a href="#">Saluble</a>
                                    </td>
                                    <td>
                                        <a href="#">Pollo</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Francesa</a>
                                    </td>
                                    <td>
                                        <a href="#">Saluble</a>
                                    </td>
                                    <td>
                                        <a href="#">Pollo</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Japonesa</a>
                                    </td>
                                    <td>
                                        <a href="#">Pastas</a>
                                    </td>
                                    <td>
                                        <a href="#">Cortes Finos</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Tostadas</a>
                                    </td>
                                    <td>
                                        <a href="#">Pannini</a>
                                    </td>

                                </tr>
                            </table>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>
                    <div class="round-gray" style="margin-top:15px">Los mas Visitados</div>
                    <div class="box" style="width:350px">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <table>
                                <tr>
                                    <td>
                                        <a href="#">Asiatica</a>
                                    </td>
                                    <td>
                                        <a href="#">Mexicana</a>
                                    </td>
                                    <td>
                                        <a href="#">Italiana</a>
                                    </td>
                                </tr>
                                <tr>

                                    <td>
                                        <a href="#">Rapida</a>
                                    </td>
                                    <td>
                                        <a href="#">Vegetariana</a>
                                    </td>
                                    <td>
                                        <a href="#">Hamburguesas</a>
                                    </td>

                                </tr>
                            </table>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>
                    <div class="round-gray">Los mas Nuevos</div>
                    <div class="box" style="width:350px">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <table>
                                <tr>
                                    <td>
                                        <a href="#">Barrigas</a>
                                    </td>
                                    <td>
                                        <a href="#">Apple's Bees</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Garufa</a>
                                    </td>

                                </tr>
                            </table>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>
                    <div class="round-gray">Los mas Comentados</div>
                    <div class="box" style="width:350px">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <table>
                                <tr>
                                    <td>
                                        <a href="#">Barrigas</a>
                                    </td>
                                    <td>
                                        <a href="#">Apple's Bees</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="#">Garufa</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>
                </div>
                <br/>
            </div>
            <twogo:footer/>
        </div>
    </body>
</html>
