<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Default.aspx.vb" Inherits="cee._Default"%>
<html>
<head>
    <link rel=StyleSheet href="cee.css" type="text/css">
    <script src="cee.js"></script>
</head>
<body>
    <form id="form1" runat="server">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td style="vertical-align: middle;">
            <table style="margin: auto;" width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <div style="height: 70px; padding: 0px 30px 0px 0px;">
                             <img src="Imagenes/logotipo.jpg" border="0" align="left"/>
                             <img src="Imagenes/enlace.jpg" border="0" align="right"/>
                             <img src="Imagenes/enlace-empresarial.jpg" border="0" align="right"/>
                             <img src="Imagenes/enlace-travel.jpg" border="0" align="right"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="height: 150px; background: #eeeeee; font: normal 9pt tahoma; border-top: 1px #dddddd solid; border-bottom: 1px #dddddd solid; padding: 30px 40px 30px 80px; position: relative;">
                            <div style="width: 220px; float: left;">
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Consulta.aspx')">Consulta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Socios.aspx')">Socios</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Compania.aspx')">Compañias</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Salir.aspx')">Informes</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Salir.aspx')">Salir...</div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
    </form>
</body>
</html>


