(ns ellipse-recognition.selection-spec
  (:require [ellipse-recognition.selection :refer :all]
            [ellipse-recognition.initialization :refer :all]
            [ellipse-recognition.evaluation :refer :all]
            [ellipse-recognition.utility :refer :all]
            [speclj.core :refer :all]))

(describe "selection"
          (it "can select by elitist selection"
              (let [population   (initialize-population-with-size 10)
                    image-matrix (load-image-as-binary-matrix "resources/coins.jpg" 0.5)
                    scores       (evaluate population image-matrix)]
                (should=
                 (count (select-by-elitism 2 population scores))
                 2)))
          (it "can also select by truncation"
              (let [population   (initialize-population-with-size 10)
                    image-matrix (load-image-as-binary-matrix "resources/coins.jpg" 0.5)
                    scores       (evaluate population image-matrix)]
                (should=
                 (count (select-by-truncation 20 population scores))
                 2))))
