/*

07.04.2016

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


/*

2 задача:

Дадена е следната информация: 
- Фидо,  Фред,  Ровър  и  Том  са  кучета.  
- Мъри,  Джейн,  Хенри, Хари, Бил и Стив са котки. 
- Фидо, Мъри, Фред, Хенри, Стив, Джим и Майк са големи. 
- Ровър, Джейн и Том са малки. 

Да се представи информацията във вид на програма на PROLOG.
 
Да се добави, че големите кучета преследват малките животни. 

Да се зададе подходящ въпрос.

*/

dog(fido).
dog(fred).
dog(rover).
dog(tom).
cat(murray).
cat(jane).
cat(henry).
cat(harry).
cat(bill).
cat(steve).
large(fido).
large(murray).
large(fred).
large(henry).
large(steve).
large(jim).
large(mike).
small(rover).
small(jane).
small(tom).

large_dog(DOG_NAME) :-
  dog(DOG_NAME), 
  large(DOG_NAME).

small_animal(ANIMAL_NAME) :-
  dog(ANIMAL_NAME), 
  small(ANIMAL_NAME).

small_animal(ANIMAL_NAME) :-
  cat(ANIMAL_NAME), 
  small(ANIMAL_NAME).

chase(CHASER, CHASED) :-
  large_dog(CHASER), 
  small_animal(CHASED).

?-chase(ANIMAL1, ANIMAL2), write(ANIMAL1), write(" is chasing "), write(ANIMAL2), nl.
