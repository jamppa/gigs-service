(ns gigs-service.core
  (:require
    [gigs-service.system :as gigs-system]
    [environ.core :refer [env]])
  (:gen-class))

(def config
  {:db {:url (env :db-url)}})

(defn -main
  []
  (println "Starting Gigs Service...")
  (gigs-system/start-system config))
