(ns ellipse-recognition.individual)

(def individual-bit-encoding {:a     [0 4]
                              :b     [5 9]
                              :x0    [10 15]
                              :y0    [16 21]
                              :alpha [22 28]})
(defn get-individual-size []
  (inc (last (last (vals individual-bit-encoding)))))
