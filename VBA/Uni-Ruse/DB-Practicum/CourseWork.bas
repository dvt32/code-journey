Option Compare Database

Option Explicit

'General Subs BEGIN
Sub CreateTablesAndRelations()
    Dim db As Database
    Dim tblNew As TableDef
    Dim fldNew As Field
    Dim idxNew As Index
    Dim rel As Relation

    'Create table "Movie"
    Set db = CurrentDb
    Set tblNew = db.CreateTableDef("Movie")
    
    Set fldNew = tblNew.CreateField("MovieID", dbInteger)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("MovieName", dbText, 100)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Topic", dbText, 100)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Category", dbText, 255)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Scriptwriter", dbText, 50)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Director", dbText, 50)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Composer", dbText, 50)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Propagator", dbText, 100)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Duration", dbInteger)
    tblNew.Fields.Append fldNew

    db.TableDefs.Append tblNew
    MsgBox "Table 'Movie' created"
    With tblNew
        Set idxNew = .CreateIndex("MovieID")
        idxNew.Fields.Append idxNew.CreateField("MovieID")
        idxNew.Primary = True
        .Indexes.Append idxNew
    End With

    'Create table "MovieTheatre"
    Set tblNew = db.CreateTableDef("MovieTheatre")
    
    Set fldNew = tblNew.CreateField("TheatreID", dbInteger)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("TheatreName", dbText, 20)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Address", dbText, 255)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Category", dbText, 100)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Director", dbText, 150)
    tblNew.Fields.Append fldNew
    
    db.TableDefs.Append tblNew
    MsgBox "Table 'MovieTheatre' created"
    With tblNew
        Set idxNew = .CreateIndex("TheatreID")
        idxNew.Fields.Append idxNew.CreateField("TheatreID")
        idxNew.Primary = True
        .Indexes.Append idxNew
    End With
    
    'Create table "MoviePlay"
    Set tblNew = db.CreateTableDef("MoviePlay")
    
    Set fldNew = tblNew.CreateField("TheatreID", dbInteger)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("MovieID", dbInteger)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("Duration", dbInteger)
    tblNew.Fields.Append fldNew
    Set fldNew = tblNew.CreateField("SinglePrice", dbCurrency)
    tblNew.Fields.Append fldNew
    
    db.TableDefs.Append tblNew
    MsgBox "Table 'MoviePlay' created"
    With tblNew
        Set idxNew = .CreateIndex("MoviePlayID")
        idxNew.Fields.Append idxNew.CreateField("TheatreID")
        idxNew.Fields.Append idxNew.CreateField("MovieID")
        idxNew.Primary = True
        .Indexes.Append idxNew
    End With
    
    'Create relation MoviePlay-Movie
    Set rel = db.CreateRelation("MoviePlayMovie", "Movie", "MoviePlay")
    rel.Attributes = dbRelationUpdateCascade
    Set fldNew = rel.CreateField("MovieID")
    fldNew.ForeignName = "MovieID"
    rel.Fields.Append fldNew
    db.Relations.Append rel
    
    'Create relation MoviePlay-MovieTheatre
    Set rel = db.CreateRelation("MoviePlayMovieTheatre", "MovieTheatre", "MoviePlay")
    rel.Attributes = dbRelationUpdateCascade
    Set fldNew = rel.CreateField("TheatreID")
    fldNew.ForeignName = "TheatreID"
    rel.Fields.Append fldNew
    db.Relations.Append rel
End Sub

Sub InsertValuesIntoMovieTable()
    Dim SQL As String
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(1, 'The Shawshank Redemption', 'Human spirit', 'Drama', 'Stephen King', 'Frank Darabont', 'Jack Lawrence', 'A24 Films', 160)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(2, 'The Godfather', 'Crime', 'Drama', 'Mario Puzo', 'Francis Ford Coppola', 'Nino Rota', 'Columbia Pictures', 100)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(3, 'Office Space', 'Work life', 'Comedy', 'Mike Judge', 'Mike Judge', 'Steve Balbi', 'Brain Damage Films', 90)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(4, 'The Dark Knight', 'Good vs Evil', 'Action', 'Jonathan Nolan', 'Christopher Nolan', 'Franz Schubert', 'CBS Films', 90)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(5, 'Schindler''s List', 'Holocaust', 'Drama', 'Thomas Keneally', 'Steven Spielberg', 'Oskar Schima', 'Columbia Pictures', 110)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(6, 'Pulp Fiction', 'Fun & violence', 'Crime', 'Quentin Tarantino', 'Quentin Tarantino', 'Ole Georg', 'CBS Films', 100)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(7, '12 Angry Men', 'Finding the truth', 'Crime', 'Reginald Rose', 'Sidney Lumet', 'Marvin Hatley', 'Fox Film Corporation', 105)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(8, 'Clerks', 'Work life', 'Comedy', 'Kevin Smith', 'Kevin Smith', 'Steve Smyth', 'IFC Films', 115)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(9, 'Inception', 'Mind games', 'Mystery', 'Christopher Nolan', 'Christopher Nolan', 'Charles Dumont', 'Janus Films', 85)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(10, 'Fight Club', 'Social anarchy', 'Drama', 'Chuck Palahniuk', 'David Fincher', 'Guy Moon', 'Columbia Pictures', 115)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(11, 'Forrest Gump', 'Human spirit', 'Drama', 'Winston Groom', 'Robert Zemeckis', 'Allen Collins', 'CBS Films', 85)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(12, 'Goodfellas', 'Crime', 'Crime', 'Nicholas Pileggi', 'Martin Scorsese', 'Gino Paoli', 'Fox Film Corporation', 100)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(13, 'City of God', 'Ghetto life', 'Drama', 'Paulo Lins', 'Fernando Meirelles', 'Carl Douglas', 'A24 Films', 110)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(14, 'Life Is Beautiful', 'Holocaust', 'Drama', 'Vincenzo Cerami', 'Roberto Benigni', 'Jacques Offenbach', 'Brain Damage Films', 120)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(15, 'The Intouchables', 'Friendship', 'Drama', 'Eric Toledano', 'Olivier Nakache', 'Georg Philipp Telemann', 'KDK Factory', 110)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(16, 'Yes Man', 'Lifestyle change', 'Comedy', 'Nicholas Stoller', 'Peyton Reed', 'Mark Oliver Everett', 'Liberty Films', 120)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(17, 'Wayne''s World', 'Friendship', 'Comedy', 'Mike Myers', 'Penelope Spheeris', 'Jerry Williams', 'Fox Film Corporation', 105)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(18, 'Interstellar', 'Space travel', 'Adventure', 'Jonathan Nolan', 'Christopher Nolan', 'Dylan Thomas', 'A24 Films', 105)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(19, 'Reservoir Dogs', 'Failed robbery', 'Thriller', 'Quentin Tarantino', 'Quentin Tarantino', 'Gerry Rafferty', 'Magnolia Pictures', 115)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO Movie VALUES " _
        + "(20, 'Requiem for a Dream', 'Drugs', 'Drama', 'Hubert Selby Jr.', 'Darren Aronofsky', 'Marcel Reginatto', 'Milestone Films', 110)"
    DoCmd.RunSQL SQL
End Sub

Sub InsertValuesIntoMovieTheatreTable()
    Dim SQL As String
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(1, 'Alama Drafthouse Cinema', '613 Pearl Street Key West, FL 33040', 'First-Run', 'John Stanford')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(2, 'Bow Tie Cinema', '212 Dogwood Lane Asheville, NC 28803', 'Discount', 'Michael Scott')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(3, 'Caribbean Cinema', '473 6th Avenue Columbia, MD 21044', 'Arthouse', 'Adrian Favella')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(4, 'Cinemark Theatre', '896 Laurel Drive Oklahoma City, OK 73112', 'IMAX', 'Jack Thompson')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(5, 'BIG Cinema', '866 Adams Avenue North Kingstown, RI 02852', 'Discount', 'Tom Wilson')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(6, 'Dickinson Theatre', '642 Woodland Drive Palm Beach Gardens, FL 33410', 'First-Run', 'Marcus Halpert')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(7, 'Classic Cinema', '938 Vine Street Monroe Township, NJ 08831', 'Discount', 'Jessica Roberts')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(8, 'Carmike Cinema', '358 Hillside Avenue Northville, MI 48167', 'IMAX', 'Lisa Jackson')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(9, 'Grand Theater', '269 Cedar Court Key West, FL 33040', 'IMAX', 'Michael Richards')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(10, 'Reel Cinema', '475 Harrison Avenue Wenatchee, WA 98801', 'First-Run', 'Albert Dickinson')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(11, 'Santiko Theatre', '915 Cleveland Avenue Titusville, FL 32780', 'Arthouse', 'Richard Griffin')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(12, 'UltraStar Cinema', '124 Bridle Court Terre Haute, IN 47802', 'First-Run', 'Seth Hicks')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(13, 'Warren Theatre', '376 Monroe Drive Morristown, NJ 07960', 'Discount', 'George Constanza')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(14, 'Westgate Theatre', '1000 3rd Street West Hernando, MS 38632', 'IMAX', 'Melissa Johnson')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(15, 'Rio Entertainment Inc.', '672 Cambridge Drive Lake Worth, FL 33460', 'IMAX', 'Nigel Uno')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(16, 'Premiere Cinema', '387 Crescent Street Palm Harbor, FL 34683', 'IMAX', 'Robert Wilson')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(17, 'Picture Show Entertainment', '569 4th Street South Middle River, MD 21220', 'First-Run', 'Jason Bogart')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(18, 'Pacific Theatre', '356 Winding Way Chesapeake, VA 23320', 'Discount', 'Cleveland Brown')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(19, 'Cinema de Lux', '3 Sheffield Drive Hagerstown, MD 21740', 'Arthouse', 'Dwight Schrute')"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MovieTheatre VALUES " _
        + "(20, 'ArcLight Cinema', '654 North Avenue Solon, OH 44139', 'Arthouse', 'Andrew Bernard')"
    DoCmd.RunSQL SQL
End Sub

Sub InsertValuesIntoMoviePlayTable()
    Dim SQL As String
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(1, 3, 180, 15)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(2, 4, 120, 5)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(3, 5, 120, 8)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(4, 6, 110, 11)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(6, 7, 120, 9)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(7, 7, 120, 9)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(4, 7, 90, 10)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(5, 8, 120, 10)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(6, 1, 120, 11)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(7, 10, 90, 10)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(8, 11, 90, 12)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(6, 12, 120, 10)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(6, 13, 120, 8)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(5, 14, 100, 5)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(4, 14, 120, 10)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(3, 15, 100, 5)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(3, 16, 120, 9)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(12, 16, 120, 5)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(20, 16, 110, 11)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(19, 17, 120, 10)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(19, 18, 130, 11)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(19, 19, 100, 5)"
    DoCmd.RunSQL SQL
    
    SQL = "INSERT INTO MoviePlay VALUES " _
            + "(18, 20, 120, 10)"
    DoCmd.RunSQL SQL
End Sub

Sub DropAllTables()
    DoCmd.RunSQL "DROP TABLE MoviePlay;"
    DoCmd.RunSQL "DROP TABLE Movie;"
    DoCmd.RunSQL "DROP TABLE MovieTheatre;"
    
    MsgBox "Successfully deleted all tables."
End Sub

Sub DeleteValuesFromMovieTable()
    DoCmd.RunSQL "DELETE * FROM Movie;"
    MsgBox "Successfully deleted all values from Movie."
End Sub

Sub DeleteValuesFromMovieTheatreTable()
    DoCmd.RunSQL "DELETE * FROM MovieTheatre;"
    MsgBox "Successfully deleted all values from MovieTheatre."
End Sub

Sub DeleteValuesFromMoviePlayTable()
    DoCmd.RunSQL "DELETE * FROM MoviePlay;"
    MsgBox "Successfully deleted all values from MoviePlay."
End Sub
'General Subs END

'Queries BEGIN
Sub ExecuteQuery1()
    'Query 1 - Get name of movie theatre with minimum number of projected films
    Dim db As Database
    Dim qdf As QueryDef
    Dim qdf2 As QueryDef
    Dim strSQL_first As String
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL_first = "SELECT TheatreName, COUNT(MovieID) as movieCount FROM MovieTheatre, MoviePlay WHERE MovieTheatre.TheatreID = MoviePlay.TheatreID GROUP BY TheatreName"
    Set qdf = db.CreateQueryDef("Query1_first", strSQL_first)
    
    strSQL = "SELECT TheatreName, movieCount FROM Query1_first WHERE movieCount = (Select min(movieCount) From Query1_first)"
    Set qdf2 = db.CreateQueryDef("Query1_second", strSQL)
End Sub

Sub ExecuteQuery2()
    'Query 2 - Directors name with longest movie name
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT Movie.Director FROM Movie WHERE Len(MovieName) = (SELECT Max(Len(MovieName)) FROM Movie)"
    Set qdf = db.CreateQueryDef("Query2", strSQL)
End Sub

Sub ExecuteQuery3()
    'Query 3 - List of all movies that have duruation more than the average
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT MovieName, MoviePlay.Duration FROM Movie, MoviePlay WHERE Movie.MovieID = MoviePlay.MovieID AND MoviePlay.Duration > (SELECT Avg(MoviePlay.Duration) FROM MoviePlay)"
    Set qdf = db.CreateQueryDef("Query3", strSQL)
End Sub

Sub ExecuteQuery4()
    'Query 4 - List of movies with the shortest commercial duration and the theatre where they are showed
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT MovieName, TheatreName, MoviePlay.Duration - Movie.Duration AS [I?iaue?eoaeiino ia ?aeeaieoa] FROM Movie, MovieTheatre, MoviePlay WHERE Movie.MovieID = MoviePlay.MovieID AND MovieTheatre.TheatreID = MoviePlay.TheatreID AND MoviePlay.Duration-Movie.Duration = (SELECT Min(MoviePlay.Duration - Movie.Duration) FROM Movie, MoviePlay WHERE Movie.MovieID = MoviePlay.MovieID)"
    Set qdf = db.CreateQueryDef("Query4", strSQL)
End Sub

Sub ExecuteQuery5()
    'Query 5 - List of all movies with single price less then the average single price and the theather where they are projected, ordered by movie name
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT MovieName, TheatreName, SinglePrice FROM Movie, MovieTheatre, MoviePlay WHERE Movie.MovieID = MoviePlay.MovieID AND MovieTheatre.TheatreID = MoviePlay.TheatreID AND SinglePrice < (SELECT Avg(MoviePlay.SinglePrice) FROM MoviePlay) ORDER BY MovieName"
    Set qdf = db.CreateQueryDef("Query5", strSQL)
End Sub

Sub ExecuteQuery6()
    'Query 6 - List of movies that are never showed in any movie theatre
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT MovieName FROM Movie WHERE MovieID NOT IN (SELECT MovieID FROM MoviePlay)"
    Set qdf = db.CreateQueryDef("Query6", strSQL)
End Sub

Sub ExecuteQuery7()
    'Query 7 - Average commercial duration in specified movie theatre
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT TOP 1 Round(Avg(MoviePlay.Duration - Movie.Duration), 2) AS [Average commercial duration] FROM Movie, MovieTheatre, MoviePlay WHERE Movie.MovieID = MoviePlay.MovieID AND MovieTheatre.TheatreID = MoviePlay.TheatreID AND TheatreName = [Please enter theatre name]"
    Set qdf = db.CreateQueryDef("Query7", strSQL)
End Sub

Sub ExecuteQuery8()
    'Query 8 - All movies in the DB
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT * FROM Movie"
    Set qdf = db.CreateQueryDef("Query8", strSQL)
End Sub

Sub ExecuteQuery9()
    'Query 9 - All theatres in the DB
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT * FROM MovieTheatre"
    Set qdf = db.CreateQueryDef("Query9", strSQL)
End Sub

Sub ExecuteQuery10()
    'Query 10 - All film-shows in the DB
    Dim db As Database
    Dim qdf As QueryDef
    Dim strSQL As String
    Set db = CurrentDb
    
    strSQL = "SELECT * FROM MoviePlay"
    Set qdf = db.CreateQueryDef("Query10", strSQL)
End Sub
'Queries END

'Forms BEGIN
Sub CreateTablesForm()
    Dim frm As Form
    Dim NameForm As String
    Dim ComButton As Control
    
    Set frm = CreateForm
    With frm
        .Caption = "TablesForm"
        .NavigationButtons = False
        .ScrollBars = False
        .RecordSelectors = False
        .Width = 5500
        .MinMaxButtons = False
        .DividingLines = False
        .Section(acDetail).BackColor = 12908023
    End With
    
    NameForm = frm.Name
    
    'Movie button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 500)
    ComButton.Width = 2000
    ComButton.Caption = "Movie"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Movie_Form()"
    
    'MovieTheatre button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 1000)
    ComButton.Width = 2000
    ComButton.Caption = "MovieTheatre"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_MovieTheatre_Form()"
    
    'MoviePlay button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 1500)
    ComButton.Width = 2000
    ComButton.Caption = "MoviePlay"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_MoviePlay_Form()"
    
    'Exit button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 2000)
    ComButton.Width = 2000
    ComButton.Caption = "Exit"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Exit_Form()"
    
    DoCmd.Save
    DoCmd.Close
    DoCmd.Rename "TablesForm", acForm, NameForm
End Sub

Sub CreateQueriesForm()
    Dim frm As Form
    Dim NameForm As String
    Dim ComButton As Control
    
    Set frm = CreateForm
    With frm
        .Caption = "QueriesForm"
        .NavigationButtons = False
        .ScrollBars = False
        .RecordSelectors = False
        .Width = 5500
        .MinMaxButtons = False
        .DividingLines = False
        .Section(acDetail).BackColor = 12908023
    End With
    
    NameForm = frm.Name
    
    'Query 1 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 500)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 1"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query1_Form()"
    
    'Query 2 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 1000)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 2"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query2_Form()"
    
    'Query 3 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 1500)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 3"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query3_Form()"
    
    'Query 4 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 2000)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 4"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query4_Form()"
    
    'Query 5 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 2500)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 5"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query5_Form()"
    
    'Query 6 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 3000)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 6"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query6_Form()"
    
    'Query 7 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 3500)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 7"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query7_Form()"
    
    'Query 8 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 4000)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 8"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query8_Form()"
    
    'Query 9 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 4500)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 9"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query9_Form()"
    
    'Query 10 button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 5000)
    ComButton.Width = 2000
    ComButton.Caption = "Execute Query 10"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Query10_Form()"

    DoCmd.Save
    DoCmd.Close
    DoCmd.Rename "QueriesForm", acForm, NameForm
End Sub

Sub CreateMaintenanceForm()
    Dim frm As Form
    Dim NameForm As String
    Dim ComButton As Control
    
    Set frm = CreateForm
    With frm
        .Caption = "MaintenanceForm"
        .NavigationButtons = False
        .ScrollBars = False
        .RecordSelectors = False
        .Width = 5500
        .MinMaxButtons = False
        .DividingLines = False
        .Section(acDetail).BackColor = 12908023
    End With
    
    NameForm = frm.Name
    
    'Create Tables And Relations button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 500)
    ComButton.Name = "CreateTablesAndRelationsCommandButton"
    ComButton.Width = 3000
    ComButton.Caption = "Create Tables And Relations"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    
    'Drop All Tables button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 1000)
    ComButton.Name = "DropAllTablesCommandButton"
    ComButton.Width = 3000
    ComButton.Caption = "Drop All Tables"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    
    'Insert Values Into Tables button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 1500)
    ComButton.Name = "InsertValuesIntoTablesCommandButton"
    ComButton.Width = 3000
    ComButton.Caption = "Insert Values Into Tables"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    
    'Delete Values From Tables button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 2000)
    ComButton.Name = "DeleteValuesFromTablesCommandButton"
    ComButton.Width = 3000
    ComButton.Caption = "Delete Values From Tables"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    
    DoCmd.Save
    DoCmd.Close
    DoCmd.Rename "MaintenanceForm", acForm, NameForm
End Sub

Sub CreateMainForm()
    Dim frm As Form
    Dim NameForm As String
    Dim ComButton As Control
    
    Set frm = CreateForm
    With frm
        .Caption = "MainForm"
        .NavigationButtons = False
        .ScrollBars = False
        .RecordSelectors = False
        .Width = 5500
        .MinMaxButtons = False
        .DividingLines = False
        .Section(acDetail).BackColor = 12908023
    End With
    
    NameForm = frm.Name
    
    'Tables button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 500)
    ComButton.Width = 2000
    ComButton.Caption = "Tables"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Tables_Form()"
    
    'Queries button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 1000)
    ComButton.Width = 2000
    ComButton.Caption = "Queries"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Queries_Form()"
    
    'Maintenance button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 1500)
    ComButton.Width = 2000
    ComButton.Caption = "Maintenance"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Maintenance_Form()"
    
    'Exit button
    Set ComButton = CreateControl(frm.Name, acCommandButton, , , , 1000, 2000)
    ComButton.Width = 2000
    ComButton.Caption = "Exit"
    ComButton.ForeColor = 32768
    ComButton.FontBold = True
    ComButton.OnClick = "=Run_Exit_Form()"
    
    DoCmd.Save
    DoCmd.Close
    DoCmd.Rename "MainForm", acForm, NameForm
End Sub
'Forms END

'Functions BEGIN
Function Run_Movie_Form()
    DoCmd.OpenForm "MovieForm"
End Function
Function Run_MovieTheatre_Form()
    DoCmd.OpenForm "MovieTheatreForm"
End Function
Function Run_MoviePlay_Form()
    DoCmd.OpenForm "MoviePlayForm"
End Function
Function Run_Exit_Form()
    DoCmd.Close
End Function

Function Run_Query1_Form()
    DoCmd.OpenForm "Query1_second_Form"
End Function
Function Run_Query2_Form()
    DoCmd.OpenForm "Query2_Form"
End Function
Function Run_Query3_Form()
    DoCmd.OpenForm "Query3_Form"
End Function
Function Run_Query4_Form()
    DoCmd.OpenForm "Query4_Form"
End Function
Function Run_Query5_Form()
    DoCmd.OpenForm "Query5_Form"
End Function
Function Run_Query6_Form()
    DoCmd.OpenForm "Query6_Form"
End Function
Function Run_Query7_Form()
    DoCmd.OpenForm "Query7_Form"
End Function
Function Run_Query8_Form()
    DoCmd.OpenForm "Query8_Form"
End Function
Function Run_Query9_Form()
    DoCmd.OpenForm "Query9_Form"
End Function
Function Run_Query10_Form()
    DoCmd.OpenForm "Query10_Form"
End Function

Function Run_Tables_Form()
    DoCmd.OpenForm "TablesForm"
End Function
Function Run_Queries_Form()
    DoCmd.OpenForm "QueriesForm"
End Function
Function Run_Maintenance_Form()
    DoCmd.OpenForm "MaintenanceForm"
End Function
'Functions END
