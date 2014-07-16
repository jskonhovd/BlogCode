#lang racket
(define (fizzbuzz i)
  (letrec (
           [modthree (remainder i 3)]
           [modfive (remainder i 5)]
           [modthreeandfive (remainder i 15)]
           [f (lambda (x lst) 
                (cond[(> x 100) (print lst)]
                     [(eq? (remainder x 15) 0) (f (+ x 1) (append lst (cons "fizzbuzz" null)))]
                     [(eq? (remainder x 3) 0) (f (+ x 1) (append lst (cons "fizz" null))) ]
                     [(eq? (remainder x 5) 0)  (f (+ x 1) (append lst (cons "buzz" null)))]
                     [#t (f (+ x 1) (append lst (cons x null)))]))]
           
           )
    (f i '())))

         
(define (quicksort xs)
  (letrec (
           [pivot (if (empty? xs) xs (car xs))]
           [tail (if (empty? xs) '() (cdr xs))]
           [grt (filter (lambda(x) (> x pivot)) tail)]
           [lst (filter (lambda(x) (<= x pivot)) tail)])
    (if (empty? xs)
          xs 
         (append (quicksort lst) (list pivot) (quicksort grt) ))
     )
  )
           
           
          
    
   