<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Informe-Resultados.aspx.vb" Inherits="cee.Informe_Resultados" %>
<html>
<head>
    <title id="pg_title" runat="server"></title>
    <link rel=StyleSheet href="cee.css" type="text/css">
    <script src="cee.js"></script>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td style="vertical-align: middle;">
            <table style="margin: auto;" width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="80px" style="padding: 0px 30px 0px 0px;">
                        <img src="Imagenes/logotipo.jpg" border="0" align="left"/>
                    </td>
                </tr>
                <tr>
                    <td height="50px" class="titulo">
                        Informe: 
                        <asp:Label ID="lbl_tipo" runat="server" Text="Label"></asp:Label>
                        <asp:Label ID="lbl_periodo_inicio" runat="server" Text="Label"></asp:Label>
                        <asp:Label ID="lbl_periodo_termino" runat="server" Text="Label"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="contenido">
                        <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0"><tr><td style="vertical-align: top;">
                        <form id="form1" runat="server">
                            <asp:GridView ID="dg_resultados_1" runat="server" ShowFooter="True" AutoGenerateColumns="False" Width="100%">
                                <Columns>
                                    <asp:BoundField DataField="Compania" HeaderText="Compañía">
                                        <ItemStyle HorizontalAlign="Center" />
                                    </asp:BoundField>
                                    <asp:BoundField HeaderText="Tarifa" DataField="Tarifa" DataFormatString="{0:C}">
                                        <ItemStyle HorizontalAlign="Right" />
                                    </asp:BoundField>
                                    <asp:BoundField HeaderText="Cuartos Noche" DataField="Cantidad">
                                        <ItemStyle HorizontalAlign="Center" />
                                    </asp:BoundField>
                                    <asp:BoundField HeaderText="Total" DataField="Total" DataFormatString="{0:C}">
                                        <ItemStyle HorizontalAlign="Right" />
                                    </asp:BoundField>
                                </Columns>
                                <FooterStyle BackColor="#FFFF66" />
                            </asp:GridView>
                            <asp:GridView ID="dg_resultados_2" runat="server" ShowFooter="True" AutoGenerateColumns="False" Width="100%">
                                <Columns>
                                    <asp:BoundField HeaderText="Empleado" DataField="NOMBRE_COMPLETO">
                                        <ItemStyle HorizontalAlign="Center" />
                                    </asp:BoundField>
                                    <asp:BoundField HeaderText="Cuartos Noche" DataField="CANTIDAD">
                                        <ItemStyle HorizontalAlign="Center" />
                                    </asp:BoundField>
                                </Columns>
                                <FooterStyle BackColor="#FFFF66" />
                            </asp:GridView>
                            <asp:GridView ID="dg_resultados_3" runat="server" ShowFooter="True" AutoGenerateColumns="False" Width="100%">
                                <Columns>
                                    <asp:BoundField HeaderText="Empleado" DataField="NOMBRE_COMPLETO">
                                        <ItemStyle HorizontalAlign="Center" />
                                    </asp:BoundField>
                                    <asp:BoundField HeaderText="Numero de Tarjeta" DataField="CTA_SIVALE">
                                        <ItemStyle HorizontalAlign="Center" />
                                    </asp:BoundField>
                                </Columns>
                                <FooterStyle BackColor="#FFFF66" />
                            </asp:GridView>
                        </form>
                        </td></tr></table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
