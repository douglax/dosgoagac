<%-- 
    Document   : principal
    Created on : 13/07/2009, 12:12:13 PM
    Author     : caguirre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="twogo" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
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
                <twogo:flash/>
            </div>
            <div class="gray-bar"></div>
            <div id="content">
                <div id="leftcol">
                    <div class="round">
                        B&uacute;squeda R&aacute;pida                        
                    </div>
                    <div class="box" style="width:350px; background-color:#fff">
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
                    <div class="box" style="background-color:#fff">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <img src="images/mapa.png" width="372" height="225" alt="mapa"/>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>                    
                </div>
                <div id="rightcol">
                    <div class="round">
                        B&uacute;squeda por categor&iacute;a                        
                    </div>
                    <div class="box" style="width:350px; background-color:#fff">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <table>
                                <tr>
                                    <c:forEach var="cat" items="${categorias}"  varStatus="i">
                                        <c:if test="${(i.index mod 3) eq 0}">
                                        </tr>
                                        <tr>
                                        </c:if>
                                        <td>
                                            <a href="busqueda.htm?cat=${cat.id}">${cat.descripcion}</a>
                                        </td>
                                    </c:forEach>
                                </tr>
                            </table>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>


                    <div class="round-gray">
                        Los mas Visitados
                    </div>
                    <div class="box" style="width:350px; background-color:#fff">
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
                    <div class="round-gray">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        Los mas Comentados
                    </div>
                    <div class="box" style="width:350px">

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
                <div id="delmes">
                    <div class="round">
                        Restaurante del mes
                    </div>
                    <div class="box" style="width:650px">
                        <b class="tc"><b class="L1"></b><b class="L2"></b><b class="L3"></b></b>
                        <div class="content">
                            <img src="images/apple.png" width="156" height="152" alt="apple"/>
                            <div id="review">
                                <h2>Applebee's: Neighborhood & Friends</h2>
                                <p>
                                    &nbsp;
                                </p>
                                <p>
                                    Con una variedad de platillos muy extensa y un ambiente
                                    inigualable, este mes nos dimos a la tarea de ir con ojo
                                    crítico a uno de los restaurantes preferidos de los chihuahuenses
                                    y nos llevamos varias sorpresas! te invitamos a conocerlas...
                                    <a href="#">Seguir leyendo</a>
                                </p>
                            </div>
                        </div>
                        <b class="bc"><b class="L3"></b><b class="L2"></b><b class="L1"></b></b>
                    </div>
                    <div id="promo">
                        <img src="images/promo-free.png" width="196" height="140" alt="promo-free"/>
                    </div>
                </div>
                <br/>                
            </div>
            <twogo:footer/>
        </div>
    </body>
</html>
