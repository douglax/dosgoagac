<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Verificar_Duplicados.aspx.vb" Inherits="cee.Verificar_Duplicados" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>

<body>
    <form id="form1" runat="server">
    <asp:image ID="Image1" runat="server" ImageUrl="~/Imagenes/logotipo.jpg"></asp:image>
    <div>
    
        <asp:Label ID="Label1" runat="server" Font-Size="Large" 
            Text="Existen socios con el mimos nombre que esta tratando de registrar, ¿Qué acción desea realizar?"></asp:Label>
        <br />
    
    </div>
    <asp:Label ID="Lbl_Socio" runat="server" Font-Size="Large"></asp:Label>
    <br />
    <br />
    <asp:HyperLink ID="Hyp_Consulta" runat="server" Font-Size="Large">[Hyp_Consulta]</asp:HyperLink>
    <br />
    <br />
    <asp:HyperLink ID="Hyp_Nuevo" runat="server" Font-Size="Large">[Hyp_Nuevo]</asp:HyperLink>
    </form>
</body>
</html>
