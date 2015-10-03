(ns ellipse-recognition.evaluation-spec
  (:require [speclj.core :refer :all]
            [ellipse-recognition.evaluation :refer :all]
            [ellipse-recognition.initialization :refer :all]
            [ellipse-recognition.utility :refer :all]))

(describe "evaluation"
          (it "returns a list of how good the chromosomes in a population are"
              (let [population (initialize-population-with-size 10)]
                (should=
                 (count (evaluate
                         population
                         (load-image-as-binary-matrix "resources/coins.jpg" 0.5)))
                 10))))
