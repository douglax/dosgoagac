Imports NHibernate
Public Class Consulta1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Protected Sub btn_consultar_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_consultar.Click
        Dim s As ISession = NHelper.GetCurrentSession
        Dim id As Long = CLng(tb_consultar.Text)

        Dim soc As CeeLib.Socio = s.Get(GetType(CeeLib.Socio), id)
        If soc Is Nothing Then
            MsgBox("No se encontro ningun socio con el numero " & id, MsgBoxStyle.Critical)
            Return
        End If
        lbl_socio_nombre_value.Text = soc.Nombre & " " & soc.Paterno & " " & soc.Materno
        Select Case soc.Club
            Case 1
                pnl_socio_club_value.Text = "Club Enlace"
            Case 2
                pnl_socio_club_value.Text = "Club Enlace Empresarial"
            Case 3
                pnl_socio_club_value.Text = "Enlace Travel Club"
        End Select
        pnl_socio_cumpleanos_value.Text = soc.FechaDeNacimiento.ToString("D")
        pnl_socio_telefono_value.Text = soc.Telefono
        pnl_socio_ciudad_value.Text = soc.Ciudad
        pnl_socio_mail_value.Text = soc.Email
        pnl_socio_rfc_value.Text = soc.RFC
        pnl_socio_tarifa_value.Text = FormatCurrency(soc.Tarifa)
        'pnl_socio_agencia_text.Text = soc.Agencia.Nombre 
    End Sub
End Class