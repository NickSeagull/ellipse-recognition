(ns ellipse-recognition.image-encoding
  (:require [mikera.image.core :as image-core]
            [clojure.core.matrix :refer :all]
            [mikera.image-matrix :refer :all]
            [ellipse-recognition.evaluation :refer :all]))

(defn- paint-red-point! [img [x y]]
  (if (and (< 0 x (.getWidth img)) (< 0 y (.getHeight img)))
    (.setRGB img x y (unchecked-int 0xFF00FFFF))))

(defn draw-encoded-ellipse-on-image [image-path individual]
  (let [ellipse (build-ellipse-from individual)
        img (image-core/load-image image-path)]
    (do
      (doseq [point ellipse] (paint-red-point! img point))
      (image-core/scale-image img 300 300))))
