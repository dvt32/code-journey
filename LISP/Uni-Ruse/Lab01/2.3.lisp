;;;; 3 задача: Да се напише комбинация от функции, която като резултат проверява дали:
;;;; 	a. дадено число x Є [1, 76];
;;;; 	b. поне две от три зададени числа a, b и c са равни;
;;;;    c. дадено число x Є [1, 76] U [105,400];

;; Solve 'a'
(princ "Enter x: ")
(defparameter x (read))
(and (>= x 1) (<= x 76))

;; Solve 'b'
(princ "Enter a: ")
(defparameter a (read))
(princ "Enter b: ") 
(defparameter b (read))
(princ "Enter c: ")
(defparameter c (read))
(or (= a b) (= a c) (= b c))

;; Solve 'c'
(princ "Enter x: ")
(setq x (read))
(or (<= 1 x 76) (<= 105 x 400))
