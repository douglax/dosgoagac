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
                                            <asp:Panel ID="Panel1" runat="server">
                                                <asp:Label ID="labelClub" runat="server" Text="Club:" Width="130" CssClass="labels"></asp:Label>
                                                <asp:DropDownList ID="club" runat="server" AutoPostBack="True"></asp:DropDownList>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_nombre" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_nombre" runat="server" Text="Nombre:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_nombre" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ControlToValidate="tb_nombre" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_apaterno" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_apaterno" runat="server" Text="Apellido Paterno:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_apaterno" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ControlToValidate="tb_apaterno" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
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
