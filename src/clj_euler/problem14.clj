(ns clj-euler.problem14
  (:require [clojure.test :as test]
            [clj-euler.utils :as utils]))

(def collatz-seq-even
  (memoize
   (fn [start]
     (inc (* 3 start)))))

(def collatz-seq-odd
  (memoize
   (fn [start]
     (/ start 2))))

(def collatz-seq 
  (memoize 
   (fn [start]
     (loop [curr start
            terms 1]
       (cond (= curr 1) terms
             (odd? curr)
             (recur (collatz-seq-even curr) (inc terms))
             (even? curr)
             (recur (collatz-seq-odd curr) (inc terms)))))))

(test/is (collatz-seq 13) 10)

(defn brute-force [limit]
  (loop [i 1
         most 1]
    (when (utils/factor? 100 i) (println i))
    (if (= i limit) most
        (if (> (collatz-seq i) (collatz-seq most))
          (recur (inc i) i)
          (recur (inc i) most)))))

(brute-force 1000000)
