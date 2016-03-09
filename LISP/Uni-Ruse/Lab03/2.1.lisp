;;;; 1 задача: Да се дефинира функция, която намира 
;;;;	- средно-аритметичното на числата кратни на 3 и на 5, 
;;;;	- които са по-големи от а и по–малки от b.

(defun avg (a b)
  (let ((number-count 0) (sum 0) (number (+ 1 a)))
    (loop  (cond ((= number b) (return (/ sum number-count)))
	         ((and (= (rem number 3) 0) (= (rem number 5) 0))
	            (setq number-count (+ number-count 1))
	            (setq sum (+ sum number))))
	   (setq number (+ number 1)))))
