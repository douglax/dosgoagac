Imports System.Data.SqlClient
Public Class Login
    Inherits System.Web.UI.Page

    Protected Sub Autentificar(ByVal sender As Object, ByVal e As System.Web.UI.WebControls.AuthenticateEventArgs) Handles Login1.Authenticate
        Dim con As New SqlConnection
        Dim cm As New SqlCommand

        con.ConnectionString = "Data Source=.\SQLEXPRESS;AttachDbFilename=|DataDirectory|\cee.mdf;Integrated Security=True;Connect Timeout=30;User Instance=True"
        Try
            con.Open()
            cm.Connection = con
            Dim qry As String = "Select * from usuario where user_name = '{0}'"
            qry = String.Format(qry, Login1.UserName)
            cm.CommandText = qry
            Dim rs As SqlDataReader = cm.ExecuteReader
            If rs.Read Then
                If rs.Item("passwd").ToString.Equals(Login1.Password) Then
                    FormsAuthentication.RedirectFromLoginPage(Login1.UserName, Login1.RememberMeSet)
                Else
                    Login1.FailureText = "Error al ingresar al sistema, verifique su nombre de usuario y contraseña"
                End If
            End If
        Catch ex As Exception
            Login1.FailureText = "Hubo un error al tratar de ingresar al sistema: " & ex.Message
            System.Console.WriteLine(ex.Message)
        Finally
            con.Close()
        End Try

    End Sub
End Class