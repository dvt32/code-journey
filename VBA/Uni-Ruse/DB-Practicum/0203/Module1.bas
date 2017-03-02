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
