/*

Даден е списък на хората, кандидатстващи за работа във фирма "ПринтКо". 

За всеки човек са дадени:
- име
- възраст
- специалност
- стаж

Помогнете на управителя като дефинирате предикат, който ПО ЗАДАДЕНА СПЕЦИАЛНОСТ извежда списък с имената на всички кандидати, имащи:
- такава специалност
- поне 5 години стаж
- и не по-възрастни от 45 години

*/

company([
  person(name("Ivan", "Ivanov"), 32, spec1, 6),
  person(name("Petar", "Petrov"), 46, spec1, 7),
  person(name("Nikolai", "Nikolov"), 33, spec1, 6),
  person(name("Maria", "Petrova"), 43, spec2, 5),
  person(name("Dimitar", "Ivanov"), 42, spec1, 3),
  person(name("Mihaela", "Ivanova"), 46, spec2, 7)
]).

find_person(_, [], []).
find_person(
  SpecialtyToBeFound,
  [person(name(FirstName, LastName), Age, Specialty, Experience)|T],
  [[FirstName, LastName]|T1])
:-
  Specialty == SpecialtyToBeFound,
  Experience >= 5,
  Age =< 45, !,
  find_person(SpecialtyToBeFound, T, T1).
find_person(SpecialtyToBeFound, [H|T], T1) :- 
  find_person(SpecialtyToBeFound, T, T1).

?-company(List), read(SpecialtyToBeFound), find_person(SpecialtyToBeFound, List, NewList), write(NewList), nl, fail.
