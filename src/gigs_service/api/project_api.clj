(ns gigs-service.api.project-api
  (:require
    [yada.yada :refer [resource]]
    [gigs-service.application.project-usecases :as usecases]))

(defn- create-project-resources [project-usecases]
  (resource
    {:produces {:media-type "application/json"}
     :methods {:post {:response (fn [_] (usecases/create-new! project-usecases {:name "test project 1"}))}}}))

(defn create [project-usecases]
  ["/project" (create-project-resources project-usecases)])
