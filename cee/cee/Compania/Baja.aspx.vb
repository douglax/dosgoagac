Imports NHibernate
Public Class Baja1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Protected Sub btn_busqueda_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_busqueda.Click
        Me.pnl_resultados.Visible = True
        Dim qry As String
        qry = "select s from Compania s where s.Nombre like ?"
        Dim s As ISession = NHelper.GetCurrentSession()
        Dim compania As String = "%" & tb_busqueda_nombre.Text & "%"
        Dim res As IList = s.CreateQuery(qry).SetString(0, compania).List()
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

    Private Sub dg_resultados_RowDeleting(ByVal sender As Object, ByVal e As System.Web.UI.WebControls.GridViewDeleteEventArgs) Handles dg_resultados.RowDeleting

    End Sub

End Class