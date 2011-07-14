<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Alta.aspx.vb" Inherits="cee.Alta2" %>
<html>
<head>
    <link rel=StyleSheet href="../cee.css" type="text/css">
    <script src="../cee.js"></script>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td style="vertical-align: middle;">
            <table style="margin: auto;" width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <div style="height: 70px; padding: 0px 30px 0px 0px;">
                             <img src="../Imagenes/logotipo.jpg" border="0" align="left"/>
                             <img src="../Imagenes/enlace.jpg" border="0" align="right"/>
                             <img src="../Imagenes/enlace-empresarial.jpg" border="0" align="right"/>
                             <img src="../Imagenes/enlace-travel.jpg" border="0" align="right"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="menu-bg-default">
                            <div style="width: 220px; float: left;">
                                <div class="menu-title">Administracion</div>
                                <div class="menu-item-selected" onclick="menuItemClick('Alta.aspx')">Alta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Baja.aspx')">Baja</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('../Default.aspx')">Regresar...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Alta Usuario</div>
                                <div class="contenido">
                                    <form id="Form1" runat="server">
                                        <div class="form-item">
                                            <asp:Panel ID="pnl_hotel" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_hotel" runat="server" Text="Hotel:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:DropDownList ID="ddl_hotel" runat="server" AutoPostBack="True"></asp:DropDownList>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_usuario" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_usuario" runat="server" Text="Usuario:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_usuario" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ControlToValidate="tb_usuario" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_apaterno" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_contrasena" runat="server" Text="Contraseña:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_contrasena" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ControlToValidate="tb_contrasena" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_guardar" runat="server">
                                                <div class="form-item-btn">
                                                    <asp:Button ID="btn_guardar" runat="server" Text="Guardar" ValidationGroup="Name_Group"/>
                                                </div>
                                            </asp:Panel>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
