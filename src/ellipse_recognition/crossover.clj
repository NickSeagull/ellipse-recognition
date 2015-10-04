(ns ellipse-recognition.crossover)

(defn- two-point-crossover-individuals [a b first-point second-point]
  (vec (concat
        (->> a (take first-point))
        (->> b (drop first-point) (take second-point))
        (->> a (drop second-point)))))

(defn- two-point-crossover-pair [[first-individual second-individual]]
  (let [first-point (rand-int (count first-individual))
        second-point (+ first-point (rand-int (- (count first-individual) first-point)))]
    [(two-point-crossover-individuals first-individual second-individual first-point second-point)
     (two-point-crossover-individuals second-individual first-individual first-point second-point)]))

(defn two-point-crossover [individuals]
  (mapcat two-point-crossover-pair (partition 2 individuals)))
