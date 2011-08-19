<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Administracion.aspx.vb" Inherits="cee.Administracion" %>
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
                        <div class="menu-bg-default" id="menu_items" runat="server">
                            <div style="width: 220px; float: left;">
                                <div class="menu-title">Administracion</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Administracion/Alta.aspx')">Alta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Administracion/Baja.aspx')">Baja</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('../Default.aspx')">Regresar...</div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

    <asp:Label ID="LblError" runat="server" ForeColor="#FF3300"></asp:Label>
    </form>

</body>
</html>
