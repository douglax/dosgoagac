<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Consulta.aspx.vb" Inherits="cee.Consulta1" %>
<html>
<head>
    <link rel="Stylesheet" href="../cee.css" type="text/css">
    <script src="../cee.js" type="text/javascript"></script>
    <style type="text/css">
        .style1
        {
            width: 19px;
            height: 19px;
        }
        .consulta-values
        {}
    </style>
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
                                <div class="menu-item-selected" onclick="menuItemClick('Consulta.aspx')">Consulta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Socios.aspx')">Socios</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Compania.aspx')">Compañias</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Informe.aspx')">Informes</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Administracion.aspx')" id="menu_item_admin" runat="server" visible="false">Administracion</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="nav({url: 'http://www.sivale.com.mx/', tipo: '_blank'})"><img src="Imagenes/sivale-logo.png" border="0"></div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Salir.aspx')">Salir...</div>
                            </div>
                            <table border="0" cellpadding="0" cellspacing="0">
                                                        <tr>
                                                            <td style="width: 500px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo"><asp:Label ID="lbl_page_title" runat="server" Text="Consulta"></asp:Label></div>
                                <div class="contenido">
                                    <form id="frm_consulta" runat="server">
                                        <asp:HiddenField ID="HiddenField1" runat="server" />
                                        <div class="form-items">
                                        <asp:Panel ID="grp_busqueda" runat="server" Visible="false">
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
                                                        Width="475px">                             
                                                        <Columns>
                                                            <asp:HyperLinkField DataNavigateUrlFields="NoSocio" 
                                                                DataNavigateUrlFormatString="consulta.aspx?id_socio={0}" 
                                                                DataTextField="NoSocio" HeaderText="No. de Socio" >
                                                            <ItemStyle HorizontalAlign="Center" />
                                                            </asp:HyperLinkField>
                                                            <asp:BoundField DataField="NombreCompleto" HeaderText="Nombre" >
                                                            <ItemStyle HorizontalAlign="Center" />
                                                            </asp:BoundField>
                                                        </Columns>
                                                    </asp:GridView>
                                                </div>
                                            </asp:Panel>
                                        </asp:Panel>
                                        <asp:Panel ID="grp_consultar" runat="server">
                                            <asp:Panel ID="pnl_consultar" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="lbl_consultar" runat="server" Text="Numero de Socio:" Width="130" CssClass="labels"></asp:Label>
                                                    <asp:TextBox ID="tb_consultar" runat="server" ValidationGroup="v_grp_consultar"></asp:TextBox>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="*" ControlToValidate="tb_consultar" ValidationGroup="v_grp_consultar" CssClass="validacion"></asp:RequiredFieldValidator>
                                                    <asp:Button ID="btn_consultar" runat="server" Text="Consultar" ValidationGroup="v_grp_consultar"/>
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
                                                    <asp:Label ID="pnl_socio_club_text" runat="server" Text="Club:" Width="130px" 
                                                        CssClass="consulta-labels" Font-Bold="True"></asp:Label>
                                                    <asp:Label ID="pnl_socio_club_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values" Font-Bold="True"></asp:Label>
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
                                            <asp:Panel ID="pnl_sexo" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label6" runat="server" Text="Sexo:" Width="130px" 
                                                        CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_sexo_text" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_edo_civil" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label7" runat="server" Text="Edo. Civil:" Width="130px" 
                                                        CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_edo_civil_text" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_face" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label4" runat="server" Width="130px" CssClass="consulta-values"><img alt="Facebook" src="Imagenes/ico_facebook_off.gif" align="right"/></asp:Label>
                                                    <asp:Label ID="pnl_face_text" runat="server" Width="250px" CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_twitter" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label5" runat="server" Width="130px" CssClass="consulta-values"><img alt="Facebook" src="Imagenes/ico_twitter_off.gif" align="right"/></asp:Label>
                                                    <asp:Label ID="pnl_twitter_text" runat="server" Width="250px" CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            
                                            <asp:Panel ID="pnl_compania" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label2" runat="server" Text="Compañia:" Width="130px" 
                                                        CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_compania_text" runat="server" Width="250px" 
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
                                            <asp:Panel ID="pnl_gustos" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label8" runat="server" Text="Hobbies:" Width="130px" 
                                                        CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_gustos_text" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_sivale" runat="server">
                                                <div class="form-item">
                                                    <asp:Label ID="Label3" runat="server" Text="Cta Sí vale:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_sivale_text" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_socio_agencia" runat="server" Visible="false" >
                                                <div class="form-item">
                                                    <asp:Label ID="pnl_socio_agencia_text" runat="server" Text="Agencia:" Width="130" CssClass="consulta-labels"></asp:Label>
                                                    <asp:Label ID="pnl_socio_agencia_value" runat="server" Width="250px" 
                                                        CssClass="consulta-values"></asp:Label>
                                                </div>
                                            </asp:Panel>

                                            <asp:Panel ID="Panel1" runat="server" Visible="true">
                                                <div class="subtitulo">Tipo de Socio</div>
                                                <div class="form-item">
                                                    <asp:Label ID="Lbl_Tipo" runat="server" Width="486px" Font-Bold="True" Font-Size="Medium"></asp:Label>
                                                </div>
                                            </asp:Panel>

                                            <asp:Panel ID="pnl_cuarto_noche" runat="server" Visible="false">
                                                <div class="subtitulo">Agregar puntos para el socio</div>
                                                <div class="form-item">
                                                    <table border="0" cellpadding="0" cellspacing="0">
                                                        <tr>
                                                            <td>
                                                                <div style="width: 180px;">
                                                                    <div>
                                                                        <asp:Label ID="lbl_cantidad_cuartos" runat="server" Text="Cuartos Noche:" Width="130" CssClass="labels-busqueda"></asp:Label>
                                                                    </div>
                                                                    <div>
                                                                        <asp:TextBox ID="tb_cantidad_cuartos" runat="server" ValidationGroup="v_grp_cuartos"></asp:TextBox>
                                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="*" ControlToValidate="tb_cantidad_cuartos" ValidationGroup="v_grp_cuartos" CssClass="validacion"></asp:RequiredFieldValidator>
                                                                    </div>
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <asp:Panel ID="pnl_tarifa" runat="server" Visible="false">
                                                                <div style="width: 180px;">
                                                                    <div>
                                                                        <asp:Label ID="lbl_tarifa" runat="server" Text="Tarifa:" Width="130" CssClass="labels-busqueda"></asp:Label>
                                                                    </div>
                                                                    <div>
                                                                        <asp:TextBox ID="tb_tarifa" runat="server" ValidationGroup="v_grp_cuartos"></asp:TextBox>
                                                                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="*" ControlToValidate="tb_tarifa" ValidationGroup="v_grp_cuartos" CssClass="validacion"></asp:RequiredFieldValidator>
                                                                    </div>
                                                                </div>
                                                                </asp:Panel>
                                                            </td>
                                                            <td>
                                                                <div style="width: 130px;">
                                                                    <div>
                                                                        <asp:Button ID="btn_cantidad_cuartos" runat="server" Text="Agregar" ValidationGroup="v_grp_cuartos"/>
                                                                    </div>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </asp:Panel>
                                            <asp:Panel ID="pnl_puntos" runat="server">
                                                <div class="subtitulo">
                                                    Cuartos Noche:<asp:Button ID="btn_puntos" runat="server" Text=" + " />
                                                </div>
                                                <div class="form-item">
                                                    <asp:GridView ID="dg_puntos" runat="server" AutoGenerateColumns="False" 
                                                        Width="472px" AllowPaging="True" PageSize="4" Font-Size="Small">                             
                                                        <Columns>
                                                            <asp:BoundField DataField="Id" HeaderText="Ref" />
                                                            <asp:BoundField HeaderText="Cantidad" DataField="Cantidad" >
                                                            <ItemStyle HorizontalAlign="Center" />
                                                            </asp:BoundField>
                                                            <asp:BoundField DataField="Tarifa" DataFormatString="{0:C}" HeaderText="Tarifa" 
                                                                NullDisplayText="No Aplica">
                                                            <ItemStyle HorizontalAlign="Center" />
                                                            </asp:BoundField>
                                                            <asp:BoundField HeaderText="Fecha de Registro" DataField="FechaAlta" 
                                                                DataFormatString="{0:yyyy-MM-dd}" >
                                                            <ItemStyle HorizontalAlign="Center" />
                                                            </asp:BoundField>
                                                            <asp:BoundField DataField="Hotel" HeaderText="Registra" />
                                                            <asp:CommandField ButtonType="Button" HeaderText="Borrar" 
                                                                ShowDeleteButton="True">
                                                            <ItemStyle HorizontalAlign="Center" />
                                                            </asp:CommandField>
                                                        </Columns>
                                                    </asp:GridView>
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
                            </td>
                            </tr>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

</body>
</html>