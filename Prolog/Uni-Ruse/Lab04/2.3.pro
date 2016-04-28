/*

3 задача:
Да  се  дефинира  предикат, който  
- проверява  дали  даден елемент се съдържа в даден списък (само на първо ниво)
.

*/

member(Element, []) :- fail.
member(Element, [Element|Tail]) :- !.
member(Element, [_|Tail]) :- member(Element, Tail).

?-member(a, [b, a, c]).
