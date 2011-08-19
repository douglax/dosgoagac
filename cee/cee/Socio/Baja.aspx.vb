Imports NHibernate
Public Class Baja
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Protected Sub btn_busqueda_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_busqueda.Click
        Me.pnl_resultados.Visible = True
        Dim qry As String
        qry = "select s from Socio s where s.Paterno like ? and s.Materno like ? and s.Nombre like ?"
        Dim s As ISession = NHelper.GetCurrentSession()
        Dim paterno As String = "%" & tb_busqueda_paterno.Text & "%"
        Dim materno As String = "%" & tb_busqueda_materno.Text & "%"
        Dim nombre As String = "%" & tb_busqueda_nombre.Text & "%"
        Dim res As IList = s.CreateQuery(qry).SetString(0, paterno).SetString(1, materno).SetString(2, nombre).List()
        dg_resultados.DataSource = res
        dg_resultados.DataBind()
        If res.Count = 0 Then

            Me.lbl_resultado.ForeColor = Drawing.Color.Red
            Me.lbl_resultado.Text = "No se encontraron resultados!..."

        Else

            Me.lbl_resultado.ForeColor = Drawing.Color.Green
            Me.lbl_resultado.Text = ""

        End If

        NHelper.CloseSession()
    End Sub

    Private Sub dg_resultados_PageIndexChanging(sender As Object, e As System.Web.UI.WebControls.GridViewPageEventArgs) Handles dg_resultados.PageIndexChanging
        dg_resultados.PageIndex = e.NewPageIndex

        Dim s As ISession = NHelper.GetCurrentSession
        Dim qry As String
        qry = "select s from Socio s where s.Paterno like ? and s.Materno like ? and s.Nombre like ?"

        Dim paterno As String = "%" & tb_busqueda_paterno.Text & "%"
        Dim materno As String = "%" & tb_busqueda_materno.Text & "%"
        Dim nombre As String = "%" & tb_busqueda_nombre.Text & "%"
        Dim res As IList = s.CreateQuery(qry).SetString(0, paterno).SetString(1, materno).SetString(2, nombre).List()
        dg_resultados.DataSource = res
        dg_resultados.DataBind()
        NHelper.CloseSession()

    End Sub

    Private Sub dg_resultados_RowDeleting(sender As Object, e As System.Web.UI.WebControls.GridViewDeleteEventArgs) Handles dg_resultados.RowDeleting
        Dim row As GridViewRow = dg_resultados.Rows(e.RowIndex)
        Dim id As Long = CLng(row.Cells(0).Text)
        Dim s As ISession = NHelper.GetCurrentSession
        Try
            Dim soc As CeeLib.Socio = s.Get(Of CeeLib.Socio)(id)
            Dim u As CeeLib.Usuario = s.Get(GetType(CeeLib.Usuario), NHelper.UserName)
            If u.Hotel.Id > 1 Then
                If soc.IdHotel <> u.Hotel.Id Then
                    Response.Redirect("../Denegada.aspx")
                    NHelper.CloseSession()
                    Exit Sub
                End If
            End If
            s.BeginTransaction()
            s.Delete(soc)
            s.Transaction.Commit()
            NHelper.CloseSession()
            lbl_resultado.ForeColor = Drawing.Color.Green
            lbl_resultado.Text = "Socio dado de baja con éxito"
            btn_busqueda_Click(Nothing, Nothing)
        Catch ex As Exception
            If s.Transaction.IsActive Then s.Transaction.Rollback()
            lbl_resultado.ForeColor = Drawing.Color.Red
            lbl_resultado.Text = "Ocurrio un error al dar de baja el socio: " & ex.Message
        End Try

    End Sub

    Protected Sub dg_resultados_SelectedIndexChanged(sender As Object, e As EventArgs) Handles dg_resultados.SelectedIndexChanged

    End Sub
End Class