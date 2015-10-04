(ns ellipse-recognition.selection)

(defn- sort-population [population scores]
  (vec (keys (sort-by last (zipmap population scores)))))

(defn select-by-elitism [selection-size population scores]
  (subvec (sort-population population scores) 0 selection-size))
