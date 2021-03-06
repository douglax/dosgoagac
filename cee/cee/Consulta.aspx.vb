﻿Imports NHibernate
Public Class Consulta1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Me.lbl_resultado.Text = ""

        Dim administrador As Boolean
        administrador = True
        If administrador Then
            Me.menu_item_admin.Visible = True
            Me.menu_items.Attributes.Add("class", "menu-bg-administracion")
        End If

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
            LoadData(CLng(Request.QueryString("id_socio")))
        End If
    End Sub

    Protected Sub btn_consultar_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_consultar.Click
        If tb_consultar.Text.Length = 0 Then
            Return
        End If
        LoadData(CLng(tb_consultar.Text))
        Me.pnl_cuarto_noche.Visible = False
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
        If res.Count = 0 Then
            Me.lbl_resultado.ForeColor = Drawing.Color.Red
            Me.lbl_resultado.Text = "No se encontraron resultados!..."
        Else
            Me.lbl_resultado.ForeColor = Drawing.Color.Green
            Me.lbl_resultado.Text = ""
        End If
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
        If Me.Request.QueryString("club") = 2 Then
            Me.pnl_tarifa.Visible = True
            tb_tarifa.Text = pnl_socio_tarifa_value.Text
        Else
            Me.pnl_tarifa.Visible = False
        End If
    End Sub

    Protected Sub btn_cantidad_cuartos_Click(sender As Object, e As EventArgs) Handles btn_cantidad_cuartos.Click
        If tb_cantidad_cuartos.Text.Length = 0 Then
            Return
        End If

        Dim cn As New CeeLib.RegistroNoches()
        cn.Cantidad = CDbl(tb_cantidad_cuartos.Text)
        cn.FechaAlta = Now()
        Dim s As ISession = NHelper.GetCurrentSession
        Dim u As CeeLib.Usuario = s.Get(GetType(CeeLib.Usuario), Session.Item("user").ToString)
        cn.Hotel = u.Hotel
        cn.Socio = s.Get(GetType(CeeLib.Socio), CLng(HiddenField1.Value))
        cn.Socio.CuartosNoche.Add(cn)
        If cn.Socio.Club = 3 Then
            cn.Tipo = 2
        Else
            cn.Tipo = 1
        End If
        If cn.Socio.Club = 2 Then
            cn.Tarifa = CDbl(tb_tarifa.Text)
        End If
        s.BeginTransaction()
        s.Save(cn)
        s.Transaction.Commit()
        dg_puntos.DataSource = cn.Socio.CuartosNoche
        Lbl_Tipo.Text = cn.Socio.TipoDeSocio & ": " & cn.Socio.TotalPuntos & " Puntos "
        If cn.Socio.Club = 2 Then Lbl_Tipo.Text += "<br/>" + cn.Socio.Compania.CalcularTipoCompania + " Puntos totales de la compañia: " & cn.Socio.Compania.CalcularPuntos()

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
            Dim id As Long = CLng(dg_puntos.Rows(e.RowIndex).Cells(0).Text)
            Dim cn As CeeLib.RegistroNoches = s.Get(GetType(CeeLib.RegistroNoches), id)
            Dim u As CeeLib.Usuario = s.Get(Of CeeLib.Usuario)(Session.Item("user").ToString)
            If u.Hotel.Id > 1 Then
                If u.Hotel.Id <> cn.Hotel.Id Then
                    Response.Redirect("Denegada.aspx")
                    NHelper.CloseSession()
                    Exit Sub
                End If
            End If
            soc.CuartosNoche.Remove(cn)
            s.BeginTransaction()
            s.Delete(cn)
            s.Transaction.Commit()
            dg_puntos.DataSource = soc.CuartosNoche
            dg_puntos.DataBind()
            NHelper.CloseSession()
        Catch ex As Exception
            If s.Transaction.IsActive Then s.Transaction.Rollback()
            lbl_resultado.Text = "Ocurrio un error: " & ex.Message
        End Try

    End Sub

    Private Sub LoadData(id As Long)
        Dim s As ISession = NHelper.GetCurrentSession
        Try
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
            Select Case soc.Sexo
                Case "H"
                    pnl_sexo_text.Text = "Hombre"
                Case "M"
                    pnl_sexo_text.Text = "Mujer"
            End Select
            Select Case soc.EdoCivil
                Case "C"
                    pnl_edo_civil_text.Text = "Casado(a)"
                Case "S"
                    pnl_edo_civil_text.Text = "Soltero(a)"
                Case "D"
                    pnl_edo_civil_text.Text = "Divorciado(a)"
            End Select
            Me.frm_consulta.Action = "?club=" & soc.Club
            pnl_socio_cumpleanos_value.Text = soc.FechaDeNacimiento.ToString("D")
            pnl_socio_telefono_value.Text = soc.Telefono
            pnl_socio_ciudad_value.Text = soc.Ciudad.Nombre
            pnl_socio_mail_value.Text = soc.Email
            pnl_socio_rfc_value.Text = soc.RFC
            pnl_socio_tarifa_value.Text = FormatCurrency(soc.Tarifa)
            pnl_compania_text.Text = soc.Compania.Nombre
            Lbl_Tipo.Text = soc.TipoDeSocio & " " & soc.TotalPuntos & " Puntos "
            If soc.Club = 2 Then Lbl_Tipo.Text += "<br/>" + soc.Compania.CalcularTipoCompania + " Puntos totales de la compañia: " & soc.Compania.CalcularPuntos()
            pnl_sivale_text.Text = soc.CtaSiVale
            pnl_face_text.Text = soc.CtaFacebook
            pnl_twitter_text.Text = soc.CtaTwitter
            pnl_gustos_text.Text = soc.Gustos
            If soc.Club = 3 Then
                pnl_socio_agencia_value.Text = soc.Compania.Nombre
                pnl_socio_agencia.Visible = True
                pnl_compania.Visible = False
                pnl_socio_tarifa.Visible = False
            Else
                pnl_socio_agencia.Visible = False
                pnl_compania.Visible = True
                pnl_socio_tarifa.Visible = True
            End If
            HiddenField1.Value = soc.NoSocio
            dg_puntos.DataSource = soc.CuartosNoche
            dg_puntos.DataBind()
            NHelper.CloseSession()
        Catch ex As Exception
            lbl_resultado.Text = "Ocurrio un error al realizar la consulta: " & ex.Message
        End Try
    End Sub

End Class