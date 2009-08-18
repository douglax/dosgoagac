<%-- 
    Document   : register
    Created on : Aug 17, 2009, 6:46:36 PM
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
        <title>Usuario nuevo de 2Go</title>
    </head>
    <body>



        
        

         <div id="main">
              <twogo:header/>
           <twogo:outer_round_opens />
           
            <div class="round">
                Nuevo usuario
            </div>
           <br>

             <form action="">

                 <table border="0" width="800">


                         <tr>
                             <td width="250">Nombre de usuario:</td>
                             <td><input type="text" name="username" value="" size="20" /></td>
                         </tr>
                         <tr>
                             <td>Contraseña:</td>
                             <td><input type="password" name="password" value="" size="20" /></td>
                         </tr>
                         <tr>
                             <td>Repetir contraseña:</td>
                             <td><input type="password" name="pwdconfirm" value="" size="20" /></td>
                         </tr>
                         <tr>
                             <td>Correo Electrónico:</td>
                             <td><input type="password" name="email" value="" size="50" /></td>
                         </tr>
                         <tr>
                             <td></td>
                             <td></td>
                         </tr>
                         <tr>
                             <td></td>
                             <td></td>
                         </tr>
                         <tr>
                             <td></td>
                             <td></td>
                         </tr>
                         <tr>
                             <td></td>
                             <td><input type="submit" value="Enviar" name="enviar" /><input type="reset" value="Cancelar" name="cancel" /></td>
                         </tr>

                 </table>



             </form>

 <twogo:outer_round_closes />

         </div>

           
         
            
    </body>
</html>
