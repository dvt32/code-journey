/*

1 задача:

Дадена е информация за екскурзиите, предлагани от дадена фирма. 
За всяка от тях има следната информация: 
- крайна цел на пристигане; 
- държава, в която се намира; 
- продължителност на екскурзията в дни; 
- цена на екскурзията в лева; 
- начин на пътуване. 

Да се дефинират следните въпроси към нея:
- а.Колко дни е екскурзията до Барселона?
- б.До кои градове се пътува с влак?
- в.Има ли екскурзия до Будапеща?
- г.Колко струва всяка от екскурзиите до Италия?
- д.До  кои  градове  в  Германия  се  пътува  със самолет?
- е.Кои са екскурзиите по 25 дни?

*/

travel(sofia, bulgaria, 3, 200, bus).
travel(madrid, spain, 4, 1000, plane).
travel(paris, france, 3, 500, train).
travel(paris, france, 7, 1000, plane).
travel(rome, italy, 4, 500, train).
travel(rome, italy, 5, 600, plane).
travel(berlin, germany, 1, 100, plane).
travel(berlin, germany, 2, 200, train).
travel(frankfurt, germany, 3, 300, plane).
travel(barcelona, spain, 7, 1200, plane).
travel(sofia, bulgaria, 3, 100, train).
travel(sofia, bulgaria, 25, 1000, bus).

% ?-travel(barcelona,_,DAYS,_,_), write(DAYS), nl.
% ?-travel(CITY, _, _, _, train), write(CITY), nl.
% ?-travel(budapest, _, _, _, _), nl.
% ?-travel(_, italy, _, PRICE, _), write(PRICE), nl.
% ?-travel(CITY, germany, _, _, plane), write(CITY), nl.
?-travel(CITY, COUNTRY, 25, _, _), write(CITY), nl, write(COUNTRY), nl.
