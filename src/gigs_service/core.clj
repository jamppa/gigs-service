(ns gigs-service.core
  (:require
    [gigs-service.system :as gigs-system])
  (:gen-class))

(defn start []
  (gigs-system/start-system (gigs-system/new-system)))

(defn -main
  []
  (println "Starting Gigs Service...")
  (start))