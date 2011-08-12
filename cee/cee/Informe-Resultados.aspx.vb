Imports NHibernate
Public Class Informe_Resultados
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Dim club As Integer = Me.Request.QueryString("club")
        Dim inicio As Date = Me.Request.QueryString("tb_periodo_inicio")
        Dim fin As Date = Me.Request.QueryString("tb_periodo_final")
        Dim tipo As Integer = Me.Request.QueryString("ddl_tipo")

        Dim qry As String
        qry = "select s from RegistroNoches s where s.Socio.Club = ? and s.FechaAlta between ? and ?"
        Dim s As ISession = NHelper.GetCurrentSession()
        Dim res As IList = s.CreateQuery(qry).SetInt32(0, club).SetDateTime(1, inicio).SetDateTime(2, fin).List()

        Select Case club
            Case 1
                Me.lbl_tipo.Text = "'Club Enlace' "
                Select Case tipo
                    Case 1

                    Case 2
                        dg_resultados_2.DataSource = res
                        dg_resultados_2.DataBind()
                End Select
            Case 2
                Me.lbl_tipo.Text = "'Club Enlace Empresaria' "
                Select Case tipo
                    Case 1

                    Case 2
                        dg_resultados_1.DataSource = res
                        dg_resultados_1.DataBind()
                End Select
            Case 3
                Me.lbl_tipo.Text = "'Club Enlace Travel' "
                Select Case tipo
                    Case 1

                    Case 2
                        dg_resultados_2.DataSource = res
                        dg_resultados_2.DataBind()
                End Select
        End Select

        Me.pg_title.InnerText = Me.lbl_tipo.Text & " " & inicio & " - " & fin
        Me.lbl_periodo_inicio.Text = inicio & " - "
        Me.lbl_periodo_termino.Text = fin

        NHelper.CloseSession()


    End Sub

End Class