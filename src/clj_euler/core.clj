(ns clj-euler.core
  (:gen-class))

(defn sum-multiple [n]
  (reduce + (for [x (range n)
                  :when (or (zero? (mod x 3))
                            (zero? (mod x 5)))]
              x)))

(sum-multiple 1000)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
