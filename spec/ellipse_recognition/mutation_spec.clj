(ns ellipse-recognition.mutation-spec
  (:require [speclj.core :refer :all]
            [ellipse-recognition.mutation :refer :all]))

(describe "mutation"
          (it "makes a bit-string mutation"
              (let [population [[1 1 0] [0 0 1] [1 1 1] [0 0 0]]]
                (should= (count (bit-string-mutate population))
                         (count population))))
          (it "also mutates with an assigned probability"
              (let [population [[1 1 0] [0 0 1] [1 1 1] [0 0 0]]]
                (should= (count (mutate population 0.5))
                         (count population)))))
