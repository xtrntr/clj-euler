(ns clj-euler.problem6
  (:require [clojure.test :as test]))

(def whole-numbers (iterate inc 1))

(defn square [n] (* n n))

(- (square (reduce + (take 100 whole-numbers)))
   (reduce + (map square (take 100 whole-numbers))))
