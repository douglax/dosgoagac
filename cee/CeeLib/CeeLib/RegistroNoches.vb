Public Class RegistroNoches

    Private _Id As Long
    Public Overridable Property Id() As Long
        Get
            Return _Id
        End Get
        Set(ByVal value As Long)
            _Id = value
        End Set
    End Property

    Private _Tipo As Integer
    Public Overridable Property Tipo() As Integer
        Get
            Return _Tipo
        End Get
        Set(ByVal value As Integer)
            _Tipo = value
        End Set
    End Property

    Private _Cantidad As Double
    Public Overridable Property Cantidad() As Double
        Get
            Return _Cantidad
        End Get
        Set(ByVal value As Double)
            _Cantidad = value
        End Set
    End Property

    Private _FechaAlta As Date
    Public Overridable Property FechaAlta() As Date
        Get
            Return _FechaAlta
        End Get
        Set(ByVal value As Date)
            _FechaAlta = value
        End Set
    End Property

    Private _Serie As Integer
    Public Overridable Property Serie() As Integer
        Get
            Return _Serie
        End Get
        Set(ByVal value As Integer)
            _Serie = value
        End Set
    End Property

    Private _Socio As Socio
    Public Overridable Property Socio() As Socio
        Get
            Return _Socio
        End Get
        Set(ByVal value As Socio)
            _Socio = value
        End Set
    End Property

    Public Overrides Function Equals(obj As Object) As Boolean
        Try
            Dim o = DirectCast(obj, RegistroNoches)
            Return (o.Id = Me._Id)
        Catch
            Return False
        End Try
    End Function

    Public Overrides Function GetHashCode() As Integer
        Return _Id.GetHashCode()
    End Function


End Class
