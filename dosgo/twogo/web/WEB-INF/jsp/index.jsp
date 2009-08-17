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

        <!-- comprobación de Browser -->


  <!--[if lt IE 7]>
  <div style='border: 1px solid #F7941D; background: #FEEFDA; text-align: center; clear: both; height: 75px; position: relative;'>
    <div style='position: absolute; right: 3px; top: 3px; font-family: courier new; font-weight: bold;'><a href='#' onclick='javascript:this.parentNode.parentNode.style.display="none"; return false;'><img src='http://www.ie6nomore.com/files/theme/ie6nomore-cornerx.jpg' style='border: none;' alt='Cierra este aviso'/></a></div>
    <div style='width: 640px; margin: 0 auto; text-align: left; padding: 0; overflow: hidden; color: black;'>
      <div style='width: 75px; float: left;'><img src='http://www.ie6nomore.com/files/theme/ie6nomore-warning.jpg' alt='¡Aviso!'/></div>
      <div style='width: 275px; float: left; font-family: Arial, sans-serif;'>
        <div style='font-size: 14px; font-weight: bold; margin-top: 12px;'>Usted está usando un navegador obsoleto.</div>
        <div style='font-size: 12px; margin-top: 6px; line-height: 12px;'>Para navegar mejor por este sitio, por favor, actualice su navegador.</div>
      </div>
      <div style='width: 75px; float: left;'><a href='http://www.mozilla-europe.org/es/firefox/' target='_blank'><img src='http://www.ie6nomore.com/files/theme/ie6nomore-firefox.jpg' style='border: none;' alt='Get Firefox 3.5'/></a></div>
      <div style='width: 75px; float: left;'><a href='http://www.microsoft.com/downloads/details.aspx?FamilyID=341c2ad5-8c3d-4347-8c03-08cdecd8852b&DisplayLang=es' target='_blank'><img src='http://www.ie6nomore.com/files/theme/ie6nomore-ie8.jpg' style='border: none;' alt='Get Internet Explorer 8'/></a></div>
      <div style='width: 73px; float: left;'><a href='http://www.apple.com/es/safari/download/' target='_blank'><img src='http://www.ie6nomore.com/files/theme/ie6nomore-safari.jpg' style='border: none;' alt='Get Safari 4'/></a></div>
      <div style='float: left;'><a href='http://www.google.com/chrome?hl=es' target='_blank'><img src='http://www.ie6nomore.com/files/theme/ie6nomore-chrome.jpg' style='border: none;' alt='Get Google Chrome'/></a></div>
    </div>
  </div>
  <![endif]-->





    </body>
</html>
