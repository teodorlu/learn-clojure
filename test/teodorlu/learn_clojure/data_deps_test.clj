(ns teodorlu.learn-clojure.data-deps-test)

;; how do we model data dependencies in Clojure?
;;
;; here's a take:

[{:provide ::x
  :const 10}
 {:provide ::y
  :const 20}
 {:require #{::x ::y}
  :provide ::z
  :fn (fn [m]
        (+ (::x m)
           (::y m)))}]

;; now, write an interpreter?
;; needs to topsort the statements befire starting.
;; (assuming I don't want to model each step manually)
