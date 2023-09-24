(ns teodorlu.learn-clojure-test
  (:require [clojure.test :refer [deftest is testing]]))

(deftest mytest
  (testing "addition"
    (is (= 2 (+ 1 1)))))
