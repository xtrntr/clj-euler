(ns clj-euler.problem2
  (:gen-class))

(defn fib-even-terms [limit]
  (loop [nxt 2
         prev 1
         acc 0]
    (if (<= limit nxt)
      (if (even? nxt) 
        (+ nxt acc)
        (println acc))
      (if (even? nxt) 
        (recur (+ nxt prev) nxt (+ nxt acc))
        (recur (+ nxt prev) nxt acc)))))

(fib-even-terms 4000000)
