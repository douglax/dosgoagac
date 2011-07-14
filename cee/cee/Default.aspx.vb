Public Class _Default
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        Dim administrador As Boolean
        administrador = True
        If administrador Then
            Me.menu_item_admin.Visible = True
            Me.menu_items.Attributes.Add("class", "menu-bg-administracion")
        End If

    End Sub

End Class