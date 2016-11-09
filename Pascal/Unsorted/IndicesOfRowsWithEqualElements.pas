{ 
  We have a 2D integer array with 'm' rows and 'n' columns. 
  Print indices of rows where all elements are equal.
}

program IndicesOfRowsWithEqualElements;

var 
    m, n: integer;
    arrayOfNumbers: array[1..100, 1..100] of integer;
    i, j: integer;
    allElementsOfRowAreEqual: boolean;

begin
    read(m);
    read(n);
    
    { Enter array numbers }
    for i := 1 to m do
        for j := 1 to n do
            read(arrayOfNumbers[i,j]);
    
    { Print array numbers }
    for i := 1 to m do
    begin
        for j := 1 to n do
            write(arrayOfNumbers[i,j], ' ');
        writeln();
    end;
    
    { Check each row to see if its elements are equal }
    for i := 1 to m do
    begin
        allElementsOfRowAreEqual := true;
        for j := 1 to n-1 do
            if (arrayOfNumbers[i,j] <> arrayOfNumbers[i,j+1]) then
            begin
                allElementsOfRowAreEqual := false;
                break;
            end;
        if (allElementsOfRowAreEqual = true) then
            writeln('Elements on row ', i, ' are equal.');
    end; 
end.
