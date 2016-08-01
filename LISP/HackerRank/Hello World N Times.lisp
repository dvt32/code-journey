;;;; https://www.hackerrank.com/challenges/fp-hello-world-n-times

(defun fn (n)
  (dotimes (counter n)
    (format t "Hello World~%")))

(fn (read))
