Imports CeeLib
Imports NHibernate

Public Class Cambio
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Protected Sub btn_modificar_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_modificar.Click

    End Sub

    Protected Sub btn_consultar_popup_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btn_consultar_popup.Click
        Me.grp_consultar.Visible = False
        Me.grp_busqueda.Visible = True
    End Sub
End Class