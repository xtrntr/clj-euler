(ns clj-euler.problem1
  (:gen-class))

(defn sum-multiple [n]
  (reduce + (for [x (range n)
                  :when (or (zero? (mod x 3))
                            (zero? (mod x 5)))]
              x)))

(sum-multiple 1000)
