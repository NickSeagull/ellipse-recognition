(ns ellipse-recognition.selection)

(defn- sort-population [population scores]
  (vec (keys (sort-by val > (zipmap population scores)))))

(defn get-best [population scores]
  (first (sort-by val > (zipmap population scores))))

(defn select-by-elitism [selection-size population scores]
  (subvec (sort-population population scores) 0 selection-size))

(defn- get-size-by-percentage [percentage population]
  (int (* (count population) (/ percentage 100))))

(defn select-by-truncation [selection-percentage population scores]
  (select-by-elitism
   (get-size-by-percentage selection-percentage population)
   population
   scores))
