(ns ellipse-recognition.evaluation-spec
  (:require [speclj.core :refer :all]
            [ellipse-recognition.evaluation :refer :all]))

(describe "evaluation"
          (it "returns a list of how good the chromosomes in a population are"
              (let [population (initialize-population-with-size 10)]
                (should=
                 (count (evaluate population))
                 10))))
