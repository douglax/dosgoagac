Public Class Salir
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        LblCerrando.Text = "Cerrando Sesion"
        FormsAuthentication.SignOut()
        Response.Redirect("Login.aspx")
    End Sub

End Class