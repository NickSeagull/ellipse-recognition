(ns ellipse-recognition.core
  (:require [ellipse-recognition.initialization :refer :all]
            [ellipse-recognition.utility :refer :all]
            [ellipse-recognition.evolution :refer :all]
            [ellipse-recognition.evaluation :refer :all]
            [ellipse-recognition.selection :refer :all]
            [ellipse-recognition.image-encoding :refer :all]
            [mikera.image.core :as image-core]))

(def image-path "resources/coins.jpg")
(def threshold 0.2)
(def image-matrix (load-image-as-binary-matrix image-path threshold))
(def elite-size 1)
(def truncate-percent 64)
(def population-size 100)
(def mutation-probability (/ 1 population-size))
(def number-of-generations 50)

(def evolved-population
  (evolve
   (initialize-population-with-size population-size)
   image-matrix
   elite-size
   truncate-percent
   mutation-probability
   number-of-generations))

(defn -main [& args]
  (let [scores (evaluate evolved-population image-matrix)
        [best]   (select-by-elitism 1 evolved-population scores)
        result-image (draw-encoded-ellipse-on-image image-path best)]
    (println "End of evolution...")
    (image-core/show result-image)))
