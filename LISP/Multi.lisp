;;;; Да се дефинира функция, която намира
;;;; произведението на елементите на даден списък, които са числа, по–
;;;; малки от a.

;; Define function
(defun multi (input-list a)
  (cond ((null input-list) 1)
        ((and (numberp (car input-list))
              (< (car input-list) a))
         (* (car input-list) (multi (cdr input-list) a)))
        (t (multi (cdr input-list) a))))

;; Call function
(multi '(1 2 3 4 a -5 2) 4)
