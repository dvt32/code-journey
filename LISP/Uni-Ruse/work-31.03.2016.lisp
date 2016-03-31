;;;; 1. Да се дефинира функция на Lisp, 
;;;; - която при въвеждане на 'p' 
;;;; - извежда (4*p)/((p-8)*11), ако р е число (различно от 8) 
;;;; - и “not number” – в противен случай. 
;;;; Действието продължава в цикъл, докато се въведе 8.	

(defun f ()
  (loop
    (setq p (read))
    (when (equal p 8) (return))
    (cond ((numberp p) (print (/ (* 4 p) (* 11 (- p 8)))))
          (t (princ "not number")))))

;;;; 2.	Дефинирайте функция, която 
;;;; - премахва от входния списък с произволни елементи, 
;;;; - всички положителни двуцифрени числа.
    
(defun f2 (input)
  (cond ((null input) nil)
        ((and (numberp (car input)) (< 9 (car input) 100))
         (f2 (cdr input)))
        (t (cons (car input) (f2 (cdr input))))))
        
;;;; 3.	Даден е списък на хората, работещи в дадена фирма, който съдържа за всеки човек 
;;;; - име, 
;;;; - брой отработени дни за месеца и 
;;;; - дневна тарифна ставка (сумата, която получават за 1 работен ден). 
;;;; Да се дефинира функция, която претърсва списъка и 
;;;; - извежда имената на всички хора, 
;;;; - които имат дневна тарифна ставка, равна на дадена 
;;;; - и са отработили не по-малко от определен брой дни за месеца.

;; Make person
(defun f3-make-person (name work-days daily-pay)
  (let ((person name))
    (setf (get person 'name) name)
    (setf (get person 'work-days) work-days)
    (setf (get person 'daily-pay) daily-pay)
    person))

;; Make list
(defun f3-make-list (my-list)
  (let ((name) (work-days) (daily-pay))
    (loop
      (princ "Enter name or '0' to quit: ")
      (setq name (read))
      (when (equal name 0) (return my-list))
      (princ "Enter work days: ")
      (setq work-days (read))
      (princ "Enter daily pay: ")
      (setq daily-pay (read))
      (setq my-list (append my-list (list (f3-make-person name work-days daily-pay)))))))

;; Get names of people with a certain daily-pay and work-days that are at least a certain amount
(defun f3-print-people (input-list exact-daily-pay min-work-days)
  (cond ((null input-list) nil)
        ((and (equal (get (car input-list) 'daily-pay) exact-daily-pay)
              (<= min-work-days (get (car input-list) 'work-days)))
         (cons (get (car input-list) 'name) (f3-print-people (cdr input-list) exact-daily-pay min-work-days))) 
        (t (f3-print-people (cdr input-list) exact-daily-pay min-work-days))))

;; Store result of f3-make-list in a list
(setq people-list (f3-make-list '()))
