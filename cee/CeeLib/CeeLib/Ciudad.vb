﻿Public Class Ciudad

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

    Private _Estado As Estado
    Public Overridable Property Estado() As Estado
        Get
            Return _Estado
        End Get
        Set(ByVal value As Estado)
            _Estado = value
        End Set
    End Property
End Class
