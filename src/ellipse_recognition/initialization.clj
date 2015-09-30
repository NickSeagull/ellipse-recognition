(ns ellipse-recognition.initialization)

(def individual-bit-encoding {:a     5
                              :b     5
                              :x0    6
                              :y0    6
                              :alpha 7})

(def individual-size (reduce + (vals individual-bit-encoding)))

(defn- make-random-individual []
  (take individual-size (repeatedly #(rand-int 2))))

(defn initialize-population-with-size [size]
  "Gives a random population based on the encoding
  at the individual-bit-encoding map"
  (take size (repeatedly #(make-random-individual))))
