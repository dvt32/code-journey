/*

1 задача: 

Дефинирайте база от данни, която описва поне 10 списания с техните характеристики (заглавие, начална година на издаване, пореден брой, брой страници). 

Използвайте структура magazine(заглавие, година, пореден брой, страници). 

Задайте следните въпроси, като при необходимост дефинирате допълнителни отношения:

а. Кои са списанията, издавани преди 2000?
б. Кои списания, имат поне 50 страници?
в. Има ли списания, издавани през 1968 година?
г. Кои списания имат издадени повече от 250 броя?
д. Кои списания са от 1991 година?

*/

magazine(m1, 1999, 34, 100).
magazine(m2, 2001, 250, 49).
magazine(m3, 1991, 101, 50).
magazine(m4, 2002, 201, 51).
magazine(m5, 1968, 261, 43).
magazine(m6, 2007, 304, 123).
magazine(m7, 2010, 134, 200).
magazine(m8, 1968, 55, 33).
magazine(m9, 2011, 44, 120).
magazine(m10, 2015, 123, 44).

% ?-magazine(MagazineName, StartYear, _, _), StartYear < 2000, write(MagazineName), nl.
% ?-magazine(MagazineName, _, _, NumberOfPages), NumberOfPages >= 50, write(MagazineName), nl.
% ?-magazine(_, 1968, _, _).
% ?-magazine(MagazineName, _, NumberOfIssues, _), NumberOfIssues > 250, write(MagazineName), nl.
?-magazine(MagazineName, 1991, _, _), write(MagazineName), nl.
