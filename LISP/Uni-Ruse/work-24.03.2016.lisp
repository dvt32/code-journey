;;;; 1.	Да се дефинира функция, която 
;;;; заменя всички елементи, 
;;;; - равни на даден елемент S1 
;;;; - с друг даден елемент S2 
;;;; в дадения списък  (да се използва EQUAL – за произволни елементи). 

(defun replace-in-list (my-list S1 S2)
  (cond ((null my-list) my-list)
        ((equal (car my-list) S1) (setf (car my-list) S2)
				  (replace-in-list (cdr my-list) S1 S2)
				  my-list)
	(t (replace-in-list (cdr my-list) S1 S2))))
