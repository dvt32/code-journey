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

;; Дефинирай функция за създаване на обект
(defun make-person (name profession experience job)
 (let ((person name))
  (setf (get person 'name) name)
  (setf (get person 'profession) profession)
  (setf (get person 'experience) experience)
  (setf (get person 'job) job)
  person))

;; Дефинирай функция за създаване на асоциативен списък
(defun create-list (my-list)
  (let ((name) (profession) (experience) (job))
    (loop
      (princ "Enter name or '0' to exit: ") 
      (setq name (read))
      (when (equal name 0) (return my-list))
      (princ "Enter profession: ") 
      (setq profession (read))
      (princ "Enter experience: ") 
      (setq experience (read))
      (princ "Enter job title: ") 
      (setq job (read))
      (setq my-list (append my-list (list (make-person name profession experience job)))))))

;; Дефинирай функция за извеждане на имената на хора, работещи на дадена позиция със стаж по-малък от дадена граница
(defun print-people (my-list find-job max-experience)
  (cond ((null my-list) '())
        ((and (equal (get (car my-list) 'job) find-job) 
              (< (get (car my-list) 'experience) max-experience))
         (cons (get (car my-list) 'name) 
               (print-people (cdr my-list) find-job max-experience)))
        (t (print-people (cdr my-list) find-job max-experience))))

;; Съхрани резултата от create-list в списък
(setq people-list (create-list '()))

;; Въведи стойности за аргументи и извикай-функцията print-people
(princ "Enter job title to find: ")
(setq find-job (read))
(princ "Enter max experience: ")
(setq max-experience (read))
(print-people people-list find-job max-experience)
