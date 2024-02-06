package me.tanjawaldis.tanjaimmobilienverwaltung

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

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
    Application.launch(ImmobilienApplication::class.java)
}
