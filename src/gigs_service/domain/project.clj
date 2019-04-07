(ns gigs-service.domain.project
  (:import (java.util UUID)))

(defrecord HoursEntry [date hours description])
(defrecord Project [id name entries])

(defprotocol ProjectRepository
  (save! [this ^Project project]))

(defn build-new [name]
  {:pre [(string? name)]}
  (map->Project {:id    (.toString (UUID/randomUUID))
                 :name  name
                 :entries []}))