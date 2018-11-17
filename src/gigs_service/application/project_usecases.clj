(ns gigs-service.application.project-usecases)

(defprotocol CreateNewProject
  (create-new! [this input]))

(defprotocol AddNewHoursEntry
  (add-hours! [this input]))

(defrecord ProjectUseCases []
  CreateNewProject
  (create-new! [this input]
    {:not-implemented true})

  AddNewHoursEntry
  (add-hours! [this input]
    {:not-implemented true}))
