﻿<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Alta.aspx.vb" Inherits="cee.Alta" %>
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
                                <div class="menu-title">Socios</div>
                                <div class="menu-item-selected">Alta</div>
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
                                                    <asp:TextBox ID="tb_nombre" runat="server"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_apaterno" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_apaterno" runat="server" Text="Apellido Paterno:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_apaterno" runat="server"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_amaterno" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_amaterno" runat="server" Text="Apellido Materno:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_amaterno" runat="server"></asp:TextBox>
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
                                                    <asp:TextBox ID="tb_telefono" runat="server"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_ciudad" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_ciudad" runat="server" Text="Ciudad:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_ciudad" runat="server"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_correo" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_correo" runat="server" Text="Email:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_correo" runat="server"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_rfc" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_rfc" runat="server" Text="RFC:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_rfc" runat="server"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_compania" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_compania" runat="server" Text="Compañia:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:DropDownList ID="ddl_compania" runat="server">
                                                        <asp:ListItem Text="Coca Cola" Value="01"></asp:ListItem>
                                                        <asp:ListItem Text="Bimbo" Value="02"></asp:ListItem>
                                                    </asp:DropDownList>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_tarifa" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_tarifa" runat="server" Text="Tarifa:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_tarifa" runat="server"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_agencia" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_agencia" runat="server" Text="Agencia de Viajes:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_agencia" runat="server"></asp:TextBox>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_guardar" runat="server">
                                                <div class="form-item-btn">
                                                    <asp:Button ID="btnGuardar" runat="server" Text="Guardar" />
                                                </div>
                                            </asp:Panel>
                                        </div>
                                        <asp:Label ID="Lbl_Resultado" runat="server" Font-Bold="True" 
                                            ForeColor="#33CC33"></asp:Label>
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
