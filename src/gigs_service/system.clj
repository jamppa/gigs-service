(ns gigs-service.system
  (:require
    [com.stuartsierra.component :as component]
    [gigs-service.api.http-server :refer [new-http-server]]
    [gigs-service.application.project-usecases :refer [new-project-usecases]]
    [gigs-service.infrastructure.persistence :refer [new-database]]))

(defn new-system [config]
  (component/system-map
    :config config
    :database (component/using (new-database) [:config])
    :project-usecases (new-project-usecases)
    :http-server (component/using (new-http-server) [:project-usecases])))

(defn start-system [config]
  (component/start (new-system config)))
