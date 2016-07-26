(ns clj-euler.utils)

(defn factor? [possible-factor n]
  (zero? (mod n possible-factor)))

(def prime? 
  (memoize 
   (fn [n]
     (cond (even? n) false
           (some #(factor? % n) (filter odd? (range 2 (inc (Math/sqrt n))))) false
           :else true))))

(defn digits [n]
  (if (zero? n)
    '(0)
    (->> n
         (iterate #(quot % 10))
         (take-while pos?)
         (mapv #(mod % 10))
         (mapv int)
         rseq)))
