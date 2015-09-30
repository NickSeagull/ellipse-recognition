(ns ellipse-recognition.core-spec
  (:require [speclj.core :refer :all]
            [ellipse-recognition.initialization :refer :all]))

(describe "initialization"

  (it "should give a population the maximum value of 1"
      (let [population (initialize-population-with-size 100)]
        (should=
         (apply max (flatten population))
         1)))

  )
