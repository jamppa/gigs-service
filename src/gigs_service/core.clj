(ns gigs-service.core
  (:require [gigs-service.system :as gigs-system])
  (:gen-class))

(defn -main
  []
  (println "Starting Gigs Service...")
  (gigs-system/start-system))
