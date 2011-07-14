Imports Microsoft.VisualBasic
Imports NHibernate
Imports NHibernate.Cfg
Imports System.Reflection

Public Class NHelper
    Private Shared CurrentSessionKey As String = "nhibernate.current_session"
    Private Shared _SessionFactory As ISessionFactory
    Private Shared _UserName As String

    Shared Sub New()
        Dim cf As Configuration = New Configuration()
        cf.AddClass(GetType(CeeLib.Usuario))
        cf.AddClass(GetType(CeeLib.Socio))
        cf.AddClass(GetType(CeeLib.Compania))
        cf.AddClass(GetType(CeeLib.RegistroNoches))
        cf.AddClass(GetType(CeeLib.Hotel))
        _SessionFactory = cf.Configure.BuildSessionFactory
    End Sub


    Private Shared ReadOnly Property SessionFactory() As ISessionFactory
        Get
            Return _SessionFactory
        End Get
    End Property

    Public Shared Property UserName() As String
        Get
            Return _UserName
        End Get
        Set(ByVal value As String)
            _UserName = value
        End Set
    End Property


    Public Shared Function GetCurrentSession() As ISession
        Dim context As HttpContext = HttpContext.Current
        Dim currentSession As ISession = CType(context.Items(CurrentSessionKey), ISession)

        If currentSession Is Nothing Then
            currentSession = _SessionFactory.OpenSession
            context.Items(CurrentSessionKey) = currentSession
        End If

        Return currentSession

    End Function

    Public Shared Sub CloseSession()

        Dim context As HttpContext = HttpContext.Current
        Dim currentSession As ISession = CType(context.Items(CurrentSessionKey), ISession)

        If currentSession Is Nothing Then
            Return
        End If
        currentSession.Close()
        context.Items.Remove(CurrentSessionKey)


    End Sub

    Public Shared Sub CloseSessionFactory()
        If Not _SessionFactory Is Nothing Then
            _SessionFactory.Close()
        End If
    End Sub



End Class

