(ns gigs-service.domain.project
  (:import (java.util UUID)))

(defrecord HoursEntry [date hours description])
(defrecord Project [id name hours])

(defprotocol ProjectRepository
  (save! [this ^Project project]))

(defn create-project [name]
  {:pre [(string? name)]}
  (map->Project {:id    (.toString (UUID/randomUUID))
                 :name  name
                 :hours []}))