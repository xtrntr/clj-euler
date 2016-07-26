(ns clj-euler.problem7)

(defn factor? [possible-factor n]
  (zero? (mod n possible-factor)))

(defn prime? [n prime-lst]
  (cond (even? n) false
       (some #(factor? % n) prime-lst) false
       (some #(factor? % n) (filter even? (range 3 (Math/sqrt n)))) false
       :else true)) 

(def known-primes '(2 3 5 7 11 13))

(defn find-primes [n]
  (loop [prime-lst known-primes
         idx (count known-primes)
         curr-n (last known-primes)]
    (cond (= idx n) (first prime-lst)
          (prime? curr-n prime-lst) (do (inc idx) 
                                        (recur (cons curr-n prime-lst) (inc idx) (+ 2 curr-n)))
          :else (recur prime-lst idx (inc curr-n)))))

(time (find-primes 10001))
