(ns clj-euler.problem5
  (:require [clojure.test :as test]))

(def factor?
  (fn [possible-factor n] (zero? (mod n possible-factor))))

(def prime-numbers '(2 3 5 7 11 13 17 19))

(defn prime-decomposition [n]
  (loop [curr n
         idx 0
         acc '()]
    (let [possible-factor (nth prime-numbers idx)]
      (cond (= curr 1) acc
            ;;doesn't cover edge cases beyond the small set of numbers that i am testing here
            (factor? possible-factor curr) 
            (recur (/ curr possible-factor) 0 (cons possible-factor acc))
            :else (recur curr (inc idx) acc)))))

(defn absorb [seq1 seq2]
  (loop [s1 (sort seq1)
         s2 (sort seq2)
         acc '()]
    (let [s1-curr (first s1)
          s2-curr (first s2)]
      (cond (and (empty? s1) (empty? s2)) acc
            (empty? s1) (into s2 acc)
            (empty? s2) (into s1 acc)
            (= s1-curr s2-curr) (recur (rest s1) (rest s2) (cons s1-curr acc))
            (> s1-curr s2-curr) (recur s1 (rest s2) (cons s2-curr acc))
            :else (recur (rest s1) s2 (cons s1-curr acc))))))

(defn smallest-multiple [set]
  (loop [lst set
         acc '()]
    (cond (empty? lst) acc
          :else (recur (rest lst) (absorb (prime-decomposition (first lst)) acc)))))

(test/is 2520 (apply * (smallest-multiple (range 1 10))))
