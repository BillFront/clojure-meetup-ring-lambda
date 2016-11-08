(defproject coolest-animal-ring-lambda "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [digest "1.4.5"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler coolest-animal-ring-lambda.core/handler}
  :main ^:skip-aot coolest-animal-ring-lambda.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
