(defproject gigs-service "0.1.0-SNAPSHOT"
  :description "Gigs Service"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [yada "1.2.15"]
                 [aleph "0.4.6"]
                 [bidi "2.1.4"]
                 [com.stuartsierra/component "0.3.2"]]
  :main ^:skip-aot gigs-service.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
