﻿<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Denegada.aspx.vb" Inherits="cee.Denegada" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>

    <form id="form1" runat="server">
    <asp:Image ID="Image1" runat="server" ImageUrl="~/Imagenes/logotipo.jpg" /><br/>
    <div>
        <asp:Label ID="Label1" runat="server" Font-Size="Large" ForeColor="Red" 
            Text="No cuenta con los privilegios suficientes para realizar esta operación..."></asp:Label>
    
    </div>
    
    </form>
</body>
</html>
