<%-- 
    Document   : index
    Created on : Jul 6, 2009, 6:51:25 PM
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen,projection" type="text/css" href="css/main.css" />
        
        <script src="js/jquery-latest.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("table#locations").fadeIn("slow");
            });            
        </script>

        <title>::: www.2go.com.mx ::: Comida en un clíc!</title>
    </head>
    <body>
        <div><img src="images/logo_letras.png" width="582" height="97" alt="logo_letras"/>
        </div>
        <div><img src="images/logo2go.png" width="573" height="256" alt="logo2go"/>
        </div>
        <div><img src="images/chuletas.png" width="611" height="124" alt="chuletas"/>
        </div>
        <div id="welcome">
            BIENVENIDO<br/>
            Selecciona tu ciudad:
        </div>
        <table id="locations">
            <tr>
                <td><a href="principal.htm?loc=chihuahua">Chihuahua</a></td>
                <td><a href="#">Juárez</a></td>
                <td><a href="#">Monterrey</a></td>
            </tr>
        </table>
    </body>
</html>
