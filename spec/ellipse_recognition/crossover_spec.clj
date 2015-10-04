(ns ellipse-recognition.crossover-spec
  (:require [speclj.core :refer :all]
            [ellipse-recognition.crossover :refer :all]
            [ellipse-recognition.selection :refer :all]
            [ellipse-recognition.initialization :refer :all]
            [ellipse-recognition.utility :refer :all]
            [ellipse-recognition.evaluation :refer :all]))

(describe "crossover"
          (it "should apply 'two-point crossover' to some individuals"
              (let [population (initialize-population-with-size 10)
                    image-matrix (load-image-as-binary-matrix "resources/coins.jpg" 0.5)
                    scores (evaluate population image-matrix)
                    best (select-by-truncation 20 population scores)]
                (should=
                 (count (two-point-crossover best))
                 (count best)))))
