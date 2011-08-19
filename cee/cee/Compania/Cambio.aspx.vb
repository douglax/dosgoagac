Imports NHibernate
Public Class Cambio1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        If Not Page.IsPostBack Then
            Dim s As ISession = NHelper.GetCurrentSession()
            With ddl_estado
                .DataSource = s.CreateQuery("From Estado").List()
                .DataTextField = "Nombre"
                .DataValueField = "Id"
                .DataBind()
            End With
            NHelper.CloseSession()
        End If
        If tb_consultar.Text.Length <= 0 Then
            tb_consultar.Text = Request.QueryString("id")
            If tb_consultar.Text.Length > 0 Then
                LoadData(CLng(tb_consultar.Text))
            End If
        End If
    End Sub

    Protected Sub btn_consultar_popup_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_consultar_popup.Click
        Me.grp_consultar.Visible = False
        Me.grp_busqueda.Visible = True
        grp_modificar.Visible = False
    End Sub

    Protected Sub btn_busqueda_Click(sender As Object, e As EventArgs) Handles btn_busqueda.Click
        Dim qry As String = "from Compania c where c.Nombre like ?"
        Dim s As ISession = NHelper.GetCurrentSession
        Dim res As IList = s.CreateQuery(qry).SetString(0, _
                "%" & tb_busqueda_nombre.Text & "%").List
        If Not res Is Nothing Then
            dg_resultados.DataSource = res
            dg_resultados.DataBind()
            If res.Count = 0 Then

                Me.lblResultado.ForeColor = Drawing.Color.Red
                Me.lblResultado.Text = "No se encontraron resultados!..."

            Else

                Me.lblResultado.ForeColor = Drawing.Color.Green
                Me.lblResultado.Text = ""

            End If
        End If
        NHelper.CloseSession()
    End Sub

    Private Sub LoadData(id As Long)

        Dim s As ISession = NHelper.GetCurrentSession
        Try
            Dim comp As CeeLib.Compania = s.Get(GetType(CeeLib.Compania), id)
            If Not comp Is Nothing Then
                tb_nombre.Text = comp.Nombre
                tb_direccion.Text = comp.Direccion
                ChkAgencia.Checked = comp.EsAgencia
                grp_modificar.Visible = True
                lblResultado.Text = ""
                HiddenField1.Value = comp.Id.ToString
                ddl_estado.SelectedValue = comp.Ciudad.Estado.Id
                With ddl_ciudad
                    .DataSource = _
                        s.CreateQuery("From Ciudad c where c.Estado.Id = ?").SetInt64(0, _
                            comp.Ciudad.Estado.Id).List()
                    .DataTextField = "Nombre"
                    .DataValueField = "Id"
                    .DataBind()
                    .SelectedValue = comp.Ciudad.Id
                End With
            Else
                grp_modificar.Visible = False
                HiddenField1.Value = ""
                lblResultado.Text = "La búsqueda no genero ningún resultado"
            End If
            NHelper.CloseSession()
        Catch ex As Exception
            lblResultado.ForeColor = Drawing.Color.Red
            lblResultado.Text = "Ocurrio un error al realizar la consulta: " & ex.Message
        End Try

    End Sub

    Protected Sub btn_consultar_Click(sender As Object, e As EventArgs) Handles btn_consultar.Click
        Try
            LoadData(CLng(tb_consultar.Text))
        Catch ex As Exception
            lblResultado.ForeColor = Drawing.Color.Red
            lblResultado.Text = "Ocurrio un error al realizar la consulta: " & ex.Message
        End Try
    End Sub

    Protected Sub btn_guardar_Click(sender As Object, e As EventArgs) Handles btn_guardar.Click
        Dim s As ISession = NHelper.GetCurrentSession
        Try
            Dim comp As CeeLib.Compania = s.Get(GetType(CeeLib.Compania), CLng(HiddenField1.Value))
            comp.Nombre = tb_nombre.Text
            comp.Direccion = tb_direccion.Text
            comp.EsAgencia = ChkAgencia.Checked
            comp.Ciudad = s.Get(Of CeeLib.Ciudad)(CLng(ddl_ciudad.SelectedValue))
            s.BeginTransaction()
            s.Update(comp)
            s.Transaction.Commit()
            lblResultado.ForeColor = Drawing.Color.Green
            lblResultado.Text = "La información se guardo exitosamente"
        Catch ex As Exception
            If s.Transaction.IsActive Then s.Transaction.Rollback()
            lblResultado.Text = "Ocurrio un error al guardar la información: " & ex.Message
        Finally
            NHelper.CloseSession()
        End Try

    End Sub
End Class