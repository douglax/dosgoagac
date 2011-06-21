Public Class Usuario

    Private _Usr As String
    Public Overridable Property Usr() As String
        Get
            Return _Usr
        End Get
        Set(ByVal value As String)
            _Usr = value
        End Set
    End Property

    Private _Passwd As String
    Public Overridable Property Passwd() As String
        Get
            Return _Passwd
        End Get
        Set(ByVal value As String)
            _Passwd = value
        End Set
    End Property

End Class
