<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Alta.aspx.vb" Inherits="cee.Alta1" %>
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
                                <div class="menu-title">Compañia</div>
                                <div class="menu-item-selected" onclick="menuItemClick('Alta.aspx')">Alta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Cambio.aspx')">Modificar</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Baja.aspx')">Baja</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('../Default.aspx')">Regresar...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Alta Compañia</div>
                                <div class="contenido">
                                    <form runat="server">
                                        <div class="form-items">
                                            <asp:Panel ID="pnl_nombre" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_nombre" runat="server" Text="Compañía:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_nombre" runat="server" Width="248px" ValidationGroup="Name_Group"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="*" ControlToValidate="tb_nombre" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_giro" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_giro" runat="server" Text="Giro:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_giro" runat="server" Width="248px" ValidationGroup="Name_Group"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="*" ControlToValidate="tb_giro" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_direccion" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_direccion" runat="server" Text="Direccion:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_direccion" runat="server" Width="248px" ValidationGroup="Name_Group"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ControlToValidate="tb_direccion" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_estado" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label1" runat="server" Text="Estado:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:DropDownList ID="ddl_estado" runat="server" Width="248px" 
                                                        ValidationGroup="Name_Group" AutoPostBack="True"></asp:DropDownList>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="*" ControlToValidate="ddl_estado" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_ciudad" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_ciudad" runat="server" Text="Ciudad:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:DropDownList ID="ddl_ciudad" runat="server" Width="248px" ValidationGroup="Name_Group"></asp:DropDownList>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ControlToValidate="ddl_ciudad" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_guardar" runat="server">
                                                <div class="form-item-btn">
                                                    <asp:Button ID="btn_guardar" runat="server" Text="Guardar" ValidationGroup="Name_Group"/>
                                                </div>
                                            </asp:Panel>
                                        </div>
                                        <div>
                                            <asp:Label ID="lblResultado" runat="server" Font-Bold="True" ForeColor="#33CC33"></asp:Label>
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
