<%@ Page Title="Página principal" Language="vb" AutoEventWireup="false" CodeBehind="Login.aspx.vb" Inherits="cee.Login" %>
<html>
<head>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td style="vertical-align: middle;">
            <table style="margin: auto;" width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <div style="padding: 0px 30px 0px 0px;">
                             <img src="Imagenes/logotipo.jpg" border="0" align="left"/>
                             <img src="Imagenes/enlace.jpg" border="0" align="right"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="background: #eeeeee; font: normal 9pt tahoma; border-top: 1px #dddddd solid; border-bottom: 1px #dddddd solid; padding: 30px 40px 30px 80px;">
                            <form id="Form1" runat="server">
                                <asp:Login runat="server" onauthenticate="Autentificar" id="Login1" UserNameLabelText="Usuario:" PasswordRequiredErrorMessage="Campo Requerido" UserNameRequiredErrorMessage="Campo Requerido" PasswordLabelText="Contraseña:" RememberMeText="Recordar login."></asp:Login>
                            </form>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>


