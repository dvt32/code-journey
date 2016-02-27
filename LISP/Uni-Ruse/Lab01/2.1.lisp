;;;; 2.1
;;;; Даден е списък TOPL, имащ вида 
;;;; 	((The_Rain DMX) (The_Rain Oran_Juice_Jones) (Disturbia Rihanna)). 
;;;; 
;;;; 	Да се дефинира комбинация от функции, които да връщат като резултат:
;;;; 		a. (The_Rain DMX)
;;;; 		b. (Disturbia Rihanna)
;;;; 		c. The_Rain
;;;; 		d. Oran_Juice_Jones
;;;; 		e. Disturbia
;;;; 		f. Rihanna

;; Define list
(setq TOPL 
  '((The_Rain DMX) (The_Rain Oran_Juice_Jones) (Disturbia Rihanna)))

;; Solve exercise
(car TOPL)		; a. (The_Rain DMX)
(caddr TOPL)		; b. (Disturbia Rihanna)
(caar TOPL)		; c. The_Rain
(cadadr TOPL)		; d. Oran_Juice_Jones
(caaddr TOPL)		; e. Disturbia
(car (cdaddr TOPL))	; f. Rihanna
