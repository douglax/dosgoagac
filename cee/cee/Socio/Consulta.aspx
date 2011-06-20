<%@ Page Language="vb" AutoEventWireup="false" CodeBehind="Consulta.aspx.vb" Inherits="cee.Consulta" %>
<html>
<head>
    <style>
        .menu-item {background: #e5e5e5; border: 1px #dddddd solid; font: normal 10pt tahoma; color: #666666; margin: 2px; padding: 5px 10px 5px 10px; cursor: pointer;}
        .menu-item-over {background: #d5d5d5; border: 1px #cccccc solid; font: normal 10pt tahoma; color: #000000; margin: 2px; padding: 5px 10px 5px 10px; cursor: pointer;}
        .menu-item-selected {background: #d5d5d5; border: 1px #cccccc solid; font: normal 10pt tahoma; color: #000000; margin: 2px; padding: 5px 10px 5px 10px; cursor: pointer;}
        .titulo {background: #B84444; font: normal 12pt tahoma; color: #ffffff; padding: 10px;}
    </style>
    <script>
        function menuItemOver(item) {
            item.className = "menu-item-over";
        }
        function menuItemOut(item) {
            item.className = "menu-item";
        }
        function menuItemClick(url) {
            location.href = url;
        }
    </script>
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
                        <div style="height: 150px; background: #eeeeee; font: normal 9pt tahoma; border-top: 1px #dddddd solid; border-bottom: 1px #dddddd solid; padding: 30px 40px 30px 80px; position: relative;">
                            <div style="width: 220px; float: left;">
                                <div class="menu-item-selected">Consulta</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Alta.aspx')">Alta Socio</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Cambio.aspx')">Modificar Socio</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Baja.aspx')">Baja Socio</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Compania.aspx')">Compañia</div>
                                <div class="menu-item" onmouseover="menuItemOver(this)" onmouseout="menuItemOut(this)" onclick="menuItemClick('Salir.aspx')">Salir...</div>
                            </div>
                            <div style="width: 500px; height: 550px; background: #ffffff; border: 1px #cccccc solid; position: absolute; top: -200px; left: 320px; padding: 2px;">
                                <div class="titulo">Consulta</div>
                                <div class="contenido">
                                    ...
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
