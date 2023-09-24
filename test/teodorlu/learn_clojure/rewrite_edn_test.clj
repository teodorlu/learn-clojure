(ns teodorlu.learn-clojure.rewrite-edn-test
  (:require
   [borkdude.rewrite-edn :as r]
   [clojure.edn :as edn]
   [clojure.test :refer [deftest is testing]]))

(deftest a
  (testing "parsing well formed EDN works"
    (is (r/parse-string "{:deps {}}")))
  (testing "parsing ill-formed EDN throws"
    (is (thrown? clojure.lang.ExceptionInfo (r/parse-string "{:deps {}")))))

(deftest b
  (let [my-deps (-> (r/parse-string "{}")
                    (r/assoc-in [:deps 'borkdude/rewrite-edn] {:mvn/version "0.4.7"}))]
    (is my-deps)
    (is (contains? (edn/read-string (str my-deps))
                   :deps))))

(deftest c
  (testing "rewrite-EDN supports roundtrips and keeps whitespace"
    (let [deps-str "
{:deps
 {hiccup {:mvn/version \"1.0.4\"}}}
"]
      (is (= deps-str
             (-> deps-str r/parse-string str))))))
