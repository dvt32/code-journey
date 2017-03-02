Option Compare Database

Sub MyFormProperty()
    Me!ImeSp.Width = 2000
    Me!ImeSp.Height = 500
    Me!CodSp_Label.Caption = "Specialty ID"
    Me!ImeSp_Label.Caption = "Specialty Name"
    Me.ImeSp_Label.FontName = "Ariel"
    Me.Caption = "List of specialties"
End Sub

Private Sub Form_Load()
    MyFormProperty
End Sub
