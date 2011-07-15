<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Baja.aspx.vb" Inherits="cee.Baja" %>
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
                                <div class="menu-title">Socios</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Alta.aspx')">Alta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Cambio.aspx')">Modificar</div>
                                <div class="menu-item-selected" onclick="menuItemClick('Baja.aspx')">Baja</div>
                               <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('../Default.aspx')">Regresar...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Baja Socio</div>
                                <div class="contenido">
                                    <form id="Form1" runat="server">
                                        <div class="form-items">
                                            <asp:Panel ID="grp_busqueda" runat="server">
                                                <asp:Panel ID="pnl_busqueda" runat="server">
                                                    <div class="form-item">
                                                        <div class="form-item-nombre">
                                                            <asp:Label ID="lbl_busqueda_nombre" runat="server" Text="Nombre:" Width="125" CssClass="labels-busqueda"></asp:Label>
                                                            <asp:TextBox ID="tb_busqueda_nombre" runat="server" Width="125"></asp:TextBox>
                                                        </div>
                                                        <div class="form-item-nombre">
                                                            <asp:Label ID="lbl_busqueda_paterno" runat="server" Text="Paterno:" Width="125" CssClass="labels-busqueda"></asp:Label>
                                                            <asp:TextBox ID="tb_busqueda_paterno" runat="server" Width="125"></asp:TextBox>
                                                        </div>
                                                        <div class="form-item-nombre">
                                                            <asp:Label ID="lbl_busqueda_materno" runat="server" Text="Materno:" Width="125" CssClass="labels-busqueda"></asp:Label>
                                                            <asp:TextBox ID="tb_busqueda_materno" runat="server" Width="125"></asp:TextBox>
                                                        </div>
                                                        <div class="form-item-btn">
                                                            <asp:Button ID="btn_busqueda" runat="server" Text="Buscar" />
                                                        </div>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_resultados" runat="server" Visible="false">
                                                    <div class="subtitulo">Resultados:</div>
                                                    <div class="form-item">
                                                        <asp:GridView ID="dg_resultados" runat="server">                             
                                                            <Columns>
                                                                <asp:BoundField HeaderText="Id" />
                                                                <asp:BoundField HeaderText="Socio" />
                                                                <asp:BoundField HeaderText="Compania" />
                                                            </Columns>
                                                        </asp:GridView>
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