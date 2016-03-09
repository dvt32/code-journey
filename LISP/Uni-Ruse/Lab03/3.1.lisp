;;;; 1 задача: Да се дефинира функция, която 
;;;; - по зададено цяло положително число n, 
;;;; - проверява дали то е палиндром.

(defun is-palindrome (number)
  (let ((n-reversed 0) (n number))
    (loop
      (when (= n 0) (return (= n-reversed number)))
      (setq n-reversed (+ (* n-reversed 10) (rem n 10)))
      (setq n (floor (/ n 10))))))
