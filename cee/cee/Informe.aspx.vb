Public Class Informe
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Dim administrador As Boolean
        administrador = True
        If administrador Then
            Me.menu_item_admin.Visible = True
            Me.menu_items.Attributes.Add("class", "menu-bg-administracion")
        End If

        If Not Me.IsPostBack Then

            Dim ddlItem0 = New ListItem
            ddlItem0.Text = "Seleccionar..."
            ddlItem0.Value = "0"
            Me.club.Items.Add(ddlItem0)
            Me.ddl_tipo.Items.Add(ddlItem0)

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

            Dim ddlItemTipo1 = New ListItem
            ddlItemTipo1.Text = "Carga de Saldos"
            ddlItemTipo1.Value = "1"
            Me.ddl_tipo.Items.Add(ddlItemTipo1)

            Dim ddlItemTipo2 = New ListItem
            ddlItemTipo2.Text = "Puntos"
            ddlItemTipo2.Value = "2"
            Me.ddl_tipo.Items.Add(ddlItemTipo2)

        End If

    End Sub

    Protected Sub btn_periodo_inicio_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_periodo_inicio.Click
        Me.cld_bg_inicio.Visible = True
        Me.cld_bg_final.Visible = False
    End Sub

    Protected Sub btn_peridodo_final_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_peridodo_final.Click
        Me.cld_bg_inicio.Visible = False
        Me.cld_bg_final.Visible = True
    End Sub

    Protected Sub cld_selector_inicio_SelectionChanged(ByVal sender As Object, ByVal e As EventArgs) Handles cld_selector_inicio.SelectionChanged
        Me.cld_bg_inicio.Visible = False
        Me.cld_bg_final.Visible = False
        Me.tb_periodo_inicio.Text = cld_selector_inicio.SelectedDate
    End Sub

    Protected Sub cld_selector_final_SelectionChanged(ByVal sender As Object, ByVal e As EventArgs) Handles cld_selector_final.SelectionChanged
        Me.cld_bg_inicio.Visible = False
        Me.cld_bg_final.Visible = False
        Me.tb_periodo_final.Text = cld_selector_final.SelectedDate
    End Sub

End Class