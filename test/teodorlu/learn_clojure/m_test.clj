(ns teodorlu.learn-clojure.m-test
  (:require
   [clojure.test :refer [deftest is]]))

;; 2023-10-01
;;
;; clojurians slack question on #beginners about rounding behavior with floats.

(deftest m
  (is true))

(type 1)

(type 0.9)

(type 0.9M)

(type (+ 0.8M 0.1))
;; => java.lang.Double

(type (+ 0.8M 0.1M))
;; => java.math.BigDecimal

(+ 0.8M 0.1M)
;; => 0.9M

(+ 0.7 0.1)
;; => 0.7999999999999999
