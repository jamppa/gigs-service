(ns gigs-service.system
  (:require
    [com.stuartsierra.component :as component]
    [gigs-service.api.http-server :refer [new-http-server]]
    [gigs-service.application.project-usecases :refer [new-project-usecases]]))

(def system
  (component/system-map
    :project-usecases (new-project-usecases)
    :http-server (component/using
                   (new-http-server) [:project-usecases])))

(defn start-system
  []
  (component/start system))
