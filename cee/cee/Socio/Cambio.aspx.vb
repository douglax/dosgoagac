Imports CeeLib
Imports NHibernate

Public Class Cambio
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        If Not Me.IsPostBack Then
            For i As Integer = Now.Year To Now.Year - 100 Step -1
                Dim anoStr = New ListItem
                anoStr.Text = i.ToString
                anoStr.Value = i.ToString
                Me.ddl_cump_ano.Items.Add(anoStr)
            Next
            Dim s As ISession = NHelper.GetCurrentSession
            Dim comps As IList(Of CeeLib.Compania) = s.CreateQuery("from Compania").List(Of CeeLib.Compania)()
            Dim estado As IList = s.CreateQuery("From Estado e order by e.Nombre").List()
            NHelper.CloseSession()
            If Not comps Is Nothing Then
                ddl_compania.DataSource = comps
                ddl_compania.DataValueField = "Id"
                ddl_compania.DataTextField = "Nombre"
                ddl_compania.DataBind()
            End If
            With ddl_estado
                .DataSource = estado
                .DataTextField = "Nombre"
                .DataValueField = "Id"
                .DataBind()
            End With
            If tb_consultar.Text.Length <= 0 Then
                tb_consultar.Text = Request.QueryString("id_socio")

                If tb_consultar.Text.Length > 0 Then
                    LoadData(CLng(tb_consultar.Text))
                End If
            End If
        End If
    End Sub

    Protected Sub btn_modificar_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_modificar.Click
        Dim s As Socio
        Dim sesion As ISession = Nothing
        Try
            sesion = NHelper.GetCurrentSession()
            s = sesion.Get(GetType(CeeLib.Socio), CLng(tb_consultar.Text))
            sesion.BeginTransaction()
            s.Nombre = tb_nombre.Text
            s.Paterno = tb_apaterno.Text
            s.Materno = tb_amaterno.Text
            s.RFC = tb_rfc.Text
            s.Telefono = tb_telefono.Text
            s.Club = club.SelectedIndex + 1
            Dim dia As Integer = CInt(ddl_cump_dia.SelectedValue)
            Dim mes As Integer = CInt(ddl_cump_mes.SelectedValue)
            Dim anio As Integer = CInt(ddl_cump_ano.SelectedValue)
            s.FechaDeNacimiento = New Date(anio, mes, dia)
            s.Ciudad = sesion.Get(Of Ciudad)(CLng(ddl_ciudad.SelectedValue))
            s.Email = tb_correo.Text
            If tb_tarifa.Text.Length > 0 Then
                If IsNumeric(tb_tarifa.Text) Then
                    s.Tarifa = CDbl(tb_tarifa.Text)
                End If
            End If
            If club.SelectedIndex = 1 OrElse 2 Then
                Dim comp As New CeeLib.Compania
                Dim cId As Long = CLng(ddl_compania.SelectedValue)
                comp = sesion.Get(GetType(CeeLib.Compania), cId)
                comp.Contactos.Add(s)
                s.Compania = comp
            End If
            s.CtaSiVale = tb_sivale.Text
            sesion.Update(s)
            sesion.Transaction.Commit()
            NHelper.CloseSession()
            If club.SelectedIndex = 3 OrElse 2 Then
                's.Agencia = tb_agencia.Text
            End If
            lbl_resultado.Text = "La información del socio se actualizó con éxito"
        Catch ex As Exception
            If sesion.Transaction.IsActive Then
                sesion.Transaction.Rollback()
                sesion.Close()
            End If
            lbl_resultado.Text = "Ocurrio un error al guardar la información: " & ex.Message
        End Try
    End Sub

    Protected Sub btn_consultar_popup_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_consultar_popup.Click
        Me.grp_consultar.Visible = False
        Me.grp_busqueda.Visible = True
        Me.grp_modificar.Visible = False
    End Sub

    Protected Sub btn_consultar_Click(sender As Object, e As EventArgs) Handles btn_consultar.Click
        If tb_consultar.Text.Length = 0 Then
            Return
        End If
        LoadData(CLng(tb_consultar.Text))
    End Sub

    Protected Sub btn_busqueda_Click(sender As Object, e As EventArgs) Handles btn_busqueda.Click
        Dim qry As String
        qry = "select s from Socio s where s.Paterno like ? and s.Materno like ? and s.Nombre like ?"
        Dim s As ISession = NHelper.GetCurrentSession()
        Dim paterno As String = "%" & tb_buscar_paterno.Text & "%"
        Dim materno As String = "%" & tb_buscar_materno.Text & "%"
        Dim nombre As String = "%" & tb_buscar_nombre.Text & "%"
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

    Private Sub LoadData(id As Long)
        Dim s As ISession = NHelper.GetCurrentSession
        Dim soc As CeeLib.Socio = s.Get(GetType(CeeLib.Socio), id)
        If soc Is Nothing Then
            Return
        End If
        tb_nombre.Text = soc.Nombre
        tb_apaterno.Text = soc.Paterno
        tb_amaterno.Text = soc.Materno
        club.SelectedValue = soc.Club
        ddl_cump_dia.SelectedValue = soc.FechaDeNacimiento.Day.ToString
        ddl_cump_mes.SelectedValue = soc.FechaDeNacimiento.Month.ToString
        ddl_cump_ano.SelectedValue = soc.FechaDeNacimiento.Year.ToString
        ddl_compania.SelectedValue = soc.Compania.Id
        ddl_estado.SelectedValue = soc.Ciudad.Estado.Id
        With ddl_ciudad
            .DataSource = _
                s.CreateQuery("From Ciudad c where c.Estado.Id = ?").SetInt64(0, _
                    soc.Ciudad.Estado.Id).List()
            .DataTextField = "Nombre"
            .DataValueField = "Id"
            .DataBind()
            .SelectedValue = soc.Ciudad.Id
        End With
        tb_telefono.Text = soc.Telefono
        'tb_ciudad.Text = soc.Ciudad
        tb_correo.Text = soc.Email
        tb_rfc.Text = soc.RFC
        tb_tarifa.Text = soc.Tarifa
        tb_sivale.Text = soc.CtaSiVale
        NHelper.CloseSession()
        grp_modificar.Visible = True
        If soc.Club = 3 Then
            pnl_compania.Visible = False
            pnl_agencia.Visible = True
            pnl_tarifa.Visible = False
        Else
            pnl_compania.Visible = True
            pnl_agencia.Visible = False
            pnl_tarifa.Visible = True
        End If
    End Sub
End Class