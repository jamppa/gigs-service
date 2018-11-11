(ns gigs-service.core
  (:require
    [yada.yada :refer [listener]]
    [gigs-service.api.health :as health-api])
  (:gen-class))

(defn -main
  []
  (println "Starting service...")
  (listener ["/api" [health-api/api]] {:port 3000}))
