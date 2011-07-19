Imports NHibernate
Imports System.Security.Cryptography
Imports System.Text

Public Class Alta2
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        If Not Page.IsPostBack Then
            Dim s As ISession = NHelper.GetCurrentSession()
            ddl_hotel.DataSource = s.CreateQuery("From Hotel h order by h.Nombre").List
            ddl_hotel.DataValueField = "Id"
            ddl_hotel.DataTextField = "Nombre"
            ddl_hotel.DataBind()
            NHelper.CloseSession()
        End If
    End Sub

    Protected Sub btn_guardar_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_guardar.Click
        Dim msg As String
        Me.lbl_aviso.ForeColor = Drawing.Color.Green
        msg = "El usuario se guardo en el sistema!..."
        If Me.tb_contrasena.Text = Me.tb_confirmacion.Text Then
            Dim s As ISession = NHelper.GetCurrentSession()
            Try
                Dim id As Long = CLng(ddl_hotel.SelectedValue)
                Dim hotel As CeeLib.Hotel = s.Get(GetType(CeeLib.Hotel), id)
                Dim usr As New CeeLib.Usuario()
                usr.Hotel = hotel
                usr.Usr = tb_usuario.Text
                usr.Passwd = Encrypt(tb_contrasena.Text)
                s.BeginTransaction()
                s.Save(usr)
                s.Transaction.Commit()
            Catch ex As Exception
                If s.Transaction.IsActive Then s.Transaction.Rollback()
                Me.lbl_aviso.ForeColor = Drawing.Color.Red
                msg = "El usuario ya existe!..."
            End Try
            NHelper.CloseSession()
        Else
            Me.lbl_aviso.ForeColor = Drawing.Color.Red
            msg = "La contraseña y la confirmacion no son iguales!..."
        End If
        Me.lbl_aviso.Text = msg
    End Sub

    Private Function Encrypt(val As String) As String
        Dim textBytes, encTextBytes As Byte()
        Dim rsa As New RSACryptoServiceProvider()
        Dim encoder As New UTF8Encoding()
        textBytes = encoder.GetBytes(val)
        encTextBytes = rsa.Encrypt(textBytes, True)
        Return Convert.ToBase64String(encTextBytes)
    End Function

    

End Class