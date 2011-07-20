<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Alta.aspx.vb" Inherits="cee.Alta" %>
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
                                <div class="menu-item-selected" onclick="menuItemClick('Alta.aspx')">Alta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Cambio.aspx')">Modificar</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Baja.aspx')">Baja</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('../Default.aspx')">Regresar...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Alta Socio</div>
                                <div class="contenido">
                                    <form runat="server">
                                        <div class="form-item">
                                            <asp:Label ID="labelClub" runat="server" Text="Club:" Width="130" CssClass="labels"></asp:Label>
                                            <asp:DropDownList ID="club" runat="server" AutoPostBack="True"></asp:DropDownList>
                                        </div>
                                        <div class="form-items">
                                            <asp:Panel ID="pnl_seleccionar" runat="server">
                                                <div class="form-item">
                                                    Seleccionar un club por favor!...
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_nombre" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_nombre" runat="server" Text="Nombre:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_nombre" runat="server" ValidationGroup="Name_Group" 
                                                        width="269px"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ControlToValidate="tb_nombre" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_apaterno" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_apaterno" runat="server" Text="Apellido Paterno:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_apaterno" runat="server" ValidationGroup="Name_Group" 
                                                        Width="269px"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ControlToValidate="tb_apaterno" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_amaterno" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_amaterno" runat="server" Text="Apellido Materno:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_amaterno" runat="server" ValidationGroup="Name_Group" 
                                                        width="269px"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="*" ControlToValidate="tb_amaterno" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_cumpleanos" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_cumpleanos" runat="server" Text="Cumpleaños:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:DropDownList ID="ddl_cump_dia" runat="server">
                                                        <asp:ListItem Text="01" Value="01"></asp:ListItem>
                                                        <asp:ListItem Text="02" Value="02"></asp:ListItem>
                                                        <asp:ListItem Text="03" Value="03"></asp:ListItem>
                                                        <asp:ListItem Text="04" Value="04"></asp:ListItem>
                                                        <asp:ListItem Text="05" Value="05"></asp:ListItem>
                                                        <asp:ListItem Text="06" Value="06"></asp:ListItem>
                                                        <asp:ListItem Text="07" Value="07"></asp:ListItem>
                                                        <asp:ListItem Text="08" Value="08"></asp:ListItem>
                                                        <asp:ListItem Text="09" Value="09"></asp:ListItem>
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
                                                        <asp:ListItem Text="Enero" Value="01"></asp:ListItem>
                                                        <asp:ListItem Text="Febrero" Value="02"></asp:ListItem>
                                                        <asp:ListItem Text="Marzo" Value="03"></asp:ListItem>
                                                        <asp:ListItem Text="Abril" Value="04"></asp:ListItem>
                                                        <asp:ListItem Text="Mayo" Value="05"></asp:ListItem>
                                                        <asp:ListItem Text="Junio" Value="06"></asp:ListItem>
                                                        <asp:ListItem Text="Julio" Value="07"></asp:ListItem>
                                                        <asp:ListItem Text="Agosto" Value="08"></asp:ListItem>
                                                        <asp:ListItem Text="Septiembre" Value="09"></asp:ListItem>
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
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="*" ControlToValidate="tb_telefono" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            
                                            <asp:Panel ID="pnl_estado" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_estado" runat="server" Text="Estado:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:DropDownList ID="ddl_estado" runat="server" ValidationGroup="Name_Group" 
                                                        AutoPostBack="True"></asp:DropDownList>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator10" runat="server" ErrorMessage="*" ControlToValidate="ddl_estado" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_ciudad" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_ciudad" runat="server" Text="Ciudad:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:DropDownList ID="ddl_ciudad" runat="server" ValidationGroup="Name_Group"></asp:DropDownList>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="*" ControlToValidate="ddl_ciudad" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
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
                                            <asp:Panel ID="pnl_sivale" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label1" runat="server" Text="Cta de Sí vale:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_sivale" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_agencia" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_agencia" runat="server" Text="Agencia de Viajes:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_agencia" runat="server" ValidationGroup="Name_Group"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator9" runat="server" ErrorMessage="*" ControlToValidate="tb_agencia" ValidationGroup="Name_Group" CssClass="validacion"></asp:RequiredFieldValidator>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_guardar" runat="server">
                                                <div class="form-item-btn">
                                                    <asp:Button ID="btn_guardar" runat="server" Text="Guardar" ValidationGroup="Name_Group"/>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_resultado" runat="server">
                                                <div class="form-item-btn">
                                                    <asp:Label ID="lbl_resultado" runat="server" Font-Bold="True" ForeColor="#33CC33" Font-Size="12pt"></asp:Label>
                                                    <div class="link" onmouseover="linkItemOver(this)" onmouseout="linkItemOut(this)" onclick="menuItemClick('Alta.aspx')">Click Aqui para Nuevo Registro de Socio</div>
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
