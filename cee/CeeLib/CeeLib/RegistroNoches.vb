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

    Private _Hotel As Hotel
    Public Overridable Property Hotel() As Hotel
        Get
            Return _Hotel
        End Get
        Set(ByVal value As Hotel)
            _Hotel = value
        End Set
    End Property

    Private _Tarifa As Double
    Public Overridable Property Tarifa() As Double
        Get
            Return _Tarifa
        End Get
        Set(ByVal value As Double)
            _Tarifa = value
        End Set
    End Property

    Public Overridable ReadOnly Property Compania() As String
        Get
            Return _Socio.Compania.Nombre
        End Get
    End Property

    Public Overridable ReadOnly Property NombreCompleto() As String
        Get
            Return _Socio.NombreCompleto
        End Get
    End Property

    Public Overridable ReadOnly Property CtaSiVale() As String
        Get
            Return _Socio.CtaSiVale
        End Get
    End Property

    Public Overridable ReadOnly Property Total() As Double
        Get
            Return Tarifa * Cantidad
        End Get
    End Property

    Public Overrides Function Equals(ByVal obj As Object) As Boolean
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
