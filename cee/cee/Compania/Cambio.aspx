<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Cambio.aspx.vb" Inherits="cee.Cambio1" %>
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
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Alta.aspx')">Alta</div>
                                <div class="menu-item-selected" onclick="menuItemClick('Cambio.aspx')">Modificar</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Baja.aspx')">Baja</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('../Default.aspx')">Regresar...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Modificar Compañia</div>
                                <div class="contenido">
                                    <form id="Form1" runat="server">
                                        <div class="form-items">
                                            <asp:Panel ID="grp_busqueda" runat="server" Visible="false">
                                                <asp:Panel ID="pnl_busqueda" runat="server">
                                                    <div class="form-item">
                                                        <div class="form-item-nombre">
                                                            <asp:Label ID="lbl_busqueda_nombre" runat="server" Text="Nombre:" Width="125" CssClass="labels-busqueda"></asp:Label>
                                                            <asp:TextBox ID="tb_busqueda_nombre" runat="server" Width="250"></asp:TextBox>
                                                        </div>
                                                        <div class="form-item-btn">
                                                            <asp:Button ID="btn_busqueda" runat="server" Text="Buscar" />
                                                        </div>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_resultados" runat="server">
                                                    <div class="subtitulo">Compañias:</div>
                                                    <div class="form-item">
                                                        <asp:GridView ID="dg_resultados" runat="server" AutoGenerateColumns="False" 
                                                            Font-Size="Small" Width="469px">                             
                                                            <Columns>
                                                                <asp:HyperLinkField DataNavigateUrlFields="Id" 
                                                                    DataNavigateUrlFormatString="Cambio.aspx?id={0}" DataTextField="Nombre" 
                                                                    HeaderText="Nombre de la Compañia" />
                                                            </Columns>
                                                        </asp:GridView>
                                                    </div>
                                                </asp:Panel>
                                            </asp:Panel>
                                            <asp:Panel ID="grp_consultar" runat="server">
                                                <asp:Panel ID="pnl_consultar" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_consultar" runat="server" Text="Num. de Compañia:" Width="150" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_consultar" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="*" ControlToValidate="tb_consultar" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                        <asp:Button ID="btn_consultar" runat="server" Text="Consultar"  ValidationGroup="Name_Group"/>
                                                        <asp:Button ID="btn_consultar_popup" runat="server" Text="..." />
                                                    </div>
                                                </asp:Panel>
                                            </asp:Panel>
                                            <asp:Panel ID="grp_modificar" runat="server" Visible="false">
                                                <asp:Panel ID="pnl_nombre" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_nombre" runat="server" Text="Compañía:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_nombre" runat="server" Width="248px" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ControlToValidate="tb_nombre" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_direccion" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_direccion" runat="server" Text="Direccion:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_direccion" runat="server" Width="248px" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ControlToValidate="tb_direccion" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
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
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="*" ControlToValidate="ddl_ciudad" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                                <asp:Panel ID="pnl_guardar" runat="server">
                                                    <div class="form-item-btn">
                                                        <asp:Button ID="btn_guardar" runat="server" Text="Guardar" ValidationGroup="Name_Group"/>
                                                    </div>
                                                </asp:Panel>
                                            </asp:Panel>
                                            <div>
                                                <asp:Label ID="lblResultado" runat="server" Font-Bold="True" ForeColor="#33CC33"></asp:Label>
                                            </div>
                                        </div>
                                        <asp:HiddenField ID="HiddenField1" runat="server" />
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
