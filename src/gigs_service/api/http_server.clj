(ns gigs-service.api.http-server
  (:require
    [com.stuartsierra.component :as component]
    [yada.yada :refer [listener]]
    [gigs-service.api.health-api :as health-api]
    [gigs-service.api.project-api :as project-api]))

(defrecord HttpServerComponent [project-usecases]
  component/Lifecycle

  (start [component]
    (println "Starting HTTP API....")
    (assoc component :server
                     (listener
                       ["/api"
                        [
                         (health-api/create)
                         (project-api/create project-usecases)
                         ]
                        ]
                       {:port 3000})))

  (stop [component]
    (println "Stopping HTTP API...")
    (-> (:server component)
        (:close))
    (assoc component :server nil)))

(defn new-http-server
  []
  (HttpServerComponent. nil))
