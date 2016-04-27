/*

1 задача: 

Дадени са факти на PROLOG, описващи няколко списания, като за всяко е дадено
- име, 
- издателство, 
- цена. 

Списанието е структура от вида - magazine(наименование, издател, цена), 
а издателя е структура – publisher(издателство, град). 

Да се зададат подходящи въпроси, така че да се изведат:

а. Всички списания на даден издател;
б. Имената на всички списания, които струват по–малко от 3 лв;
в. Имената на всички списания, издавани в София;
г. Издателство с поне две различни списания;
д. Най–евтиното списание.

*/

magazine("Magazine 1", publisher(pub1, "Sofia"), 1).
magazine("Magazine 2", publisher(pub2, "Rousse"), 3).
magazine("Magazine 3", publisher(pub1, "Sofia"), 0).

at_least_two_magazines(PublisherName) :-
	magazine(MagazineName1, publisher(PublisherName,_), _),
	magazine(MagazineName2, publisher(PublisherName,_), _),
	MagazineName1 \== MagazineName2, !. 

cheapest_magazine(MagazineName, PriceOfMagazine) :-
 	magazine(MagazineName, _, PriceOfMagazine),
	not(magazine(MagazineName2, _, PriceOfMagazine2), 
	    MagazineName2 \= MagazineName, 
	    PriceOfMagazine2 < PriceOfMagazine).


/* а. Всички списания на даден издател; */
% ?-magazine(MagazineName, publisher(pub1,_), _), write(MagazineName), nl.

/* б. Имената на всички списания, които струват по–малко от 3 лв. */
% ?-magazine(MagazineName, _, PriceOfMagazine), PriceOfMagazine < 3, write(MagazineName), nl.

/* в. Имената на всички списания, издавани в София; */
% ?-magazine(MagazineName, publisher(_, "Sofia"), _), write(MagazineName), nl.

/* г. Издателство с поне две различни списания */
% ?-at_least_two_magazines(PublisherName), write(PublisherName), nl.

/* д. Най–евтиното списание */
?-cheapest_magazine(MagazineName, PriceOfMagazine), write(MagazineName), nl, write(PriceOfMagazine), nl.
