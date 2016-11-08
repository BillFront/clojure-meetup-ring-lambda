(ns coolest-animal-ring-lambda.core
  (:require [digest :refer [md5]])
  (:gen-class))

(defn- cool-factor [animal] (->> animal
                                 md5
                                 char-array
                                 (map int)
                                 (reduce +)))

(defn- coolest [animals] (->> animals
                              (sort-by cool-factor)
                              last))

(defn handler [request]
  (let [body (-> request :body slurp)
        animals (clojure.string/split body #",")]
    {:body (coolest animals)}))
