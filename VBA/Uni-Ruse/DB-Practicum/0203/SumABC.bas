Option Compare Database

Sub SumABC()
    Dim a, b, c, Sum, Product As Single
    Dim msg As String
    msg = "Module for addition and multiplication of a, b, c"
    a = InputBox("Enter value for 'a'", msg)
    b = InputBox("Enter value for 'b'", msg)
    c = InputBox("Enter value for 'c'", msg)
    
    ' Sum - sum of a, b, c
    Sum = Val(a) + Val(b) + Val(c)
    MsgBox "Sum of a, b, c = " & Sum
    
    ' Product - product of a, b, c
    Product = a * b * c
    MsgBox "The product of a,b,c = " & Product
End Sub
