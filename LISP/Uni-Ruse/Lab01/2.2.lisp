;;;; 2 задача: Даден е списъка (Alfa Beta Gama Delta Epsilon). Да се напише комбинация от функции, която като резултат да добавя елемента Kapa:
;;;; 	a. преди първия елемент на дадения списък;
;;;; 	b. между първия и втория елемент на дадения списък;
;;;; 	c. като последен елемент на дадения списък.

;; Define list
(setq myList '(Alfa Beta Gama Delta Epsilon))

;; Solve 'a'
(cons 'Kapa myList)

;; Solve 'b'
(cons (car myList) (cons 'Kapa (cdr myList)))

;; Solve 'c'
(append myList (list 'Kapa))