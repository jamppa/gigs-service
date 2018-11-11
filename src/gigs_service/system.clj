(ns gigs-service.system
  (:require
    [com.stuartsierra.component :as component]
    [gigs-service.server :refer [new-server-component]]))

(def system
  (component/system-map
    :server (new-server-component)))

(defn start-system
  []
  (component/start system))
