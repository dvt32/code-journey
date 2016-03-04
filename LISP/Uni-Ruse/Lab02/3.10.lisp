;;;; 10 задача: Да се дефинира функция, която 
;;;; - по зададени три дължини на отсечки, 
;;;; - проверява дали те могат да образуват равнобедрен триъгълник.

(defun iso-triangle (a b c)
  (if
    (and
      ;; Check if they form a triangle
      (and (> (+ a b) c) (> (+ a c) b) (> (+ b c) a))
      ;; Check if it is an isosceles triangle
      (or (= a b) (= a c) (= b c)))
    t	
    nil))
