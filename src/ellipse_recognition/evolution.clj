(ns ellipse-recognition.evolution
  (:require [ellipse-recognition.evaluation :refer :all]
            [ellipse-recognition.selection :refer :all]
            [ellipse-recognition.initialization :refer :all]
            [ellipse-recognition.mutation :refer :all]))

(defn evolve
  [population image-matrix elite-size truncate-percent mutation-probability generations-number]
  (loop [remaining-generations generations-number
         current-population population
         scores (evaluate population image-matrix)]
    (if-not (zero? remaining-generations)
      (let [elite (select-by-elitism elite-size population scores)
            truncated (drop elite-size
                            (select-by-truncation
                             truncate-percent
                             population scores))
            old-individuals (vec (concat elite truncated))
            random-rest (initialize-population-with-size (- (count population) (count old-individuals)))
            new-population (vec (concat elite truncated random-rest))]
        (recur
          (dec remaining-generations)
          (mutate new-population mutation-probability)
          (evaluate new-population image-matrix)))
      current-population)))
