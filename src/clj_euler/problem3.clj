(ns clj-euler.problem3
  (:use clojure.test))

(def factor?
  (fn [possible-factor n] (zero? (mod n possible-factor))))

(def prime?
  (memoize (fn [n] (= 1 (count (filter (fn [factor] (factor? factor n)) (range 1 (Math/floor (Math/sqrt n)))))))))

(is true (prime? 7))

(defn max-prime-factor [n]
  ;(apply max)
  (let [factors (range 1 (Math/floor (Math/sqrt n)))]
    (apply max (filter (fn [factor] (and (factor? factor n) (prime? factor))) 
                       factors))))

(is (time (max-prime-factor 13195)) 29)
(time (println (max-prime-factor 600851475143)))
