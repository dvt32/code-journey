;;;; 3 задача: Да се дефинира функция, която 
;;;;	- въвежда последователно елементи от клавиатурата и 
;;;;	- намира сумата на положителните числа от въведените, 
;;;;	- докато броя на въведените нули стане 5.

(defun f ()
  (let ((zero-count 0) (sum 0) (number 0))
    (loop 
      (setq number (read))
      (cond ((= number 0) (setq zero-count (+ zero-count 1)))
            ((> number 0) (setq sum (+ sum number))))
      (when (= zero-count 5) (return sum)))))
