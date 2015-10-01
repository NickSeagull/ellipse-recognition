(ns ellipse-recognition.individual)

(def individual-bit-encoding {:a     5
                              :b     5
                              :x0    6
                              :y0    6
                              :alpha 7})

(defn get-individual-size []
  (reduce + (vals individual-bit-encoding)))
