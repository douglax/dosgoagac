Imports NHibernate
Public Class Informe_Resultados
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Select Case Me.Request.QueryString("club")
            Case 1
                Me.lbl_tipo.Text = "'Club Enlace' "
            Case 2
                Me.lbl_tipo.Text = "'Club Enlace Empresaria' "
            Case 3
                Me.lbl_tipo.Text = "'Club Enlace Travel' "
        End Select

        Me.pg_title.InnerText = Me.lbl_tipo.Text & " " & Me.Request.QueryString("tb_periodo_inicio") & " - " & Me.Request.QueryString("tb_periodo_final")

        Me.lbl_periodo_inicio.Text = Me.Request.QueryString("tb_periodo_inicio") & " - "
        Me.lbl_periodo_termino.Text = Me.Request.QueryString("tb_periodo_final")

        Dim qry As String
        qry = _
            "select s from RegistroNoches s where s.Socio.Club = ? and s.FechaAlta between ? and ?"
        Dim s As ISession = NHelper.GetCurrentSession()
        Dim club As Integer = Me.Request.QueryString("club")
        Dim inicio As Date = Me.Request.QueryString("tb_periodo_inicio")
        Dim fin As Date = Me.Request.QueryString("tb_periodo_final")
        Dim res As IList = s.CreateQuery(qry).SetInt32(0, club).SetDateTime(1, inicio).SetDateTime(2, fin).List()
        dg_resultados.DataSource = res
        dg_resultados.DataBind()
        NHelper.CloseSession()


    End Sub

End Class