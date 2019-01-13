(ns gigs-service.system
  (:require
    [com.stuartsierra.component :as component]
    [gigs-service.api.http-server :refer [new-http-server]]
    [gigs-service.application.project-usecases :refer [new-project-usecases]]
    [gigs-service.infrastructure.persistence :refer [new-database]]
    [environ.core :refer [env]]))

(def config
  {:db {:url (env :db-url)}})

(defn new-system []
  (component/system-map
    :config config
    :database (component/using (new-database) [:config])
    :project-usecases (new-project-usecases)
    :http-server (component/using (new-http-server) [:project-usecases])))

(defn start-system [system]
  (component/start system))

(defn stop-stystem [system]
  (component/stop system))