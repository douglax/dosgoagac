Imports CeeLib
Imports NHibernate

Public Class Alta
    Inherits System.Web.UI.Page

    Private oSocio As New Socio

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Dim s As ISession = NHelper.GetCurrentSession
        Dim comps As IList(Of CeeLib.Compania) = s.CreateQuery("from Compania").List(Of CeeLib.Compania)()
        s.Close()
        If Not comps Is Nothing Then
            ddl_compania.DataSource = comps
            ddl_compania.DataValueField = "Id"
            ddl_compania.DataTextField = "Nombre"
            ddl_compania.DataBind()
        End If
        If Not Me.IsPostBack Then
            For i As Integer = Now.Year To Now.Year - 100 Step -1
                Dim anoStr = New ListItem
                anoStr.Text = i.ToString
                anoStr.Value = i.ToString
                Me.ddl_cump_ano.Items.Add(anoStr)
            Next

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

        Select Case Me.club.SelectedItem.Value
            Case 0
                Me.pnl_seleccionar.Visible = True
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
            Case 1
                Me.pnl_seleccionar.Visible = False
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
            Case 2
                Me.pnl_seleccionar.Visible = False
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
            Case 3
                Me.pnl_seleccionar.Visible = False
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
        End Select


    End Sub

    Private Sub btn_guardar_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btn_guardar.Click
        Dim s As Socio = oSocio
        Dim sesion As ISession = Nothing
        Try
            s.Nombre = tb_nombre.Text
            s.Paterno = tb_apaterno.Text
            s.Materno = tb_amaterno.Text
            s.RFC = tb_rfc.Text
            s.Telefono = tb_telefono.Text
            Dim dia As Integer = CInt(ddl_cump_dia.SelectedValue)
            Dim mes As Integer = CInt(ddl_cump_mes.SelectedValue)
            Dim anio As Integer = CInt(ddl_cump_ano.SelectedValue)
            s.FechaDeNacimiento = New Date(anio, mes, dia)
            s.Ciudad = tb_ciudad.Text
            s.Email = tb_correo.Text
            If tb_tarifa.Text.Length > 0 Then
                If IsNumeric(tb_tarifa.Text) Then
                    s.Tarifa = CDbl(tb_tarifa.Text)
                End If
            End If
            If club.SelectedIndex = 1 OrElse 2 Then
                Dim comp As New CeeLib.Compania
                comp.Id = ddl_compania.SelectedValue
                comp.Contactos.Add(s)
                s.Compania = comp
            End If
            sesion = NHelper.GetCurrentSession()
            sesion.BeginTransaction()
            s = sesion.Merge(s)
            sesion.Transaction.Commit()
            sesion.Close()
            If club.SelectedIndex = 3 OrElse 2 Then
                's.Agencia = tb_agencia.Text
            End If
            Lbl_Resultado.ForeColor = Drawing.Color.Green
            Lbl_Resultado.Text = "Numero de Socio: " & s.NoSocio
            btn_guardar.Enabled = False
        Catch ex As Exception
            If sesion.Transaction.IsActive Then
                sesion.Transaction.Rollback()
                sesion.Close()
            End If
            Lbl_Resultado.ForeColor = Drawing.Color.Red
            Lbl_Resultado.Text = "Ocurrio un error al guardar la información: " & ex.Message
        End Try

    End Sub
End Class