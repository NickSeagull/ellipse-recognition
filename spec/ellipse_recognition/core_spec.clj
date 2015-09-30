(ns ellipse-recognition.core-spec
  (:require [speclj.core :refer :all]
            [ellipse-recognition.initialization :refer :all]))

(describe "initialization"

  (it "should give a population the maximum value of 1"
      (let [population (initialize-population-with-size 100)]
        (should=
         (apply max (flatten population))
         1)))

  (it "should give a population the minimum value of 0"
      (let [population (initialize-population-with-size 100)]
        (should=
         (apply min (flatten population))
         0))))
