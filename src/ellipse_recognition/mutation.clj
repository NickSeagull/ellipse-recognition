(ns ellipse-recognition.mutation)

(defn- flip-bit [bit-number individual]
  (Math/abs (- (individual bit-number) 1)))

(defn- bit-string-mutate-individual [population-size individual]
  (if (< (rand) (/ 1 population-size))
    (flip-bit (rand-int (count individual)) individual)))

(defn- mutate-individual [probability individual]
  (if (< (rand) probability)
    (flip-bit (rand-int (count individual)) individual)))

(defn bit-string-mutate [population]
  (map (partial mutate-individual (/ 1 (count population))) population))

(defn mutate [population probability]
  (map (partial mutate-individual probability) population))
