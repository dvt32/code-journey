;;;; Димитър Валериев Трифонов - КН, 50Б, 146518

;;;; 16 задача: 
;;;; Даден е списък на хората, работещи в дадена фирма, който съдържа за всеки човек 
;;;; - име, 
;;;; - професия, 
;;;; - стаж, 
;;;; - работна позиция. 
;;;; Да се дефинира функция, която
;;;; - претърсва списъка и извежда имената на всички хора, 
;;;; - работещи на дадена позиция, 
;;;; - които имат стаж по–малък от зададена граница.

;; Функция за създаване на обект
(defun make-person (name-value job-value internship-value)
 (let ((person name-value))
  (setf (get person 'name) name-value)
  (setf (get person 'job) job-value)
  (setf (get person 'internship) internship-value)
  person))

;; Функция за създаване на асоциативен списък
(defun create-list (my-list)
  (let ((name) (job) (internship))
    (loop
      (princ "Enter name or '0' to exit: ")
      (setq name (read))
      (when (equal name 0) (return my-list))
      (princ "Enter job: ")
      (setq job (read))
      (princ "Enter internship: ")
      (setq internship (read))
      (setq my-list (append my-list (list (make-person name job internship)))))))

;; Списък, в който се съдържа резултата от create-list
(setq people-list (create-list '()))

;; Функция за извеждане на имената на хора, работещи на дадена позиция със стаж по-малък от дадена граница
(defun print-people (input-list job-to-find max-internship)
  (cond ((null input-list) '())
        ((and (equal (get (car input-list) 'job) job-to-find) 
              (< (get (car input-list) 'internship) max-internship))
         (cons (get (car input-list) 'name) 
               (print-people (cdr input-list) job-to-find max-internship)))
        (t (print-people (cdr input-list) job-to-find max-internship))))

;; Въведи стойности за аргументи и извикай-функцията print-people
(princ "Enter job to find: ")
(setq job-to-find (read))
(princ "Enter max internship: ")
(setq max-internship (read))

(print-people people-list job-to-find max-internship)
