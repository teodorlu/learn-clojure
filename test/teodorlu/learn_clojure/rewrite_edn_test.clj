(ns teodorlu.learn-clojure.rewrite-edn-test
  (:require
   [borkdude.rewrite-edn :as r]
   [clojure.test :refer [deftest is testing]]))

(deftest a
  (testing "parsing well formed EDN works"
    (is (r/parse-string "{:deps {}}")))
  (testing "parsing ill-formed EDN throws"
    (is (thrown? clojure.lang.ExceptionInfo (r/parse-string "{:deps {}")))))
