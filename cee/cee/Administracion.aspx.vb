Imports NHibernate
Public Class Administracion
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Dim s As ISession = Nothing
        Try
            s = NHelper.GetCurrentSession()
            Dim u As CeeLib.Usuario = s.Get(Of CeeLib.Usuario)(NHelper.UserName)
            If u.Hotel.Id <> 1 Then
                Response.Redirect("Denegada.aspx")
            End If
        Catch ex As Exception
            LblError.Text = "Ocurrio un error inesperado: " & ex.Message
        Finally
            NHelper.CloseSession()
        End Try
    End Sub

End Class