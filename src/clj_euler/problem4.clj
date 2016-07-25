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
    (for [x possible-factors])))
