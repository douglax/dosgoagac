Imports CeeLib
Imports NHibernate

Public Class Alta1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As EventArgs) Handles Button1.Click
        Dim c As New CeeLib.Compania()
        Dim s As ISession = Nothing
        c.Nombre = txtNombre.Text
        c.Direccion = txtDireccion.Text
        c.Ciudad = txtCiudad.Text
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