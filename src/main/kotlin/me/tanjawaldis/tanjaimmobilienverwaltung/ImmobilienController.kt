package me.tanjawaldis.tanjaimmobilienverwaltung

import java.net.URL
import java.util.ResourceBundle
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TreeView

class ImmobilienController {

    @FXML
    private lateinit var resources: ResourceBundle

    @FXML
    private lateinit var location: URL

    @FXML
    private lateinit var add: Button

    @FXML
    private lateinit var anlegen: Button

    @FXML
    private lateinit var brutto: TableColumn<Any, Any>

    @FXML
    private lateinit var email: TableColumn<Any, Any>

    @FXML
    private lateinit var id: TableColumn<Any, Any>

    @FXML
    private lateinit var name: TableColumn<Any, Any>

    @FXML
    private lateinit var nebenkosten: TableColumn<Any, Any>

    @FXML
    private lateinit var netto: TableColumn<Any, Any>

    @FXML
    private lateinit var ort: TableColumn<Any, Any>

    @FXML
    private lateinit var parkplatz: TableColumn<Any, Any>

    @FXML
    private lateinit var search: Button

    @FXML
    private lateinit var straße: TableColumn<Any, Any>

    @FXML
    private lateinit var straßeplz1: TableColumn<Any, Any>

    @FXML
    private lateinit var tableview: TableView<Any>

    @FXML
    private lateinit var telefon: TableColumn<Any, Any>

    @FXML
    private lateinit var treeview: TreeView<Any>

    @FXML
    fun initialize() {
        assert(add != null) {"fx:id=\"add\" was not injected: check your FXML file 'main.fxml'." }
        assert(anlegen != null) {"fx:id=\"anlegen\" was not injected: check your FXML file 'main.fxml'." }
        assert(brutto != null) {"fx:id=\"brutto\" was not injected: check your FXML file 'main.fxml'." }
        assert(email != null) {"fx:id=\"email\" was not injected: check your FXML file 'main.fxml'." }
        assert(id != null) {"fx:id=\"id\" was not injected: check your FXML file 'main.fxml'." }
        assert(name != null) {"fx:id=\"name\" was not injected: check your FXML file 'main.fxml'." }
        assert(nebenkosten != null) {"fx:id=\"nebenkosten\" was not injected: check your FXML file 'main.fxml'." }
        assert(netto != null) {"fx:id=\"netto\" was not injected: check your FXML file 'main.fxml'." }
        assert(ort != null) {"fx:id=\"ort\" was not injected: check your FXML file 'main.fxml'." }
        assert(parkplatz != null) {"fx:id=\"parkplatz\" was not injected: check your FXML file 'main.fxml'." }
        assert(search != null) {"fx:id=\"search\" was not injected: check your FXML file 'main.fxml'." }
        assert(straße != null) {"fx:id=\"straße\" was not injected: check your FXML file 'main.fxml'." }
        assert(straßeplz1 != null) {"fx:id=\"straßeplz1\" was not injected: check your FXML file 'main.fxml'." }
        assert(tableview != null) {"fx:id=\"tableview\" was not injected: check your FXML file 'main.fxml'." }
        assert(telefon != null) {"fx:id=\"telefon\" was not injected: check your FXML file 'main.fxml'." }
        assert(treeview != null) {"fx:id=\"treeview\" was not injected: check your FXML file 'main.fxml'." }

    }

}
