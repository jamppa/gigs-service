(ns gigs-service.application.project-usecases)

(defprotocol CreateNewProject
  (create-new! [this input]))

(defprotocol AddNewHoursEntry
  (add-hours! [this input]))

(defrecord ProjectUseCases []

  CreateNewProject
  (create-new! [this input]
    {:usecase-not-implemented true})

  AddNewHoursEntry
  (add-hours! [this input]
    {:usecase-not-implemented true}))

(defn new-project-usecases []
  (ProjectUseCases.))
