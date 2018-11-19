(ns gigs-service.api.project-api
  (:require
    [yada.yada :refer [resource]]
    [gigs-service.application.project-usecases :as project]))

(defn- create-project-resources [project-usecases]
  (resource
    {:produces {:media-type "application/json"}
     :methods {:post {:response (fn [_] (project/create-new! project-usecases {}))}}}))

(defn create [project-usecases]
  ["/project" (create-project-resources project-usecases)])
