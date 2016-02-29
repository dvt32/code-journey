;;;; 3 задача: Да се дефинира комбинация от функции, която от дадения списък 
;;;; 	((apple green) (apple red) (strawberry red) (pear yellow)), връща като резултат:
;;;; 		a. apple
;;;; 		b. red
;;;; 		c. (strawberry red)
;;;; 		d. (pear yellow)
;;;; 		e. (yellow)
;;;; 		f. pear

;; Define list
(setq myList
  '((apple green) (apple red) (strawberry red) (pear yellow)))

;; Solve exercise
(caar myList)		; а. apple
(cadadr myList)		; b. red
(caddr myList)		; c. (strawberry red)
(cadddr myList)		; d. (pear yellow)
(cdr (cadddr myList))	; e. (yellow)
(car (cadddr myList))	; f. pear
