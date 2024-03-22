package me.tanjawaldis.tanjaimmobilienverwaltung

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Immobilie
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Mieter
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Utility

class ImmobilienApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(ImmobilienApplication::class.java.getResource("/me/tanjawaldis/tanjaimmobilienverwaltung/main.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = "Immobilienverwaltung!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Utility.immobilien.add(Immobilie(1, "test str 1", "testStadt"))
    Utility.immobilien.add(Immobilie(2, "test str 1", "testStadt"))
    Utility.mieter.add(Mieter(1, "Tanja Waldis", "test str 1", 36644, "testStadt", "email@test.de", "123434623454", true, 100, 89))
    Application.launch(ImmobilienApplication::class.java)
}
