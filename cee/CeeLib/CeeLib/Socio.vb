Imports CeeLib

Public Class Socio

    Private _NoSocio As Long
    Public Overridable Property NoSocio() As Long
        Get
            Return _NoSocio
        End Get
        Set(ByVal value As Long)
            _NoSocio = value
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

    Private _Paterno As String
    Public Overridable Property Paterno() As String
        Get
            Return _Paterno
        End Get
        Set(ByVal value As String)
            _Paterno = value
        End Set
    End Property

    Private _Materno As String
    Public Overridable Property Materno() As String
        Get
            Return _Materno
        End Get
        Set(ByVal value As String)
            _Materno = value
        End Set
    End Property

    Private _Compania As Compania
    Public Overridable Property Compania() As Compania
        Get
            Return _Compania
        End Get
        Set(ByVal value As Compania)
            _Compania = value
        End Set
    End Property

    Private _Email As String
    Public Overridable Property Email() As String
        Get
            Return _Email
        End Get
        Set(ByVal value As String)
            _Email = value
        End Set
    End Property

    Private _Telefono As String
    Public Overridable Property Telefono() As String
        Get
            Return _Telefono
        End Get
        Set(ByVal value As String)
            _Telefono = value
        End Set
    End Property

    Private _RFC As String
    Public Overridable Property RFC() As String
        Get
            Return _RFC
        End Get
        Set(ByVal value As String)
            _RFC = value
        End Set
    End Property

    Private _FechaDeNacimiento As Date
    Public Overridable Property FechaDeNacimiento() As Date
        Get
            Return _FechaDeNacimiento
        End Get
        Set(ByVal value As Date)
            _FechaDeNacimiento = value
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

    Private _Agencia As Agencia
    Public Overridable Property Agencia() As Agencia
        Get
            Return _Agencia
        End Get
        Set(ByVal value As Agencia)
            _Agencia = value
        End Set
    End Property

    Private _CuartosNoche As IList
    Public Overridable Property CuartosNoche() As IList
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
    Public Overridable Property Tarifa() As Double
        Get
            Return _Tarifa
        End Get
        Set(ByVal value As Double)
            _Tarifa = value
        End Set
    End Property

    Private _Club As Integer
    Public Overridable Property Club() As Integer
        Get
            Return _Club
        End Get
        Set(ByVal value As Integer)
            _Club = value
        End Set
    End Property

    Private _CtaSiVale As String
    Public Overridable Property CtaSiVale() As String
        Get
            Return _CtaSiVale
        End Get
        Set(ByVal value As String)
            _CtaSiVale = value
        End Set
    End Property

    Private _CtaFacebook As String
    Public Overridable Property CtaFacebook() As String
        Get
            Return _CtaFacebook
        End Get
        Set(ByVal value As String)
            _CtaFacebook = value
        End Set
    End Property

    Private _CtaTwitter As String
    Public Overridable Property CtaTwitter() As String
        Get
            Return _CtaTwitter
        End Get
        Set(ByVal value As String)
            _CtaTwitter = value
        End Set
    End Property

    Private _Sexo As String
    Public Overridable Property Sexo() As String
        Get
            Return _Sexo
        End Get
        Set(ByVal value As String)
            _Sexo = value
        End Set
    End Property

    Private _EdoCivil As String
    Public Overridable Property EdoCivil() As String
        Get
            Return _EdoCivil
        End Get
        Set(ByVal value As String)
            _EdoCivil = value
        End Set
    End Property

    Private _Gustos As String
    Public Overridable Property Gustos() As String
        Get
            Return _Gustos
        End Get
        Set(ByVal value As String)
            _Gustos = value
        End Set
    End Property

    Public Overridable Function Edad() As Integer
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

    End Function

    Public Overridable ReadOnly Property NombreCompleto()
        Get
            Return _Nombre & " " & _Paterno & " " & _Materno
        End Get
    End Property

    Public Overridable Function TipoDeSocio() As String
        Dim tipo As String = ""

        Select Case _Club
            Case 2
                If TotalPuntos() >= 50 And TotalPuntos() <= 150 Then
                    tipo = "Enlace Oro: Bonificación del 5%"
                ElseIf TotalPuntos() >= 151 And TotalPuntos() <= 300 Then
                    tipo = "Enlace Platino: Bonificación del 7%"
                ElseIf TotalPuntos() >= 301 Then
                    tipo = "Enlace Premium: Bonificación del 10%"
                End If
            Case 1
                If TotalPuntos() >= 60 And TotalPuntos() <= 299 Then
                    tipo = "Socio Clásico"
                ElseIf TotalPuntos() >= 300 And TotalPuntos() <= 599 Then
                    tipo = "Socio Oro"
                ElseIf TotalPuntos() >= 600 Then
                    tipo = "Socio Diamante"
                End If
            Case 3
                Dim money As Double = TotalPuntos() * 10
                tipo = "Bonificacìón de " & FormatCurrency(money)
        End Select
        Return tipo
    End Function

    Public Overridable Function TotalPuntos() As Integer
        Dim total As Integer = 0
        For Each cn As RegistroNoches In _CuartosNoche
            total += cn.Cantidad
        Next
        Return total
    End Function

    Public Overridable ReadOnly Property ClubDesc As String
        Get
            Dim clb As String = ""
            Select Case _Club
                Case 1
                    clb = "Enlace Club"
                Case 2
                    clb = "Club Enlace Empresarial"
                Case 3
                    clb = "Enlace Travel Club"
            End Select

            Return clb

        End Get
    End Property

    Public Overrides Function Equals(ByVal obj As Object) As Boolean
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
