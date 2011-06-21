<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Alta.aspx.vb" Inherits="cee.Alta1" %>
<html>
<head>
    <link rel=StyleSheet href="../cee.css" type="text/css">
    <script src="../cee.js"></script>
</head>
<body>
    <form id="form1" runat="server">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td style="vertical-align: middle;">
            <table style="margin: auto;" width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <div style="padding: 0px 30px 0px 0px;">
                             <img src="../Imagenes/logotipo.jpg" border="0" align="left"/>
                             <img src="../Imagenes/enlace.jpg" border="0" align="right"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="height: 150px; background: #eeeeee; font: normal 9pt tahoma; border-top: 1px #dddddd solid; border-bottom: 1px #dddddd solid; padding: 30px 40px 30px 80px; position: relative;">
                            <div style="width: 220px; float: left;">
                                <div class="menu-title">Compañia</div>
                                <div class="menu-item-selected">Alta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Cambio.aspx')">Modificar</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Baja.aspx')">Baja</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('../Default.aspx')">Regresar...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Alta Compañia</div>
                                <div class="contenido">
                                    <table cellpadding="10" cellspacing="10">
                                        <tr>
                                            <td>
                                                <label for="txtNombre">Nombre de la Compañía </label>
                                            </td>
                                            <td>                                                
                                                <asp:TextBox ID="txtNombre" runat="server" Width="248px"></asp:TextBox>                                                
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="txtDireccion">Dirección </label>
                                            </td>
                                            <td>                                                
                                                <asp:TextBox ID="txtDireccion" runat="server" Width="248px" Height="41px" 
                                                    Rows="3"></asp:TextBox>                                                
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="txtCiudad">Ciudad </label>
                                            </td>
                                            <td>                                                
                                                <asp:TextBox ID="txtCiudad" runat="server" Width="248px"></asp:TextBox>                                                
                                            </td>
                                        </tr>
                                    </table>
                                    <div>                                    
                                        <asp:Button ID="Button1" runat="server" Text="Guardar" />
                                    </div>
                                    <div>
                                        
                                        <asp:Label ID="lblResultado" runat="server" Font-Bold="True" 
                                            ForeColor="#33CC33"></asp:Label>
                                        
                                    </div>
                                </div>
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
