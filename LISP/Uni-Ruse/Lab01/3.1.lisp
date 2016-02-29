;;;; 1 задача: Да се напише комбинация от функции, която 
;;;;	при зададени дължини на катетите на правоъгълен триъгълник a и b, 
;;;;	намира неговото лице.

(princ "Enter a: ")
(defparameter a (read))
(princ "Enter b: ")
(defparameter b (read))
(setq area (/ (+ a b) 2))
