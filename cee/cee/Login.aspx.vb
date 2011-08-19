Imports System.Data.SqlClient
Imports NHibernate
Imports CeeLib
Imports System.Security.Cryptography
Imports System.Text

Public Class Login
    Inherits System.Web.UI.Page

    Protected Sub Autentificar(ByVal sender As Object, ByVal e As System.Web.UI.WebControls.AuthenticateEventArgs) Handles Login1.Authenticate

        Try
            Dim s As ISession = NHelper.GetCurrentSession
            Dim u As Usuario = s.Get(GetType(Usuario), Login1.UserName)
            If u Is Nothing Then
                Login1.FailureText = "Error al ingresar al sistema, verifique su nombre de usuario y contraseña"
                Return
            End If
            Console.WriteLine(Encrypt.Encriptar("admin"))
            If Encrypt.Desencriptar(u.Passwd).Equals(Login1.Password) Then
                FormsAuthentication.RedirectFromLoginPage(Login1.UserName, Login1.RememberMeSet)
            Else
                Login1.FailureText = "Error al ingresar al sistema, verifique su nombre de usuario y contraseña"
            End If
            s.Close()
            NHelper.UserName = u.Usr
        Catch ex As Exception
            Login1.FailureText = "Hubo un error al tratar de ingresar al sistema: " & ex.Message
            System.Console.WriteLine(ex.Message)
        End Try

    End Sub

End Class