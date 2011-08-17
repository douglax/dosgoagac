Imports CeeLib
Imports NHibernate

Public Class Alta
    Inherits System.Web.UI.Page

    Private oSocio As New Socio

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
       
        If Not Me.IsPostBack Then
            For i As Integer = Now.Year To Now.Year - 100 Step -1
                Dim anoStr = New ListItem
                anoStr.Text = i.ToString
                anoStr.Value = i.ToString
                Me.ddl_cump_ano.Items.Add(anoStr)
                
            Next

            Dim s As ISession = NHelper.GetCurrentSession
            Dim comps As IList(Of CeeLib.Compania) = s.CreateQuery("from Compania c order by c.Nombre").List(Of CeeLib.Compania)()
            Dim estado As IList(Of CeeLib.Estado) = s.CreateQuery("From Estado e order by e.Nombre").List(Of CeeLib.Estado)()

            NHelper.CloseSession()
            If Not comps Is Nothing Then
                ddl_compania.DataSource = comps
                ddl_compania.DataValueField = "Id"
                ddl_compania.DataTextField = "Nombre"
                ddl_compania.DataBind()
            End If

            ddl_estado.DataSource = estado
            ddl_estado.DataTextField = "Nombre"
            ddl_estado.DataValueField = "Id"
            ddl_estado.DataBind()
            ddl_estado.Items.Insert(0, "Seleccione...")

            Me.pnl_contacto.Visible = False
            Me.pnl_nombre.Visible = False
            Me.pnl_amaterno.Visible = False
            Me.pnl_apaterno.Visible = False
            Me.pnl_ciudad.Visible = False
            Me.pnl_correo.Visible = False
            Me.pnl_cumpleanos.Visible = False
            Me.pnl_rfc.Visible = False
            Me.pnl_tarifa.Visible = False
            Me.pnl_telefono.Visible = False
            Me.pnl_agencia.Visible = False
            Me.pnl_guardar.Visible = False
            Me.pnl_compania.Visible = False
            Me.pnl_resultado.Visible = False
            pnl_estado.Visible = False
            pnl_sivale.Visible = False
            pnl_facebook.Visible = False
            pnl_twitter.Visible = False
            pnl_sexo.Visible = False
            pnl_estado_civil.Visible = False
            pnl_gustos.Visible = False

            Dim ddl_contacto_1 = New ListItem
            ddl_contacto_1.Text = "Seleccionar"
            ddl_contacto_1.Value = "0"
            Me.ddl_contacto.Items.Add(ddl_contacto_1)

            Dim ddl_contacto_2 = New ListItem
            ddl_contacto_2.Text = "Principal"
            ddl_contacto_2.Value = "1"
            Me.ddl_contacto.Items.Add(ddl_contacto_2)

            Dim ddl_contacto_3 = New ListItem
            ddl_contacto_3.Text = "Adicional"
            ddl_contacto_3.Value = "2"
            Me.ddl_contacto.Items.Add(ddl_contacto_3)

            Dim ddlItem0 = New ListItem
            ddlItem0.Text = "Seleccionar..."
            ddlItem0.Value = "0"
            Me.club.Items.Add(ddlItem0)

            Dim ddlItem1 = New ListItem
            ddlItem1.Text = "Enlace"
            ddlItem1.Value = "1"
            Me.club.Items.Add(ddlItem1)

            Dim ddlItem2 = New ListItem
            ddlItem2.Text = "Enlace Empresarial"
            ddlItem2.Value = "2"
            Me.club.Items.Add(ddlItem2)

            Dim ddlItem3 = New ListItem
            ddlItem3.Text = "Travel"
            ddlItem3.Value = "3"
            Me.club.Items.Add(ddlItem3)

        End If

    End Sub

    Private Sub club_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles club.SelectedIndexChanged

        pnl_facebook.Visible = True
        pnl_twitter.Visible = True
        pnl_sexo.Visible = True
        pnl_estado_civil.Visible = True
        pnl_gustos.Visible = True
        Select Case Me.club.SelectedItem.Value
            Case 0
                Me.pnl_seleccionar.Visible = True
                Me.pnl_contacto.Visible = False
                Me.pnl_nombre.Visible = False
                Me.pnl_amaterno.Visible = False
                Me.pnl_apaterno.Visible = False
                Me.pnl_ciudad.Visible = False
                Me.pnl_correo.Visible = False
                Me.pnl_cumpleanos.Visible = False
                Me.pnl_rfc.Visible = False
                Me.pnl_tarifa.Visible = False
                Me.pnl_telefono.Visible = False
                Me.pnl_agencia.Visible = False
                Me.pnl_guardar.Visible = False
                Me.pnl_compania.Visible = False
                pnl_estado.Visible = False
                pnl_sivale.Visible = False
                pnl_facebook.Visible = False
                pnl_twitter.Visible = False
                pnl_sexo.Visible = False
                pnl_estado_civil.Visible = False
                pnl_gustos.Visible = False
            Case 1
                Me.pnl_seleccionar.Visible = False
                Me.pnl_contacto.Visible = False
                Me.pnl_nombre.Visible = True
                Me.pnl_amaterno.Visible = True
                Me.pnl_apaterno.Visible = True
                Me.pnl_ciudad.Visible = True
                Me.pnl_correo.Visible = True
                Me.pnl_cumpleanos.Visible = True
                Me.pnl_rfc.Visible = True
                Me.pnl_tarifa.Visible = True
                Me.pnl_telefono.Visible = True
                Me.pnl_agencia.Visible = False
                Me.pnl_guardar.Visible = True
                Me.pnl_compania.Visible = True
                If Request.QueryString("CompaniaId") <> "" Then
                    Me.ddl_compania.SelectedValue = Request.QueryString("CompaniaId")
                End If
                pnl_estado.Visible = True
                pnl_sivale.Visible = True
            Case 2
                Me.pnl_seleccionar.Visible = False
                If Request.QueryString("ContactoId") <> "" Then
                    Me.pnl_contacto.Visible = True
                    Me.ddl_contacto.SelectedValue = Request.QueryString("ContactoId")
                End If
                Me.pnl_nombre.Visible = True
                Me.pnl_amaterno.Visible = True
                Me.pnl_apaterno.Visible = True
                Me.pnl_ciudad.Visible = True
                Me.pnl_correo.Visible = True
                Me.pnl_cumpleanos.Visible = True
                Me.pnl_rfc.Visible = True
                Me.pnl_tarifa.Visible = True
                Me.pnl_telefono.Visible = True
                Me.pnl_agencia.Visible = False
                Me.pnl_guardar.Visible = True
                Me.pnl_compania.Visible = True
                If Request.QueryString("CompaniaId") <> "" Then
                    Me.ddl_compania.SelectedValue = Request.QueryString("CompaniaId")
                End If
                pnl_estado.Visible = True
                pnl_sivale.Visible = True
            Case 3
                Me.pnl_seleccionar.Visible = False
                If Request.QueryString("ContactoId") <> "" Then
                    Me.pnl_contacto.Visible = True
                    Me.ddl_contacto.SelectedValue = Request.QueryString("ContactoId")
                End If
                Me.pnl_nombre.Visible = True
                Me.pnl_amaterno.Visible = True
                Me.pnl_apaterno.Visible = True
                Me.pnl_ciudad.Visible = True
                Me.pnl_correo.Visible = True
                Me.pnl_cumpleanos.Visible = True
                Me.pnl_rfc.Visible = True
                Me.pnl_tarifa.Visible = False
                Me.pnl_telefono.Visible = True
                Me.pnl_agencia.Visible = True
                Me.pnl_guardar.Visible = True
                Me.pnl_compania.Visible = False
                pnl_estado.Visible = True
                pnl_sivale.Visible = True
        End Select


    End Sub

    Private Sub btn_guardar_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btn_guardar.Click
        Dim s As Socio = oSocio
        Dim sesion As ISession = Nothing
        checar_repetido()
        Me.pnl_resultado.Visible = True

        Try
            sesion = NHelper.GetCurrentSession()
            sesion.BeginTransaction()
            s.Nombre = tb_nombre.Text
            s.Paterno = tb_apaterno.Text
            s.Materno = tb_amaterno.Text
            s.RFC = tb_rfc.Text
            s.Telefono = tb_telefono.Text
            s.Club = club.SelectedIndex
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
            s.CtaFacebook = tb_facebook.Text
            s.CtaTwitter = tb_twitter.Text
            s.Gustos = tb_gustos.Text
            s.Sexo = ddl_sexo.SelectedValue
            s.EdoCivil = ddl_estado_civil.SelectedValue
            sesion.Save(s)
            sesion.Transaction.Commit()
            NHelper.CloseSession()
            If club.SelectedIndex = 3 OrElse 2 Then
                's.Agencia = tb_agencia.Text
            End If

            lbl_resultado.ForeColor = Drawing.Color.Green
            lbl_resultado.Text = "Numero de Socio: " & s.NoSocio
            btn_guardar.Enabled = False
        Catch ex As Exception
            If sesion.Transaction.IsActive Then
                sesion.Transaction.Rollback()
                sesion.Close()
            End If

            lbl_resultado.ForeColor = Drawing.Color.Red
            lbl_resultado.Text = "Ocurrio un error al guardar la información: " & ex.Message
        End Try

    End Sub

    Protected Sub ddl_estado_SelectedIndexChanged(sender As Object, e As EventArgs) Handles ddl_estado.SelectedIndexChanged
        If ddl_estado.SelectedIndex > 0 Then
            Dim id As Long = ddl_estado.SelectedValue
            Dim s As ISession = NHelper.GetCurrentSession()
            Dim ciudad As IList = _
                s.CreateQuery("From Ciudad c where c.Estado.Id = ?").SetInt64(0, id).List()
            ddl_ciudad.DataSource = ciudad
            ddl_ciudad.DataTextField = "Nombre"
            ddl_ciudad.DataValueField = "Id"
            ddl_ciudad.DataBind()
            NHelper.CloseSession()
        Else
            ddl_ciudad.Items.Clear()
        End If
    End Sub
    Private Sub checar_repetido()
        Dim s As ISession = Nothing
        Try
            Dim qry As String = _
                "From Socio s where s.Nombre like ? and s.Paterno like ? and s.Materno like ? " & _
                "Order by s.Paterno"
           
        Catch ex As Exception

        End Try
    End Sub
End Class