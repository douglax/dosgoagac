<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Cambio.aspx.vb" Inherits="cee.Cambio" %>
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
                                <div class="menu-item-selected" onclick="menuItemClick('Cambio.aspx')">Modificar</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Baja.aspx')">Baja</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('../Default.aspx')">Regresar...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Modificar Socio</div>
                                <div class="contenido">
                                    <form id="Form1" runat="server">
                                        <div class="form-items">
                                            <asp:Panel ID="grp_busqueda" runat="server" Visible="false">
                                                <asp:Panel ID="pnl_busqueda" runat="server">
                                                    <div class="form-item">
                                                        <div class="form-item-nombre">
                                                            <asp:Label ID="lbl_busqueda_nombre" runat="server" Text="Nombre:" Width="125" CssClass="labels-busqueda"></asp:Label>
                                                            <asp:TextBox ID="tb_buscar_nombre" runat="server" Width="125"></asp:TextBox>
                                                        </div>
                                                        <div class="form-item-nombre">
                                                            <asp:Label ID="lbl_busqueda_paterno" runat="server" Text="Paterno:" Width="125" CssClass="labels-busqueda"></asp:Label>
                                                            <asp:TextBox ID="tb_buscar_paterno" runat="server" Width="125"></asp:TextBox>
                                                        </div>
                                                        <div class="form-item-nombre">
                                                            <asp:Label ID="lbl_busqueda_materno" runat="server" Text="Materno:" Width="125" CssClass="labels-busqueda"></asp:Label>
                                                            <asp:TextBox ID="tb_buscar_materno" runat="server" Width="125"></asp:TextBox>
                                                        </div>
                                                        <div class="form-item-btn">
                                                            <asp:Button ID="btn_busqueda" runat="server" Text="Buscar" />
                                                        </div>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_resultados" runat="server">
                                                    <div class="subtitulo">Socios:</div>
                                                    <div class="form-item">
                                                        <asp:GridView ID="dg_resultados" runat="server" AutoGenerateColumns="False" 
                                                            Width="472px">                             
                                                            <Columns>
                                                                <asp:HyperLinkField DataNavigateUrlFields="NoSocio" DataNavigateUrlFormatString="Cambio.aspx?id_socio={0}" DataTextField="NoSocio" HeaderText="No. de Socio" />
                                                                <asp:BoundField HeaderText="Nombre" DataField="NombreCompleto" />
                                                            </Columns>
                                                        </asp:GridView>
                                                    </div>
                                                </asp:Panel>
                                            </asp:Panel>
                                            <asp:Panel ID="grp_consultar" runat="server">
                                                <asp:Panel ID="pnl_consultar" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_consultar" runat="server" Text="Numero de Socio:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_consultar" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="*" ControlToValidate="tb_consultar" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                        <asp:Button ID="btn_consultar" runat="server" Text="Consultar" ValidationGroup="Name_Group"/>
                                                        <asp:Button ID="btn_consultar_popup" runat="server" runat="server" Text="..." />
                                                    </div>
                                                </asp:Panel>
                                            </asp:Panel>
                                            <asp:Panel ID="grp_modificar" runat="server" Visible="false">
                                                <asp:Panel ID="pnl_club" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_club" runat="server" Text="Club:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:DropDownList ID="club" runat="server" AutoPostBack="True">
                                                            <asp:ListItem Text="Club Enlace" Value="1"></asp:ListItem>
                                                            <asp:ListItem Text="Club Enlace Empresarial" Value="2"></asp:ListItem>
                                                            <asp:ListItem Text="Enlace Travel Club" Value="3"></asp:ListItem>
                                                        </asp:DropDownList>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_nombre" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_nombre" runat="server" Text="Nombre:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_nombre" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator9" runat="server" ErrorMessage="*" ControlToValidate="tb_nombre" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_apaterno" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_apaterno" runat="server" Text="Apellido Paterno:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_apaterno" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ControlToValidate="tb_apaterno" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_amaterno" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_amaterno" runat="server" Text="Apellido Materno:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_amaterno" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ControlToValidate="tb_amaterno" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_cumpleanos" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_cumpleanos" runat="server" Text="Cumpleaños:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:DropDownList ID="ddl_cump_dia" runat="server">
                                                            <asp:ListItem Text="01" Value="1"></asp:ListItem>
                                                            <asp:ListItem Text="02" Value="2"></asp:ListItem>
                                                            <asp:ListItem Text="03" Value="3"></asp:ListItem>
                                                            <asp:ListItem Text="04" Value="4"></asp:ListItem>
                                                            <asp:ListItem Text="05" Value="5"></asp:ListItem>
                                                            <asp:ListItem Text="06" Value="6"></asp:ListItem>
                                                            <asp:ListItem Text="07" Value="7"></asp:ListItem>
                                                            <asp:ListItem Text="08" Value="8"></asp:ListItem>
                                                            <asp:ListItem Text="09" Value="9"></asp:ListItem>
                                                            <asp:ListItem Text="10" Value="10"></asp:ListItem>
                                                            <asp:ListItem Text="11" Value="11"></asp:ListItem>
                                                            <asp:ListItem Text="12" Value="12"></asp:ListItem>
                                                            <asp:ListItem Text="13" Value="13"></asp:ListItem>
                                                            <asp:ListItem Text="14" Value="14"></asp:ListItem>
                                                            <asp:ListItem Text="15" Value="15"></asp:ListItem>
                                                            <asp:ListItem Text="16" Value="16"></asp:ListItem>
                                                            <asp:ListItem Text="17" Value="17"></asp:ListItem>
                                                            <asp:ListItem Text="18" Value="18"></asp:ListItem>
                                                            <asp:ListItem Text="19" Value="19"></asp:ListItem>
                                                            <asp:ListItem Text="20" Value="20"></asp:ListItem>
                                                            <asp:ListItem Text="21" Value="21"></asp:ListItem>
                                                            <asp:ListItem Text="22" Value="22"></asp:ListItem>
                                                            <asp:ListItem Text="23" Value="23"></asp:ListItem>
                                                            <asp:ListItem Text="24" Value="24"></asp:ListItem>
                                                            <asp:ListItem Text="25" Value="25"></asp:ListItem>
                                                            <asp:ListItem Text="26" Value="26"></asp:ListItem>
                                                            <asp:ListItem Text="27" Value="27"></asp:ListItem>
                                                            <asp:ListItem Text="28" Value="28"></asp:ListItem>
                                                            <asp:ListItem Text="29" Value="29"></asp:ListItem>
                                                            <asp:ListItem Text="30" Value="30"></asp:ListItem>
                                                            <asp:ListItem Text="31" Value="31"></asp:ListItem>
                                                        </asp:DropDownList>
                                                        <asp:DropDownList ID="ddl_cump_mes" runat="server">
                                                            <asp:ListItem Text="Enero" Value="1"></asp:ListItem>
                                                            <asp:ListItem Text="Febrero" Value="2"></asp:ListItem>
                                                            <asp:ListItem Text="Marzo" Value="3"></asp:ListItem>
                                                            <asp:ListItem Text="Abril" Value="4"></asp:ListItem>
                                                            <asp:ListItem Text="Mayo" Value="5"></asp:ListItem>
                                                            <asp:ListItem Text="Junio" Value="6"></asp:ListItem>
                                                            <asp:ListItem Text="Julio" Value="7"></asp:ListItem>
                                                            <asp:ListItem Text="Agosto" Value="8"></asp:ListItem>
                                                            <asp:ListItem Text="Septiembre" Value="9"></asp:ListItem>
                                                            <asp:ListItem Text="Octubre" Value="10"></asp:ListItem>
                                                            <asp:ListItem Text="Noviembre" Value="11"></asp:ListItem>
                                                            <asp:ListItem Text="Diciembre" Value="12"></asp:ListItem>
                                                        </asp:DropDownList>
                                                        <asp:DropDownList ID="ddl_cump_ano" runat="server"></asp:DropDownList>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_telefono" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_telefono" runat="server" Text="Telefono:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_telefono" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="*" ControlToValidate="tb_telefono" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_ciudad" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_ciudad" runat="server" Text="Ciudad:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_ciudad" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="*" ControlToValidate="tb_ciudad" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_correo" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_correo" runat="server" Text="Email:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_correo" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" ErrorMessage="*" ControlToValidate="tb_correo" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_rfc" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_rfc" runat="server" Text="RFC:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_rfc" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" ErrorMessage="*" ControlToValidate="tb_rfc" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_compania" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_compania" runat="server" Text="Compañia:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:DropDownList ID="ddl_compania" runat="server"></asp:DropDownList>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_tarifa" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_tarifa" runat="server" Text="Tarifa:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_tarifa" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" ErrorMessage="*" ControlToValidate="tb_tarifa" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_agencia" runat="server">
                                                    <div class="form-item">
                                                        <asp:Label ID="lbl_agencia" runat="server" Text="Agencia de Viajes:" Width="130" CssClass="labels"></asp:Label>
                                                        <asp:TextBox ID="tb_agencia" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator10" runat="server" ErrorMessage="*" ControlToValidate="tb_agencia" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    </div>
                                                </asp:Panel>
                                                <asp:Panel ID="pnl_modificar" runat="server">
                                                    <div class="form-item-btn">
                                                        <asp:Button ID="btn_modificar" runat="server" Text="Modificar"  ValidationGroup="Name_Group"/>
                                                    </div>
                                                </asp:Panel>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_resultado" runat="server">
                                                <div class="form-item-btn">
                                                    <asp:Label ID="lbl_resultado" runat="server" Font-Bold="True" ForeColor="#33CC33" Font-Size="12pt"></asp:Label>
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

