Imports NHibernate
Public Class Consulta1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        If Not Page.IsPostBack Then
            Dim s As ISession = NHelper.GetCurrentSession
            ddl_Companias.DataSource = s.CreateQuery("From Compania c order by c.Nombre").List()
            ddl_Companias.DataTextField = "Nombre"
            ddl_Companias.DataValueField = "Id"
            ddl_Companias.DataBind()
            NHelper.CloseSession()
        End If
        If tb_consultar.Text.Length <= 0 Then
            tb_consultar.Text = Request.QueryString("id_socio")
        End If
    End Sub

    Protected Sub btn_consultar_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_consultar.Click
        Dim s As ISession = NHelper.GetCurrentSession
        Dim id As Long = CLng(tb_consultar.Text)

        Dim soc As CeeLib.Socio = s.Get(GetType(CeeLib.Socio), id)
        If soc Is Nothing Then
            MsgBox("No se encontro ningun socio con el numero " & id, MsgBoxStyle.Critical)
            Return
        End If
        lbl_socio_nombre_value.Text = soc.Nombre & " " & soc.Paterno & " " & soc.Materno
        Select Case soc.Club
            Case 1
                pnl_socio_club_value.Text = "Club Enlace"
            Case 2
                pnl_socio_club_value.Text = "Club Enlace Empresarial"
            Case 3
                pnl_socio_club_value.Text = "Enlace Travel Club"
        End Select
        pnl_socio_cumpleanos_value.Text = soc.FechaDeNacimiento.ToString("D")
        pnl_socio_telefono_value.Text = soc.Telefono
        pnl_socio_ciudad_value.Text = soc.Ciudad
        pnl_socio_mail_value.Text = soc.Email
        pnl_socio_rfc_value.Text = soc.RFC
        pnl_socio_tarifa_value.Text = FormatCurrency(soc.Tarifa)
        'pnl_socio_agencia_text.Text = soc.Agencia.Nombre 
    End Sub

    Protected Sub btn_consultar_popup_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_consultar_popup.Click
        Me.grp_consultar.Visible = False
        Me.grp_busqueda.Visible = True
        Me.lbl_page_title.Text = Me.lbl_page_title.Text & " > Busqueda por Nombre o Compañia"
    End Sub

    Protected Sub btn_busqueda_Click(sender As Object, e As EventArgs) Handles btn_busqueda.Click
        Dim qry As String
        qry = "select s from Socio s where s.Paterno like ? and s.Materno like ? and s.Nombre like ?"
        Dim s As ISession = NHelper.GetCurrentSession()
        Dim paterno As String = "%" & tb_busqueda_paterno.Text & "%"
        Dim materno As String = "%" & tb_busqueda_materno.Text & "%"
        Dim nombre As String = "%" & tb_busqueda_nombre.Text & "%"
        Dim res As IList = s.CreateQuery(qry).SetString(0, paterno).SetString(1, materno).SetString(2, nombre).List()
        dg_resultados.DataSource = res
        dg_resultados.DataBind()

        NHelper.CloseSession()

    End Sub

    Protected Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim s As ISession = NHelper.GetCurrentSession
        Dim id As Long = ddl_Companias.SelectedValue()
        Dim c As CeeLib.Compania = s.Get(Of CeeLib.Compania)(id)
        dg_resultados.DataSource = c.Contactos
        dg_resultados.DataBind()
    End Sub

    
    Protected Sub btn_puntos_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_puntos.Click

        Me.pnl_cuarto_noche.Visible = True

    End Sub
End Class