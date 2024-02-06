package me.tanjawaldis.tanjaimmobilienverwaltung.model

import javafx.collections.FXCollections
import javafx.collections.ObservableList

object Utility {

    var immobilien: ObservableList<Immobilie> = FXCollections.observableArrayList()
    var mieter: ObservableList<Mieter> = FXCollections.observableArrayList()
}
