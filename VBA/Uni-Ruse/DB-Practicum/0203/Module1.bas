Option Compare Database

Public Sub Create_spec()
    Dim SQL As String
    
    SQL = "CREATE TABLE Spec (CodSp byte primary key, ImeSp text(12) not null)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Spec VALUES (1, 'Informatics')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Spec VALUES (2, 'POMI')"
    DoCmd.RunSQL SQL
End Sub

Public Sub StNum()
    Dim Number As Integer, Rank As Integer, Result As Integer
    
    Number = InputBox("Enter number")
    Rank = InputBox("Enter rank (>= 0)")
    
    If Rank < 0 Then
        MsgBox ("Rank is less than 0. Try again!")
        Exit Sub
    End If
    
    Result = RaiseToPower(Number, Rank)
    MsgBox ("The result is " & Result)
End Sub

'Raise a number to the power of Rank
Function RaiseToPower(Number As Integer, Rank As Integer) As Integer
    Dim Result As Integer
    Dim i As Integer
    Result = 1
    If Rank = 0 Then
        RaiseToPower = 1
    Else
        For i = 1 To Rank
            Result = Result * Number
        Next i
        RaiseToPower = Result ' returns Number, raised to the power of Rank
    End If
End Function
