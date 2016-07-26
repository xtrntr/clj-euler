(ns clj-euler.problem17)

["one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten"
 "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen" "twenty"]
(defn sum-number [limit]
  (loop [i 1
         acc]
    (cond (= limit i) acc)))
