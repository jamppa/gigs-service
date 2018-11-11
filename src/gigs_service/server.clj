(ns gigs-service.server
  (:require
    [com.stuartsierra.component :as component]
    [yada.yada :refer [listener]]
    [gigs-service.api.health :as health-api]))

(defrecord ServerComponent []
  component/Lifecycle

  (start [component]
    (println "Starting HTTP server....")
    (assoc component :server
                     (listener ["/api" [health-api/api]] {:port 3000})))

  (stop [component]
    (println "Stopping HTTP server...")
    (-> (:server component)
        (:close))
    (assoc component :server nil)))

(defn new-server-component
  []
  (ServerComponent.))
