(ns gigs-service.api.health
  (:require [yada.yada :refer [resource]]))

(def ^:private health-resource
  (resource
    {:produces {:media-type "text/plain"}
     :methods {:get {:response "OK\n"}}}))

(def api ["/health" health-resource])