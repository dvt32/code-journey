;;;; 13 задача: Да се дефинира функция, която по зададени три дължини на отсечки, проверява дали те могат да образуват правоъгълен триъгълник.

(defun right-triangle (a b c)
  (if
    (and
      ;; Check if they form a triangle
      (and (> (+ a b) c) (> (+ a c) b) (> (+ b c) a))
	   ;; Check if it is a right-angled triangle via Pythagorean theorem
	   (= (expt c 2) (+ (expt a 2) (expt b 2))))
    t	
    nil))
