(ns gigs-service.domain.project
  (:import (java.util UUID)))

(defrecord HoursEntry [date hours description])
(defrecord Project [id name hours])

(defprotocol ProjectRepository
  (save! [this ^Project project]))

(defn create-new [name]
  {:pre [(string? name)]}
  (map->Project {:id    (.toString (UUID/randomUUID))
                 :name  name
                 :hours []}))

(defn save-project! [^Project project repository]
  (save! repository project))