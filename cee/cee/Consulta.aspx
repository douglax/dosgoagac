﻿<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Consulta.aspx.vb" Inherits="cee.Consulta1" %>
<html>
<head>
    <link rel="Stylesheet" href="../cee.css" type="text/css">
    <script src="../cee.js" type="text/javascript"></script>
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
                        <div style="height: 150px; background: #eeeeee; font: normal 9pt tahoma; border-top: 1px #dddddd solid; border-bottom: 1px #dddddd solid; padding: 30px 40px 30px 80px; position: relative;">
                            <div style="width: 220px; float: left;">
                                <div class="menu-item-selected" onclick="menuItemClick('Consulta.aspx')">Consulta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Socios.aspx')">Socios</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Compania.aspx')">Compañias</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Salir.aspx')">Salir...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo"><asp:Label ID="lbl_page_title" runat="server" Text="Consulta"></asp:Label></div>
                                <div class="contenido">
                                    <form runat="server">
                                        <div class="form-items">
                                        <asp:Panel ID="grp_busqueda" runat="server" Visible="false">
                                            <asp:Panel ID="pnl_busqueda" runat="server">
                                                <div class="form-item">
                                                    <asp:TextBox ID="tb_buscar_paterno" runat="server"></asp:TextBox>&nbsp;
                                                    <asp:TextBox ID="tb_buscar_materno" runat="server"></asp:TextBox>&nbsp;
                                                    <asp:TextBox ID="tb_buscar_nombre" runat="server"></asp:TextBox>&nbsp;
                                                    <asp:Button ID="btn_busqueda" runat="server" Text="Buscar" />&nbsp;
                                                </div>
                                                <div class="form-item">
                                                    <asp:Label ID="Label1" runat="server" Text="Compañía" Width="130px" 
                                                        CssClass="labels"></asp:Label>
                                                    <asp:DropDownList ID="ddl_Companias" runat="server"></asp:DropDownList>
                                                    <asp:Button ID="Button1" runat="server" Text="Buscar" />
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_resultados" runat="server">
                                                <div class="subtitulo">Socios:</div>
                                                <div class="form-item">
                                                    <asp:GridView ID="dg_resultados" runat="server" AutoGenerateColumns="False" 
                                                        Width="354px">                             
                                                        <Columns>
                                                            <asp:HyperLinkField DataNavigateUrlFields="NoSocio" 
                                                                DataNavigateUrlFormatString="consulta.aspx?id_socio={0}" 
                                                                DataTextField="NoSocio" HeaderText="No. de Socio" />
                                                            <asp:BoundField DataField="NombreCompleto" HeaderText="Nombre" />
                                                        </Columns>
                                                    </asp:GridView>
                                                </div>
                                            </asp:Panel>
                                        </asp:Panel>
                                        <asp:Panel ID="grp_consultar" runat="server">
                                            <asp:Panel ID="pnl_consultar" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_consultar" runat="server" Text="Numero de Socio:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_consultar" runat="server"></asp:TextBox>
                                                    <asp:Button ID="btn_consultar" runat="server" Text="Consultar" />
                                                    <asp:Button ID="btn_consultar_popup" runat="server" runat="server" Text="..." />
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_nombre" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_socio_nombre_text" runat="server" Text="Nombre:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="lbl_socio_nombre_value" runat="server" Width="250px" CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_club" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_club_text" runat="server" Text="Club:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_club_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_cumpleanos" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_cumpleanos_text" runat="server" Text="Cumpleaños:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_cumpleanos_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_telefono" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_telefono_text" runat="server" Text="Telefono:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_telefono_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_ciudad" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_ciudad_text" runat="server" Text="Ciudad:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_ciudad_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_mail" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_mail_text" runat="server" Text="Mail:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_mail_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_rfc" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_rfc_text" runat="server" Text="RFC:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_rfc_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_tarifa" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_tarifa_text" runat="server" Text="Tarifa:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_tarifa_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_agencia" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_agencia_text" runat="server" Text="Agencia:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_agencia_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_puntos" runat="server">
                                                <div class="subtitulo">Cuartos Noche:<asp:Button ID="Button2" runat="server" 
                                                        BorderColor="#CC3300" BorderStyle="Solid" Text="Agregar..." />
                                                </div>
                                                <div class="form-item">
                                                    <asp:GridView ID="dg_puntos" runat="server">                             
                                                        <Columns>
                                                            <asp:BoundField HeaderText="Cantidad" />
                                                            <asp:BoundField HeaderText="Fecha" />
                                                            <asp:BoundField HeaderText="Serie" />
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