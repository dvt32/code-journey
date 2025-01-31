(* https://codeforces.com/problemset/problem/4/A *)

program Watermelon;

var w: integer;

begin
    read(w);
    if ((w > 2) and (w mod 2 = 0)) then
        writeln('YES')
    else
        writeln('NO')
end.
