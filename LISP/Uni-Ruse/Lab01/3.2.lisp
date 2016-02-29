;;;; 2 задача: Да се напише комбинация от функции, която 
;;;;	при зададени 3 дължини на отсечки a, b и c, 
;;;;	проверява дали отсечки с тези дължини могат да образуват триъгълник.

;; Enter values for each side
(princ "Enter a: ")
(defparameter a (read))
(princ "Enter b: ")
(defparameter b (read))
(princ "Enter c: ")
(defparameter c (read))

;; Check if they can form a triangle
(and
  (> (+ a b) c)
  (> (+ a c) b)
  (> (+ b c) a))
