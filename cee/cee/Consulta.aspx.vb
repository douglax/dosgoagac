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
        If tb_consultar.Text.Length = 0 Then
            Return
        End If
        Dim s As ISession = NHelper.GetCurrentSession
        Dim id As Long = CLng(tb_consultar.Text)

        Dim soc As CeeLib.Socio = s.Get(GetType(CeeLib.Socio), id)
        If soc Is Nothing Then

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
        Lbl_Tipo.Text = soc.TipoDeSocio
        'pnl_socio_agencia_text.Text = soc.Agencia.Nombre 
        HiddenField1.Value = soc.NoSocio
        dg_puntos.DataSource = soc.CuartosNoche
        dg_puntos.DataBind()
        NHelper.CloseSession()
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

    Protected Sub btn_cantidad_cuartos_Click(sender As Object, e As EventArgs) Handles btn_cantidad_cuartos.Click
        If tb_cantidad_cuartos.Text.Length = 0 Then
            Return
        End If

        Dim cn As New CeeLib.RegistroNoches()
        cn.Cantidad = CDbl(tb_cantidad_cuartos.Text)
        cn.FechaAlta = Now()
        Dim s As ISession = NHelper.GetCurrentSession
        Dim u As CeeLib.Usuario = s.Get(GetType(CeeLib.Usuario), NHelper.UserName)
        cn.Hotel = u.Hotel
        cn.Socio = s.Get(GetType(CeeLib.Socio), CLng(HiddenField1.Value))
        cn.Socio.CuartosNoche.Add(cn)
        If cn.Socio.Club = 3 Then
            cn.Tipo = 2
        Else
            cn.Tipo = 1
        End If
        s.BeginTransaction()
        s.Save(cn)
        s.Transaction.Commit()
        dg_puntos.DataSource = cn.Socio.CuartosNoche
        Lbl_Tipo.Text = cn.Socio.TipoDeSocio
        dg_puntos.DataMember = "Id"
        dg_puntos.DataBind()
        NHelper.CloseSession()
        pnl_cuarto_noche.Visible = False
        tb_cantidad_cuartos.Text = ""
    End Sub

    Private Sub dg_puntos_PageIndexChanging(sender As Object, e As System.Web.UI.WebControls.GridViewPageEventArgs) Handles dg_puntos.PageIndexChanging

        Dim s As ISession = NHelper.GetCurrentSession
        Dim soc As CeeLib.Socio = s.Get(GetType(CeeLib.Socio), CLng(HiddenField1.Value))
        dg_puntos.PageIndex = e.NewPageIndex
        dg_puntos.DataSource = soc.CuartosNoche
        dg_puntos.DataBind()
        NHelper.CloseSession()

    End Sub

    Private Sub dg_puntos_RowDeleting(sender As Object, e As System.Web.UI.WebControls.GridViewDeleteEventArgs) Handles dg_puntos.RowDeleting
        Dim s As ISession = NHelper.GetCurrentSession
        Try
            Dim soc As CeeLib.Socio = s.Get(GetType(CeeLib.Socio), CLng(HiddenField1.Value))
            Dim cn As CeeLib.RegistroNoches = soc.CuartosNoche.Item(e.RowIndex)
            soc.CuartosNoche.Remove(cn)
            s.BeginTransaction()
            s.Delete(cn)
            s.Transaction.Commit()
            NHelper.CloseSession()
            dg_puntos.DataSource = soc.CuartosNoche
            dg_puntos.DataBind()
        Catch ex As Exception
            If s.Transaction.IsActive Then s.Transaction.Rollback()
            lbl_resultado.Text = "Ocurrio un error: " & ex.Message
        End Try

    End Sub

End Class