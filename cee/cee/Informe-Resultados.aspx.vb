Imports NHibernate
Public Class Informe_Resultados
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Dim dg_resultados = Nothing
        Dim club As Integer = Me.Request.QueryString("club")
        Dim inicio As Date = Me.Request.QueryString("tb_periodo_inicio")
        Dim fin As Date = Me.Request.QueryString("tb_periodo_final")
        Dim tipo As Integer = Me.Request.QueryString("ddl_tipo")

        Dim qry As String = ""

        Select Case club
            Case 1
                Me.lbl_tipo.Text = "'Club Enlace' "
                Select Case tipo
                    Case 1
                        qry = "SELECT (S.NOMBRE + ' ' + S.PATERNO + ' ' + S.MATERNO) AS NOMBRE_COMPLETO, S.CTA_SIVALE, H.NOMBRE AS HOTEL, (CN.CANTIDAD * H.MONTO_ENLACE) AS TOTAL FROM CUARTOS_NOCHE CN INNER JOIN HOTEL H ON CN.ID_HOTEL = H.ID INNER JOIN SOCIO S ON CN.SOCIO_ID = S.NO_SOCIO WHERE S.CLUB = '" & club & "' AND CN.FECHA_ALTA BETWEEN convert(datetime, '" & inicio.ToString("dd/MM/yyyy") & "', 103) AND convert(datetime, '" & fin.ToString("dd/MM/yyyy") & "', 103)"
                        dg_resultados = dg_resultados_3
                    Case 2
                        qry = "SELECT S.NO_SOCIO, (S.NOMBRE + ' ' + S.PATERNO + ' ' + S.MATERNO) AS NOMBRE_COMPLETO, SUM(CN.CANTIDAD) AS CANTIDAD FROM SOCIO S INNER JOIN CUARTOS_NOCHE CN ON S.NO_SOCIO = CN.SOCIO_ID WHERE S.CLUB = '" & club & "' AND CN.FECHA_ALTA BETWEEN convert(datetime, '" & inicio.ToString("dd/MM/yyyy") & "', 103) AND convert(datetime, '" & fin.ToString("dd/MM/yyyy") & "', 103) GROUP BY S.NO_SOCIO, S.NOMBRE, S.PATERNO, S.MATERNO"
                        dg_resultados = dg_resultados_2
                End Select
            Case 2
                Me.lbl_tipo.Text = "'Club Enlace Empresarial' "
                Select Case tipo
                    Case 1
                        'qry = "SELECT C.ID, C.NOMBRE AS COMPANIA, S.CTA_SIVALE, SUM(CN.CANTIDAD) AS CUARTOS_NOCHE FROM CUARTOS_NOCHE CN INNER JOIN SOCIO S ON CN.SOCIO_ID = S.NO_SOCIO INNER JOIN COMPANIA C ON S.ID_COMP = C.ID GROUP BY C.ID, C.NOMBRE, S.CTA_SIVALE"
                        qry = "SELECT C.NOMBRE AS COMPANIA, (S.NOMBRE + ' ' + S.PATERNO + ' ' + S.MATERNO) AS NOMBRE_COMPLETO, CASE WHEN S.TIPO_CONTACTO = 1 THEN 'Contacto Principal' WHEN S.TIPO_CONTACTO = 0 THEN 'Contacto Secundario' END AS CONTACTO, S.CTA_SIVALE, CN.CANTIDAD AS CUARTOS_NOCHE, CN.TARIFA, (CN.CANTIDAD * CN.TARIFA) AS TOTAL FROM SOCIO S INNER JOIN COMPANIA C ON S.ID_COMP = C.ID INNER JOIN CUARTOS_NOCHE CN ON S.NO_SOCIO = CN.SOCIO_ID WHERE C.ESAGENCIA = 0 AND S.CLUB = '" & club & "' AND CN.FECHA_ALTA BETWEEN convert(datetime, '" & inicio.ToString("dd/MM/yyyy") & "', 103) AND convert(datetime, '" & fin.ToString("dd/MM/yyyy") & "', 103) ORDER BY COMPANIA"
                        dg_resultados = dg_resultados_4
                    Case 2
                        qry = "SELECT CN.ID, C.NOMBRE AS COMPANIA, (S.NOMBRE + ' ' + S.PATERNO + ' ' + S.MATERNO) AS NOMBRE_COMPLETO, CN.TARIFA, CN.CANTIDAD, (CN.TARIFA * CN.CANTIDAD) AS TOTAL FROM COMPANIA C INNER JOIN SOCIO S ON C.ID = S.ID_COMP INNER JOIN CUARTOS_NOCHE CN ON S.NO_SOCIO = CN.SOCIO_ID WHERE S.CLUB = '" & club & "' AND CN.FECHA_ALTA BETWEEN convert(datetime, '" & inicio.ToString("dd/MM/yyyy") & "', 103) AND convert(datetime, '" & fin.ToString("dd/MM/yyyy") & "', 103) ORDER BY COMPANIA"
                        dg_resultados = dg_resultados_1
                End Select
            Case 3
                Me.lbl_tipo.Text = "'Club Enlace Travel' "
                Select Case tipo
                    Case 1
                        qry = "SELECT (S.NOMBRE + ' ' + S.PATERNO + ' ' + S.MATERNO) AS NOMBRE_COMPLETO, S.CTA_SIVALE, H.NOMBRE AS HOTEL, (CN.CANTIDAD * 10) AS TOTAL FROM CUARTOS_NOCHE CN INNER JOIN HOTEL H ON CN.ID_HOTEL = H.ID INNER JOIN SOCIO S ON CN.SOCIO_ID = S.NO_SOCIO WHERE S.CLUB = '" & club & "' AND CN.FECHA_ALTA BETWEEN convert(datetime, '" & inicio.ToString("dd/MM/yyyy") & "', 103) AND convert(datetime, '" & fin.ToString("dd/MM/yyyy") & "', 103)"
                        dg_resultados = dg_resultados_3
                    Case 2
                        qry = "SELECT S.NO_SOCIO, (S.NOMBRE + ' ' + S.PATERNO + ' ' + S.MATERNO) AS NOMBRE_COMPLETO, SUM(CN.CANTIDAD) AS CANTIDAD FROM SOCIO S INNER JOIN CUARTOS_NOCHE CN ON S.NO_SOCIO = CN.SOCIO_ID WHERE S.CLUB = '" & club & "' AND CN.FECHA_ALTA BETWEEN convert(datetime, '" & inicio.ToString("dd/MM/yyyy") & "', 103) AND convert(datetime, '" & fin.ToString("dd/MM/yyyy") & "', 103) GROUP BY S.NO_SOCIO, S.NOMBRE, S.PATERNO, S.MATERNO"
                        dg_resultados = dg_resultados_2
                End Select
        End Select

        If Not dg_resultados Is Nothing Then

            Dim s As ISession = NHelper.GetCurrentSession()
            Dim da As System.Data.IDataAdapter = New Data.SqlClient.SqlDataAdapter(qry, DirectCast(s.Connection, Data.SqlClient.SqlConnection))
            Dim ds As New DataSet
            da.Fill(ds)

            dg_resultados.DataSource = ds.Tables(0)
            dg_resultados.DataBind()

            NHelper.CloseSession()

        End If

        Me.pg_title.InnerText = Me.lbl_tipo.Text & " " & inicio & " - " & fin
        Me.lbl_periodo_inicio.Text = inicio & " - "
        Me.lbl_periodo_termino.Text = fin

    End Sub

End Class