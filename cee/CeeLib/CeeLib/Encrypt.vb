Imports System.Security.Cryptography
Imports System.IO
Public Class Encrypt

    Private Shared key As Byte() = {22, 34, 154, 233, 84, 7, 1, 240, 8, 63, 17, 21, 74, 156, 147, 47, 23, 14, 5, 78, 7, 29, 39, 97}
    Private Shared iv As Byte() = {87, 63, 124, 77, 2, 250, 67, 22}

    Public Shared Function Encriptar(ByVal txt As String) As String
        Dim encoding As New Text.UTF8Encoding
        Dim InputBytes As Byte() = encoding.GetBytes(txt)
        Dim tdes As New TripleDESCryptoServiceProvider
        Dim crypto As ICryptoTransform = tdes.CreateEncryptor(key, iv)
        Dim stream As New MemoryStream
        Dim cryptoStream As CryptoStream = New CryptoStream(stream, crypto, CryptoStreamMode.Write)
        cryptoStream.Write(InputBytes, 0, InputBytes.Length)
        cryptoStream.FlushFinalBlock()
        stream.Position = 0
        Dim resultado(stream.Length - 1) As Byte
        stream.Read(resultado, 0, stream.Length)
        cryptoStream.Close()
        stream.Close()
        Return Convert.ToBase64String(resultado)

    End Function


    Public Shared Function Desencriptar(ByVal encString As String) As String
        If encString Is Nothing Then Return 0.0
        Try
            Dim InputBytes As Byte() = Convert.FromBase64String(encString)
            Dim tdes As New TripleDESCryptoServiceProvider
            Dim crypto As ICryptoTransform = tdes.CreateDecryptor(key, iv)
            Dim stream As New MemoryStream
            Dim cryptoStream As CryptoStream = New CryptoStream(stream, crypto, CryptoStreamMode.Write)
            cryptoStream.Write(InputBytes, 0, InputBytes.Length)
            cryptoStream.FlushFinalBlock()
            stream.Position = 0
            Dim resultado(stream.Length - 1) As Byte
            stream.Read(resultado, 0, stream.Length)
            cryptoStream.Close()
            stream.Close()
            Dim encoding As New Text.UTF8Encoding()
            Return encoding.GetString(resultado)
        Catch
            Return 0.0
        End Try
    End Function
End Class
