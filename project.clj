(defproject gigs-service "0.1.0-SNAPSHOT"
  :description "Gigs Service"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [yada "1.2.15"]
                 [aleph "0.4.6"]
                 [bidi "2.1.4"]
                 [com.stuartsierra/component "0.3.2"]
                 [com.novemberain/monger "3.1.0"]
                 [environ "1.1.0"]]
  :plugins [[lein-environ "1.1.0"]]
  :main ^:skip-aot gigs-service.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev [:project/dev :profiles/dev]
             :test [:project/test :profiles/test]
             :profiles/dev {}
             :profiles/test {}
             :project/dev {}
             :project/test {}})
