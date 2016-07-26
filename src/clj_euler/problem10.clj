(ns clj-euler.problem10
  (:require [clj-euler.utils :as utils]))

(println (+ 2 (reduce + (for [n (range 2 2000000)
                              :when (utils/prime? n)]
                          n))))

