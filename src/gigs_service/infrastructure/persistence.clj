(ns gigs-service.infrastructure.persistence
  (:require
    [com.stuartsierra.component :as component]
    [monger.core :as monger]
    [monger.core :as mg]))

(defrecord MongoDB [config]
  component/Lifecycle

  (start [component]
    (println "Starting MongoDB...")
    (let [url (get-in config [:db :url])
          {:keys [conn db]} (monger/connect-via-uri url)]
      (assoc component :conn conn :db db)))

  (stop [component]
    (println "Stopping MongoDB...")
    (mg/disconnect (:conn component))
    (dissoc component :conn :db)))

(defn new-database []
  (MongoDB. nil))
