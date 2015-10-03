(ns ellipse-recognition.utility
  (:require [mikera.image.core :as image-core]
            [clojure.core.matrix :refer :all]
            [mikera.image-matrix :refer :all]))

(defn- genes->strings [genes]
  (map #(clojure.string/join "" %) genes))

(defn decode-genes [genes-list]
  (map #(Integer/parseInt % 2) (genes->strings genes-list)))

(defn- flatten-value [threshold value]
  (if (> value threshold) 1 0))

(defn- apply-threshold [image-matrix threshold]
  (map (partial flatten-value threshold) image-matrix))

(defn- color->grayscale [image-matrix]
  (map #(/ (reduce + %) 3) image-matrix))

(defn- drop-alpha-channel [image-matrix]
  (map (partial take 3) image-matrix))

(defn- load-image-as-matrix [image-path]
  (coerce [] (image-core/load-image image-path)))

(defn load-image-as-binary-matrix [image-path threshold]
  (-> image-path
    (load-image-as-matrix)
    (drop-alpha-channel)
    (color->grayscale)
    (apply-threshold threshold)))
