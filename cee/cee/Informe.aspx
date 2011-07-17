<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Informe.aspx.vb" Inherits="cee.Informe" %>
<html>
<head>
    <link rel=StyleSheet href="cee.css" type="text/css">
    <script src="cee.js"></script>
</head>
<body>
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
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Consulta.aspx')">Consulta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Socios.aspx')">Socios</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Compania.aspx')">Compañias</div>
                                <div class="menu-item-selected" onclick="menuItemClick('Informe.aspx')">Informes</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Administracion.aspx')" id="menu_item_admin" runat="server" visible="false">Administracion</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Salir.aspx')">Salir...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Informe</div>
                                <div class="contenido">
                                    <form id="Form1" runat="server">
                                        <div id="cld_bg_inicio" runat="server" class="calendar-bg-inicio" visible="false">
                                            <asp:Calendar ID="cld_selector_inicio" runat="server"></asp:Calendar>
                                        </div>
                                        <div id="cld_bg_final" runat="server" class="calendar-bg-final" visible="false">
                                            <asp:Calendar ID="cld_selector_final" runat="server"></asp:Calendar>
                                        </div>
                                        <div class="form-items">
                                            <asp:Panel ID="grp_informe" runat="server">
                                                <asp:Panel ID="pnl_club" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="labelClub" runat="server" Text="Club:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:DropDownList ID="club" runat="server" AutoPostBack="True"></asp:DropDownList>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_periodo_inicio" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_periodo_inicio" runat="server" Text="Periodo Inicio:" Width="125" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_periodo_inicio" runat="server" Width="100" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ControlToValidate="tb_periodo_inicio" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                        <asp:Button ID="btn_periodo_inicio" runat="server" Text="..." />
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_periodo_final" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_periodo_final" runat="server" Text="Periodo Fin:" Width="125" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_periodo_final" runat="server" Width="100" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ControlToValidate="tb_periodo_final" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                        <asp:Button ID="btn_peridodo_final" runat="server" Text="..." />
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_informe" runat="server">
                                                    <div class="form-item-btn">
                                                        <asp:Button ID="btn_informe" runat="server" Text="Mostrar Informe..." ValidationGroup="Name_Group"/>
                                                    </div>
                                                </asp:Panel>
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
