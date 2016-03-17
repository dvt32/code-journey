;;;; 1. Да се дефинира функция, която 
;;;;	- въвежда числа от клавиатурата и 
;;;;	- намира броя на отрицателните, 
;;;;	- докато сумата на положителните стане 5 цифрено число.

(defun f1 ()
  (let ((number 0) (neg-count 0) (sum 0))
    (loop
     (when (> sum 9999) (return neg-count))
     (setq number (read))
     (cond ((minusp number) (setq neg-count (+ neg-count 1)))
           ((plusp number) (setq sum (+ sum number)))))))

;;;; 2. Да се дефинира функция, която 
;;;; - проверява дали три, зададени с дължините си отсечки, могат да образуват триъгълник и извежда
;;;; - 0 - ако не могат; 
;;;; - 1 - ако триъгълникът е равностранен; 
;;;; - 2 - за равнобедрен и 
;;;; - 3 - за всички останали триъгълници.

(defun f2 (a b c)
  (if (not (and (> (+ a b) c) (> (+ a c) b) (> (+ b c) a)))
      0
      (cond 
        ((and (= a b) (= a c) (= b c)) 1)
        ((or (= a b) (= a c) (= b c)) 2)
        (t 3))))

;;;; 3. Да се дефинира функция, която 
;;;; - намира сумата на елементите от даден списък, 
;;;; - които са числа, лежащи в даден интервал.

;; Define function
(defun f3 (list)
  (cond ((null list) 0)
        (t (+ (car list) (f3 (cdr list))))))

;; Define list and call function
(let ((low-end) (high-end) (number) (my-list ()))
  ;; Set bounds
  (princ "Enter low-end: ")
  (setq low-end (read))
  (princ "Enter high-end: ")
  (setq high-end (read))
  
  ;; Enter list elements
  (loop
    (princ "Enter number: ")
    (setq number (read))
    (when (or (< number low-end) (> number high-end)) 
	  (setq my-list (reverse my-list))
          (return my-list))
    (setq my-list (cons number my-list)))

  ;; Print list
  (print my-list)

  ;; Call function
  (f my-list))
