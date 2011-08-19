Public Class Compania

    Private _Id As Long
    Public Overridable Property Id() As Long
        Get
            Return _Id
        End Get
        Set(ByVal value As Long)
            _Id = value
        End Set
    End Property

    Private _Nombre As String
    Public Overridable Property Nombre() As String
        Get
            Return _Nombre
        End Get
        Set(ByVal value As String)
            _Nombre = value
        End Set
    End Property

    Private _Direccion As String
    Public Overridable Property Direccion() As String
        Get
            Return _Direccion
        End Get
        Set(ByVal value As String)
            _Direccion = value
        End Set
    End Property

    Private _Ciudad As Ciudad
    Public Overridable Property Ciudad() As Ciudad
        Get
            Return _Ciudad
        End Get
        Set(ByVal value As Ciudad)
            _Ciudad = value
        End Set
    End Property

    Private _Contactos As IList
    Public Overridable Property Contactos() As IList
        Get
            If _Contactos Is Nothing Then
                _Contactos = New ArrayList()
            End If
            Return _Contactos
        End Get
        Set(ByVal value As IList)
            _Contactos = value
        End Set
    End Property

    Private _EsAgencia As Boolean
    Public Overridable Property EsAgencia() As Boolean
        Get
            Return _EsAgencia
        End Get
        Set(ByVal value As Boolean)
            _EsAgencia = value
        End Set
    End Property

    Public Overrides Function Equals(obj As Object) As Boolean
        Try
            Dim o = DirectCast(obj, Compania)
            Return (o.Id = Me._Id)
        Catch
            Return False
        End Try
    End Function

    Public Overrides Function GetHashCode() As Integer
        Return _Id.GetHashCode()
    End Function

    Public Overridable Function CalcularPuntos() As Integer
        Dim tot As Integer = 0
        For Each s As CeeLib.Socio In _Contactos
            If s.Club = 2 Then tot += s.TotalPuntos
        Next
        Return tot
    End Function

    Public Overridable Function CalcularTipoCompania() As String
        Dim tipo As String = ""
        If CalcularPuntos() >= 50 And CalcularPuntos() <= 150 Then
            tipo = "Enlace Premium: Bonificación del 5%"
        ElseIf CalcularPuntos() >= 151 And CalcularPuntos() <= 300 Then
            tipo = "Enlace Platino: Bonificación del 7%"
        ElseIf CalcularPuntos() >= 301 Then
            tipo = "Enlace Oro: Bonificación del 10%"
        End If
        Return tipo
    End Function

End Class

