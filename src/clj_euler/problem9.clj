(ns clj-euler.problem9)

(def square 
  (memoize 
   (fn [x]
     (* x x))))

(defn pythagorean-triplet []
  (for [x (range 1 1000)
        y (range 1 1000)
        z (range 1 1000)
        :when (and (= 1000 (+ x y z))
                   (> z y) (> z x)
                   (= (+ (square y) (square x)) (square z)))]
    (list x y z)))

(time (pythagorean-triplet))
