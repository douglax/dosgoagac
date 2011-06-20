Imports CeeLib

Public Class Socio

    Private _NoSocio As Long
    Public Property NoSocio() As Long
        Get
            Return _NoSocio
        End Get
        Set(ByVal value As Long)
            _NoSocio = value
        End Set
    End Property

    Private _Nombre As String
    Public Property Nombre() As String
        Get
            Return _Nombre
        End Get
        Set(ByVal value As String)
            _Nombre = value
        End Set
    End Property

    Private _Paterno As String
    Public Property Paterno() As String
        Get
            Return _Paterno
        End Get
        Set(ByVal value As String)
            _Paterno = value
        End Set
    End Property

    Private _Materno As String
    Public Property Materno() As String
        Get
            Return _Materno
        End Get
        Set(ByVal value As String)
            _Materno = value
        End Set
    End Property

    Private _Compania As Compania
    Public Property Compania() As Compania
        Get
            Return _Compania
        End Get
        Set(ByVal value As Compania)
            _Compania = value
        End Set
    End Property

    Private _Email As String
    Public Property Email() As String
        Get
            Return _Email
        End Get
        Set(ByVal value As String)
            _Email = value
        End Set
    End Property

    Private _Telefono As String
    Public Property Telefono() As String
        Get
            Return _Telefono
        End Get
        Set(ByVal value As String)
            _Telefono = value
        End Set
    End Property

    Private _RFC As String
    Public Property RFC() As String
        Get
            Return _RFC
        End Get
        Set(ByVal value As String)
            _RFC = value
        End Set
    End Property

    Private _FechaDeNacimiento As Date
    Public Property FechaDeNacimiento() As Date
        Get
            Return _FechaDeNacimiento
        End Get
        Set(ByVal value As Date)
            _FechaDeNacimiento = value
        End Set
    End Property

    Private _Ciudad As String
    Public Property Ciudad() As String
        Get
            Return _Ciudad
        End Get
        Set(ByVal value As String)
            _Ciudad = value
        End Set
    End Property

    Private _Agencia As Agencia
    Public Property Agencia() As Agencia
        Get
            Return _Agencia
        End Get
        Set(ByVal value As Agencia)
            _Agencia = value
        End Set
    End Property

    Private _CuartosNoche As IList
    Public Property CuartosNoche() As IList
        Get
            If _CuartosNoche Is Nothing Then
                _CuartosNoche = New ArrayList()
            End If
            Return _CuartosNoche
        End Get
        Set(ByVal value As IList)
            _CuartosNoche = value
        End Set
    End Property

    Private _Tarifa As Double
    Public Property Tarifa() As Double
        Get
            Return _Tarifa
        End Get
        Set(ByVal value As Double)
            _Tarifa = value
        End Set
    End Property


    Public ReadOnly Property Edad As Integer
        Get
            Dim meses As Integer
            Dim iYears As Integer
            Dim dYears As Decimal
            Dim lDayOfBirth As Long
            Dim lAsOf As Long
            Dim iBirthMonth As Integer
            Dim iAsOFMonth As Integer
            Dim AsOf As Date

            AsOf = DateTime.Now

            lDayOfBirth = DatePart(DateInterval.Day, _FechaDeNacimiento)
            lAsOf = DatePart(DateInterval.Day, AsOf)

            iBirthMonth = DatePart(DateInterval.Month, _FechaDeNacimiento)
            iAsOFMonth = DatePart(DateInterval.Month, AsOf)

            meses = DateDiff(DateInterval.Month, _FechaDeNacimiento, AsOf)

            dYears = meses / 12

            iYears = Math.Floor(dYears)

            If iBirthMonth = iAsOFMonth Then
                If lAsOf < lDayOfBirth Then
                    iYears = iYears - 1
                End If
            End If

            Return iYears
        End Get
    End Property

    Public Overrides Function Equals(obj As Object) As Boolean
        Try
            Dim o = DirectCast(obj, Socio)
            Return (o._Nombre = Me._NoSocio)
        Catch
            Return False
        End Try
    End Function

    Public Overrides Function GetHashCode() As Integer
        Return _NoSocio.GetHashCode()
    End Function


End Class
