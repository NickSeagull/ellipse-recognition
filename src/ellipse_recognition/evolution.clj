(ns ellipse-recognition.evolution
  (:require [ellipse-recognition.evaluation :refer :all]
            [ellipse-recognition.selection :refer :all]
            [ellipse-recognition.initialization :refer :all]
            [ellipse-recognition.mutation :refer :all]))

(defn- combine [population-a population-b]
  (vec (concat population-a population-b)))

(defn- truncate [population scores percentage elite-size]
  (drop elite-size (select-by-truncation percentage population scores)))

(defn- get-old-individuals [population scores truncation-percent elite-size]
  (combine
   (select-by-elitism elite-size population scores)
   (truncate population scores truncation-percent elite-size)))

(defn- get-size-difference [a b]
  (- (count a) (count b)))

(defn- generate-new-population [current-population scores truncate-percent elite-size]
  (let [old-individuals (get-old-individuals current-population scores truncate-percent elite-size)]
    (combine
     old-individuals
     (initialize-population-with-size (get-size-difference current-population old-individuals)))))

(defn evolve
  [population image-matrix elite-size truncate-percent mutation-probability generations-number]
  (loop [remaining-generations generations-number
         current-population population]
    (if-not (zero? remaining-generations)
        (let [scores (evaluate current-population image-matrix)]
          (recur
            (dec remaining-generations)
            (mutate
              (generate-new-population current-population scores truncate-percent elite-size)
              mutation-probability)))
      current-population)))
