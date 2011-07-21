Imports CeeLib
Imports NHibernate

Public Class Alta1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        If Not Page.IsPostBack Then
            Dim s As ISession = NHelper.GetCurrentSession()
            With ddl_estado
                .DataSource = s.CreateQuery("From Estado").List
                .DataTextField = "Nombre"
                .DataValueField = "Id"
                .DataBind()
                .Items.Insert(0, "Seleccione...")
            End With

            NHelper.CloseSession()
        End If
    End Sub

    Protected Sub btn_guardar_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_guardar.Click
        Dim c As New CeeLib.Compania()
        Dim s As ISession = Nothing
        c.Nombre = tb_nombre.Text
        c.Direccion = tb_direccion.Text
        Try
            s = NHelper.GetCurrentSession
            c.Ciudad = s.Get(Of Ciudad)(CLng(ddl_ciudad.SelectedValue))
            s.BeginTransaction()
            s.Save(c)
            s.Transaction.Commit()
            lblResultado.ForeColor = Drawing.Color.Green
            lblResultado.Text = "Compañía registrada"
        Catch ex As Exception
            If s.Transaction.IsActive Then
                s.Transaction.Rollback()
            End If
            lblResultado.ForeColor = Drawing.Color.Red
            lblResultado.Text = "Ocurrio un error al registrar la información: " & ex.Message
        Finally
            NHelper.CloseSession()
        End Try

    End Sub

    Protected Sub ddl_estado_SelectedIndexChanged(sender As Object, e As EventArgs) Handles ddl_estado.SelectedIndexChanged
        If ddl_estado.SelectedIndex > 0 Then
            Dim id As Long = ddl_estado.SelectedValue
            Dim s As ISession = NHelper.GetCurrentSession()
            Dim ciudad As IList = _
                s.CreateQuery("From Ciudad c where c.Estado.Id = ?").SetInt64(0, id).List()
            ddl_ciudad.DataSource = ciudad
            ddl_ciudad.DataTextField = "Nombre"
            ddl_ciudad.DataValueField = "Id"
            ddl_ciudad.DataBind()
            NHelper.CloseSession()
        Else
            ddl_ciudad.Items.Clear()
        End If
    End Sub
End Class