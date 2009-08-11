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


            <div id="searchresultspanel">

                <div class="twocols">

                    <img src ="testimages/searchresult1.png" alt="searchresults" /><br><br>
                    <img src ="testimages/searchresult2.png" alt="searchresults" /><br><br>
                    <img src ="testimages/searchresult3.png" alt="searchresults" /><br><br>
                    <img src ="testimages/searchresult4.png" alt="searchresults" /><br><br>
                    <img src ="testimages/searchresult4.png" alt="searchresults" /><br><br>
                    <img src ="testimages/searchresult1.png" alt="searchresults" /><br><br>
                    <img src ="testimages/searchresult2.png" alt="searchresults" /><br><br>
                   <!--
                    <img src ="testimages/searchresult3.png" alt="searchresults" /><br><br>
                   -->

                </div>  <!-- searchresults -->

            </div> <!-- searchresultspanel -->



            <twogo:lowerband/>

            <div id="footer">
                footer
            </div>
        </div>
    </body>
</html>
