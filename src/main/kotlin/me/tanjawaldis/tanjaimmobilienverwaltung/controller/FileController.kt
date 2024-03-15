package me.tanjawaldis.tanjaimmobilienverwaltung.controller

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javafx.collections.FXCollections
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Immobilie
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Mieter
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Utility
import java.io.File

object FileController {


    fun saveToFile() {
        //create a file called mieter.txt in the current directory of the jar file
        val mieterPath = "mieter.txt"
        val immobilienPath = "immobilien.txt"

        //create a new file
        val fileMieter = File(mieterPath)
        val fileImmobilien = File(immobilienPath)
        //if the file does not exist create it
        if (!fileMieter.exists()) {
            fileMieter.createNewFile()
        }

        if (!fileImmobilien.exists()) {
            fileImmobilien.createNewFile()
        }
        //write the mieter to the file
        val mieter = Utility.mieter
        val immobilien = Utility.immobilien

        //parse the mieter to a json object using gson
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonMieter = gson.toJson(mieter)
        val jsonImmobilien = gson.toJson(immobilien)
        //write the json to the file
        fileMieter.writeText(jsonMieter)
        fileImmobilien.writeText(jsonImmobilien)

        val alert = Alert(AlertType.INFORMATION)
        alert.title = "Information Dialog"
        alert.headerText = "Speichern erfolgreich"
        alert.contentText = "Die Daten wurden erfolgreich gespeichert"
        alert.showAndWait()

    }

    fun loadFromFile() {
        //create a file called mieter.txt in the current directory of the jar file
        val mieterPath = "mieter.txt"
        val immobilienPath = "immobilien.txt"
        //create a new file
        val fileMieter = File(mieterPath)
        val fileImmobilien = File(immobilienPath)
        //if the file does not exist create it
        if (!fileMieter.exists()) {
            fileMieter.createNewFile()
        }

        if (!fileImmobilien.exists()) {
            fileImmobilien.createNewFile()
        }
        //read the json from the file
        val jsonMieter = fileMieter.readText()
        val jsonImmobilien = fileImmobilien.readText()

        //parse the json to a list of mieter using gson
        val gson = Gson()
        val mieter = gson.fromJson(jsonMieter, Array<Mieter>::class.java).toList()
        val immobilien = gson.fromJson(jsonImmobilien, Array<Immobilie>::class.java).toList()
        //set the mieter in the utility class
        Utility.mieter = FXCollections.observableArrayList(mieter)
        Utility.immobilien = FXCollections.observableArrayList(immobilien)

        val alert = Alert(AlertType.INFORMATION)
        alert.title = "Information Dialog"
        alert.headerText = "Laden erfolgreich"
        alert.contentText = "Die Daten wurden erfolgreich geladen"
        alert.showAndWait()


    }
}
