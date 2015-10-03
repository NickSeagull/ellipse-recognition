(defproject ellipse-recognition "indev"
  :description "Learning Genetic Algorithms"
  :url "http://github.com/NickSeagull/ellipse-recognition"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC2"]
                 [net.mikera/core.matrix "0.41.0"]
                 [net.mikera/imagez "0.8.0"]
                 [net.mikera/vectorz-clj "0.35.0"]
                 [net.mikera/image-matrix "0.1.0"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"]]
  :test-paths ["spec"])
