(ns gigs-service.domain.project)

(defrecord HoursEntry [date hours description])
(defrecord Project [id name hours])

(defprotocol ProjectRepository
  (save! [this ^Project project]))

(defn create-project [name]
  {:pre [(string? name)]}
  (map->Project {:id (.toString (java.util.UUID/randomUUID))
                 :name name
                 :hours []}))