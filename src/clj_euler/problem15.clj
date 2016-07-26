(ns clj-euler.problem15)


(def directions [[0 1] [1 0]])

(def steps 
  (memoize (fn [x y]
             (println x y)
             (cond (and (= x 0) (= y 1)) 1
                   (and (= x 0) (> y 1)) (+ (steps x (dec y)))
                   (and (= x 1) (= y 0)) 1
                   (and (> x 1) (= y 0)) (+ (steps (dec x) y))
                   :else (+ (steps (dec x) y)
                            (steps x (dec y)))))))

