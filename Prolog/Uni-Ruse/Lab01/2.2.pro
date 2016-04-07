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
