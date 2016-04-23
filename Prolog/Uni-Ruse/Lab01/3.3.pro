/*

III. 3 задача:

Дадена  е  информация  за  музикалната  класация Българският ТОП 10. 

За всяка песен има 
- име на песента, 
- получени точки до момента, 
- изпълнител, 
- автор на текста и 
- композитор. 

Да се представи  информацията  на PROLOG.

Да  се  зададат  следните въпроси:
  а.Коя песен има >50 точки?
  б.Кои са песните, чийто изпълнител е Георги Христов?
  в.Има ли песен с композитор Ангел Заберски?
  г.Кои са песните в класацията?
  д. Има ли автор с поне две песни в класацията?

*/

song(somesong1, 32, georgi_hristov, author1, composer1).
song(somesong2, 52, ivan_ivanov, author2, angel_zaberski).
song(somesong3, 50, petar_petrov, author3, composer3).
song(somesong4, 22, georgi_hristov, author4, composer4).
song(somesong5, 53, ivan_ivanov, author5, composer5).
song(somesong6, 22, georgi_georgiev, author6, composer6).
song(somesong7, 34, ivan_petrov, author7, composer7).
song(somesong8, 44, petar_ivanov, author8, composer8).
song(somesong9, 55, nikolai_nikolov, author9, composer9).
song(somesong10, 42, ivan_nikolov, author10, composer10).

song_with_length_above_50(SONGNAME, SONGPOINTS) :-
  song(SONGNAME, SONGPOINTS, _, _, _),
  SONGPOINTS>50.
song_where_artist_is_georgi_hristov(SONGNAME) :-
  song(SONGNAME, _, georgi_hristov, _, _).
author_with_at_least_two_songs(AUTHOR) :-
  song(SONGNAME1, _, _, AUTHOR, _),
  song(SONGNAME2, _, _, AUTHOR, _),
  SONGNAME1 \== SONGNAME2, !.
  

/* а.Коя песен има >50 точки? */
% ?-song_with_length_above_50(SONGNAME, SONGPOINTS), write(SONGNAME), nl, write(SONGPOINTS), nl.

/* б.Кои са песните, чийто изпълнител е Георги Христов? */
% ?-song_where_artist_is_georgi_hristov(SONGNAME), write(SONGNAME), nl.

/* в.Има ли песен с композитор Ангел Заберски? */
% ?-song(_, _, _, _, angel_zaberski).

/* г.Кои са песните в класацията? */
% ?-song(SONGNAME, _, _, _, _), write(SONGNAME), nl.

/* д. Има ли автор с поне две песни в класацията? */
?-author_with_at_least_two_songs(AUTHOR), write(AUTHOR), nl. 
