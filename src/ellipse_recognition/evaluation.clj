(ns ellipse-recognition.evaluation
  (:require [ellipse-recognition.individual :refer :all]
            [ellipse-recognition.utility :refer :all]))

(defn- get-slice [individual slice]
  (subvec (first slice) (inc (second slice))))

(defn- destructure-individual [individual]
  (map (partial get-slice individual) individual-bit-encoding))

(defn- two-pi []
  (* 2 Math/PI))

(defn- rotated-ellipse-y [a b x0 y0 alpha theta]
  (+
   (*
    (+
     (* a (Math/cos alpha))
     x0)
    (Math/sin theta))
   (*
    (+
     (* b (Math/sin alpha))
     y0)
    (Math/sin theta))))

(defn- rotated-ellipse-x [a b x0 y0 alpha theta]
  (+
   (*
    (+
     (* a (Math/cos alpha))
     x0)
    (Math/cos theta))
   (*
    (+
     (* b (Math/sin alpha))
     y0)
    (Math/sin theta))))

(defn- make-rotated-ellipse [a b x0 y0 alpha theta]
  [(rotated-ellipse-x a b x0 y0 alpha theta)
   (rotated-ellipse-y a b x0 y0 alpha theta)])

(defn- decode-angle [angle]
  (Math/toRadians (* (/ angle 127) 90)))

(defn- build-ellipse-from [individual]
  (let [[a b x0 y0 a] (decode-genes (destructure-individual individual))
        alpha (decode-angle a)]
    (map (partial make-rotated-ellipse a b x0 y0 alpha)
         (range 1/5 (two-pi) 1/5))))

(defn- match-with-point [image [point-x point-y]]
  (if-not (and (> point-x (count (image 0))) (> point-y (count image)))
    ((image point-y) point-x)
    0))

(defn- get-matching-points [image ellipse]
  (reduce + (map (partial match-with-point image) ellipse)))

(defn- get-matching-ratio-between [image ellipse]
  (/ (get-matching-points image ellipse) (count ellipse)))

(defn- evaluate-individual [individual image]
  (get-matching-ratio-between image (build-ellipse-from individual)))

(defn evaluate [population image]
  (map evaluate-individual population image))
