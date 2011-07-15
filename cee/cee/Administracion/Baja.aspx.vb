Public Class Baja2
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load



    End Sub

    Protected Sub btn_busqueda_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_busqueda.Click

        Me.pnl_resultados.Visible = True

    End Sub
End Class