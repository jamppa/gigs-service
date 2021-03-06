(ns gigs-service.application.project-usecases
  (:require [gigs-service.domain.project :as project])
  (:import (gigs_service.domain.project Project)))

(defn- project-output [^Project project]
  {:project-id (:id project)})

(defprotocol CreateNewProject
  (create-new! [this input]))

(defrecord ProjectUseCases [repository]
  CreateNewProject

  (create-new! [_ {:keys [name]}]
    (let [new-project (project/build-new name)]
      ;(project/save-project! new-project project-repository) TODO: implement repo
      (project-output new-project))))

(defn new-project-usecases []
  (ProjectUseCases. nil))
