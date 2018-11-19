(ns gigs-service.api.health-api
  (:require [yada.yada :refer [resource]]))

(def ^:private health-resource
  (resource
    {:produces {:media-type "text/plain"}
     :methods {:get {:response "OK\n"}}}))

(defn create []
  ["/health" health-resource])