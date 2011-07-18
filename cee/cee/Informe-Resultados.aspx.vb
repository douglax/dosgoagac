Public Class Informe_Resultados
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Select Case Me.Request.QueryString("club")
            Case 1
                Me.lbl_tipo.Text = "'Club Enlace' "
            Case 2
                Me.lbl_tipo.Text = "'Club Enlace Empresaria' "
            Case 3
                Me.lbl_tipo.Text = "'Club Enlace Travel' "
        End Select

        Me.lbl_periodo_inicio.Text = Me.Request.QueryString("tb_periodo_inicio") & " - "
        Me.lbl_periodo_termino.Text = Me.Request.QueryString("tb_periodo_final")
    End Sub

End Class