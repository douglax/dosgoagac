<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Informe-Resultados.aspx.vb" Inherits="cee.Informe_Resultados" %>
<html>
<head>
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
                        <form id="form1" runat="server">
                            <asp:GridView ID="GridView1" runat="server">
                            </asp:GridView>
                        </form>
                    </dt>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
