;;;; 12 задача: Да се дефинира функция, която по зададени месец и година, определя броя на дните в месеца.

;; Define function, which determines if a certain year is a leap year
(defun is-leap-year (year)
  (or (= (rem year 400) 0)
      (and (= (rem year 4) 0)
	   (not (= (rem year 100) 0)))))

;; Define main function
(defun days (month year)
  (cond ((= month 1) 31)
	((and (not (is-leap-year year)) 
              (= month 2)) 28)
        ((and (is-leap-year year) 
              (= month 2)) 29)
	((= month 3) 31)
	((= month 4) 30)
	((= month 5) 31)
	((= month 6) 30)
	((= month 7) 31)
	((= month 8) 31)
	((= month 9) 30)
	((= month 10) 31)
	((= month 11) 30)
	((= month 12) 31)
	(t "Invalid month.")))
