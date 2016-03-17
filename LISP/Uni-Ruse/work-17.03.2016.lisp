;;;; 1. Да се дефинира функция, която въвежда числа и брои четните от тях,
;;;; докато се въведе число, равно на дадено.

(defun f1 (number-to-quit)
  (let ((number) (even-numbers-count 0))
   (loop
    (setq number (read))
    (when (= number number-to-quit) (return even-numbers-count))
    (when (= (rem number 2) 0) (setq even-numbers-count (+ even-numbers-count 1))))))

;;;; 2. Да се дефинира функция, която по зададено цяло 
;;;; число n (n>2) пресмята n-тия член на редицата:
;;;;  а[1] = 6, а[2]= -4, а[n] = 3*a[n-1] - 2*a[n-2] * n * (n-1)

(defun f2 (n)
  (cond ((= n 1) 6)
        ((= n 2) -4)
	(t (- (* 3 (f2 (- n 1))) 
	      (* n (- n 1) (* 2 (f2 (- n 2))))))))
