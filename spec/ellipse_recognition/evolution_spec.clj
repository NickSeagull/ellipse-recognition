(ns ellipse-recognition.evolution-spec
  (:require [speclj.core :refer :all]
            [ellipse-recognition.utility :refer :all]
            [ellipse-recognition.initialization :refer :all]
            [ellipse-recognition.evolution :refer :all]))

(describe "evolution"
          (it "applies all the operators with the parameters passed to it"
              (let [image-name "resources/coins.jpg"
                    image-matrix (load-image-as-binary-matrix image-name 0.5)
                    elite-size 2
                    truncate-percent 64
                    population-size 10
                    population (initialize-population-with-size population-size)
                    mutation-probability 0.1
                    generations-number 2]
                (should= (count
                          (evolve population
                                  image-matrix
                                  elite-size
                                  truncate-percent
                                  mutation-probability
                                  generations-number))
                         population-size))))
