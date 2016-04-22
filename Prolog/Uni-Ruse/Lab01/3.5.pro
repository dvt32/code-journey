/*

5 задача: Дадена е информацията за колите в една автокъща. За всяка има дадени:
- номер (уникален за всяка кола), 
- марка, 
- модел, 
- цвят, 
- година на производство, 
- пробег. 

Да се напишат факти, описващи тази информация. 

Да се зададат следните въпроси:

а. Кои са червените коли?
б. Има ли кола, произведена през 2007 година?
в. Кои коли са с пробег < 50 000 км?
г. Кои модели Ford има в наличност?
д. Какви цветове Opel Astra има?
е. Кои коли са произведени след 2000 година?
ж. Има ли бял Mercedes, произведен след 2005 година?
з. Кои коли са под 10 000?
и. Има ли синя кола, произведена след 2006 година и да има пробег под 110 000 км?

*/

car(1, bmw, e46, blue, 2007, 10000).
car(2, opel, astra, red, 2007, 9999).
car(3, mercedes, benz, white, 1999, 10001).
car(4, mercedes, benz, blue, 2007, 110001).
car(5, bmw, e45, red, 2001, 50001).
car(6, bmw, e46, white, 2002, 49000).
car(7, ford, mustang, white, 1999, 20000).
car(8, ford, focus, black, 2000, 11111).
car(9, opel, astra, white, 2001, 12122).

red_car(CAR_NUMBER) :- car(CAR_NUMBER,_,_,red,_,_).
km_under_50000(CAR_NUMBER) :- 
  car(CAR_NUMBER, _, _, _, _, KM),
  KM < 50000.

/* а. Кои са червените коли? */
% ?-red_car(CAR_NUMBER), write(CAR_NUMBER), nl.

/* б. Има ли кола, произведена през 2007 година */
% ?-car(_, _, _, _, 2007, _).

/* в. Кои коли са с пробег < 50 000 км? */
% ?-km_under_50000(CAR_NUMBER), write(CAR_NUMBER), nl.

/* г. Кои модели Ford има в наличност? */
% ?-car(_, ford, MODEL, _, _, _), write(MODEL), nl.

/* д. Какви цветове Opel Astra има? */
% ?-car(_, opel, astra, COLOR, _, _), write(COLOR), nl.

/* е. Кои коли са произведени след 2000 година? */
% ?-car(CAR_NUMBER, _, _, _, YEAR_OF_PRODUCTION, _), YEAR_OF_PRODUCTION > 2000, write(CAR_NUMBER), nl.

/* ж. Има ли бял Mercedes, произведен след 2005 година? */
% ?-car(_, mercedes, _, white, YEAR_OF_PRODUCTION, _), YEAR_OF_PRODUCTION > 2005.

/* з. Кои коли са под 10 000? */
% ?-car(CAR_NUMBER, _, _, _, _, KM), KM < 10000, write(CAR_NUMBER), nl.

/* и. Има ли синя кола, произведена след 2006 година и да има пробег под 110 000 км? */
% ?-car(_, _, _, blue, YEAR_OF_PRODUCTION, KM), YEAR_OF_PRODUCTION > 2006, KM < 110000.
