;;;; 11 задача: Да се дефинира функция, която проверява дали дадена година е високосна.

;; Define function
(defun is-leap-year (year)
  (or (= (rem year 400) 0)
      (and (= (rem year 4) 0)
	   (not (= (rem year 100) 0)))))

;; Call function
(is-leap-year 2016)
