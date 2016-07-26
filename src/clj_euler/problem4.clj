(ns clj-euler.problem4
  (:require [clojure.test :as test]
            [clojure.string :as string]))

(def palindrome?
  (memoize (fn [n] 
             (let [n-str (str n)]
               (= n-str (string/reverse n-str))))))

(test/is (palindrome? 909) true)

(defn factors-palindrome [digits]
  (let [possible-factors (range (Math/pow 10 (dec digits))
                                (Math/pow 10 digits))]
    (loop [pairs (for [x possible-factors
                       y possible-factors
                       :when (palindrome? (int (* x y)))]
                   (list x y))
           highest '(0 0)]
      (let [curr-product (apply * (first pairs))
            curr-highest (apply * highest)]
        (cond (empty? pairs) highest
              (> curr-product curr-highest) (recur (rest pairs) (first pairs))
              :else (recur (rest pairs) highest))))))

(println (apply * (factors-palindrome 3)))
