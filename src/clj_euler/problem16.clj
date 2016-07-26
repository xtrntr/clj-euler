(ns clj-euler.problem16
  (:require [clj-euler.utils :as utils]
            [clojure.test :as test]))

(defn carry [digits]
  (loop [vec digits
         acc []
         carry false]
    (let [curr (first vec)]
      (cond (and carry (empty? vec)) (conj acc 1) 
            (empty? vec) acc
            (and carry (>= curr 10))       (recur (rest vec) (conj acc (inc (- curr 10))) true)
            (and carry (= 10 (inc curr))) (recur (rest vec) (conj acc 0) true)
            carry                         (recur (rest vec) (conj acc (inc curr)) false)
            (>= curr 10)                   (recur (rest vec) (conj acc (- curr 10)) true)
            :else                         (recur (rest vec) (conj acc curr) false)))))

(defn summing-digits [vec]
  (->> vec
      (map #(* 2 %))
      carry))

(defn sum-digits [power]
  (loop [i 0
         acc [1]]
    (if (= i power)
      (reduce + acc)
      (recur (inc i) (summing-digits acc)))))

(test/is (sum-digits 15) 26)
