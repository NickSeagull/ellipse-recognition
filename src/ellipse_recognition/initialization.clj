(ns ellipse-recognition.initialization
  (:require [ellipse-recognition.individual :refer :all]))

(defn- make-random-individual []
  (take (get-individual-size) (repeatedly #(rand-int 2))))

(defn initialize-population-with-size [size]
  "Gives a random population based on the encoding
  at the individual-bit-encoding map"
  (take size (repeatedly #(make-random-individual))))
