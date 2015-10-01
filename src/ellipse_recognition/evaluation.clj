(ns ellipse-recognition.evaluation
  (:require [ellipse-recognition.individual :refer :all]))

(defn- destructure-individual [individual])

(defn- build-ellipse-from [individual]
  (let [[a b x0 y0 alpha] (destructure-individual individual)]))

(defn- get-matching-ratio-between [image ellipse]
  (/ (reduce + (match-points image ellipse)) (count ellipse)))

(defn- evaluate-individual [individual image]
  (get-matching-ratio-between image (build-ellipse-from individual)))

(defn evaluate [population image]
  (map evaluate-individual population))
