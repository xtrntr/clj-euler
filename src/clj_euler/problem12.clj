(ns clj-euler.problem12
  [:require (clj-euler.utils :as utils)])

(defn num-divisors [n]
  (let [res (Math/sqrt n)
        half-gcds (count (for [factor (range 1 res)
                               :when (utils/factor? factor n)]
                           factor))]
    (if (utils/factor? res n)
      (+ 1 (* 2 half-gcds))
      (* 2 half-gcds))))

(defn triangular-numbers [divisors]
  (loop [n 1
         prev 2]
    (if (<= divisors (num-divisors n))
      n
      (recur (+ n prev) (inc prev)))))
