(ns coolest-animal-ring-lambda.core
  (:require [digest :refer [md5]]
            [uswitch.lambada.core :refer [deflambdafn]]
            [clojure.data.json :as json]
            [clojure.java.io :as io])
  (:gen-class))

(defn- cool-factor [animal] (->> animal
                                 md5
                                 char-array
                                 (map int)
                                 (reduce +)))

(defn- coolest [animals] (->> animals
                              (sort-by cool-factor)
                              last))

(deflambdafn coolest-animal-ring-lambda.core.HandlerFn [in out ctx]
  (let [animals (-> in
                    io/reader
                    json/read
                    (clojure.string/split #","))]
    (with-open [w (io/writer out)] (json/write (coolest animals) w))))
