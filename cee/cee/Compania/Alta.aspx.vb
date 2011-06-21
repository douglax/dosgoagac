Imports CeeLib
Imports NHibernate

Public Class Alta1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Protected Sub btn_guardar_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_guardar.Click
        Dim c As New CeeLib.Compania()
        Dim s As ISession = Nothing
        c.Nombre = tb_nombre.Text
        c.Direccion = tb_direccion.Text
        c.Ciudad = tb_ciudad.Text
        Try
            s = NHelper.GetCurrentSession
            s.BeginTransaction()
            c = s.Merge(c)
            s.Transaction.Commit()
            lblResultado.Text = "Compañía registrada"
        Catch ex As Exception
            If s.Transaction.IsActive Then
                s.Transaction.Rollback()
            End If
        End Try

    End Sub
End Class