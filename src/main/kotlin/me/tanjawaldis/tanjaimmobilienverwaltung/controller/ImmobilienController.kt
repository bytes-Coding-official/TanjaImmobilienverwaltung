package me.tanjawaldis.tanjaimmobilienverwaltung.controller

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.control.cell.TextFieldTableCell
import javafx.util.converter.IntegerStringConverter
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Immobilie
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Mieter
import me.tanjawaldis.tanjaimmobilienverwaltung.model.Utility
import java.net.URL
import java.util.*

class ImmobilienController : Initializable {

    @FXML
    private lateinit var delete: Button

    @FXML
    private lateinit var deleteObject: Button

    @FXML
    private lateinit var add: Button

    @FXML
    private lateinit var anlegen: Button

    @FXML
    private lateinit var brutto: TableColumn<Mieter, Int>

    @FXML
    private lateinit var email: TableColumn<Mieter, String>

    @FXML
    private lateinit var id: TableColumn<Mieter, Int>

    @FXML
    private lateinit var name: TableColumn<Mieter, String>

    @FXML
    private lateinit var nebenkosten: TableColumn<Mieter, Int>

    @FXML
    private lateinit var netto: TableColumn<Mieter, Int>

    @FXML
    private lateinit var ort: TableColumn<Mieter, String>

    @FXML
    private lateinit var parkplatz: TableColumn<Mieter, Boolean>


    @FXML
    private lateinit var speichern: Button

    @FXML
    private lateinit var laden: Button

    @FXML
    private lateinit var search: Button

    @FXML
    private lateinit var straße: TableColumn<Mieter, String>

    @FXML
    private lateinit var plz: TableColumn<Mieter, Int>

    @FXML
    private lateinit var tableview: TableView<Mieter>

    @FXML
    private lateinit var telefon: TableColumn<Mieter, String>

    @FXML
    private lateinit var treeview: TreeView<String>

    @FXML
    fun addImmobilie(event: ActionEvent) {
        val selectedItem = treeview.selectionModel.selectedItem ?: return
        if (selectedItem.parent != null && selectedItem.parent.parent != null) {
            return
        }
        // Create a dialog to get the name of the new object from the user
        val dialog = TextInputDialog()
        dialog.title = "Neue Immobilie hinzufügen"
        dialog.headerText = "Geben Sie den Namen der neuen Immobilie ein"
        val result = dialog.showAndWait()
        // If the user entered a name, create a new TreeItem and add it to the selected item
        if (result.isPresent) {
            val newStraßeNummer = result.get()
            val newImmobilie = Immobilie(Utility.immobilien.size + 1, newStraßeNummer, selectedItem.value)
            Utility.immobilien.add(newImmobilie)
            selectedItem.children.add(TreeItem(newStraßeNummer))
        }
    }

    @FXML
    fun onLaden() {
        FileController.loadFromFile()
        updateTreeview()
    }

    @FXML
    fun onSpeichern() {
        FileController.saveToFile()
    }

    @FXML
    fun addMieter() {
        val selectedImmobilie = treeview.selectionModel.selectedItem ?: return
        if (selectedImmobilie.parent == null) return
        //get the ID of the immobilie
        val ort = selectedImmobilie.parent.value
        val straßeNummer = selectedImmobilie.value
        val immobilie = Utility.immobilien.find { it.straßeNummer == straßeNummer && it.ort == ort } ?: return

        val mieter = Mieter(immobilie.id, "Tanja Waldis", "test str 1", 1234, "testStadt", "test@test.de", "123434623454", true, 89, 50)
        tableview.items.add(mieter)
        Utility.mieter.add(mieter)
    }

    @FXML
    fun deleteImmobilie(event: ActionEvent) {
        val selectedItem = treeview.selectionModel.selectedItem ?: return

        //remove the selected item from the treeview
        selectedItem.parent.children.remove(selectedItem)

//remove it also from the Utility.immobilien based on if it is a street or a ort or a house
        if (selectedItem.isLeaf) {

            //if it has 2 parents its a house than remove it from the immobilien
            if (selectedItem.parent != null) {
                val ort = selectedItem.parent.value
                val straßeNummer = selectedItem.value
                val selectedImmobilie = Utility.immobilien.find { it.straßeNummer == straßeNummer && it.ort == ort } ?: return
                Utility.immobilien.removeAll(selectedImmobilie)

            }
        } else {
            //if it has no parent its a ort than remove all streets and houses from the immobilien
            val ort = selectedItem.value
            val selectedImmobilie = Utility.immobilien.filter { it.ort == ort }
            Utility.immobilien.removeAll(selectedImmobilie)
        }

    }

    @FXML
    fun deleteMieter() {
        val selectedItem = tableview.selectionModel.selectedItem ?: return
        tableview.items.remove(selectedItem)
        Utility.mieter.remove(selectedItem)
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {


        //create the valuefactories for the tableview
        id.cellValueFactory = PropertyValueFactory("idProperty")
        name.cellValueFactory = PropertyValueFactory("nameProperty")
        straße.cellValueFactory = PropertyValueFactory("straßeProperty")
        plz.cellValueFactory = PropertyValueFactory("plzProperty")
        ort.cellValueFactory = PropertyValueFactory("ortProperty")
        email.cellValueFactory = PropertyValueFactory("emailProperty")
        telefon.cellValueFactory = PropertyValueFactory("telefonProperty")
        parkplatz.cellValueFactory = PropertyValueFactory("parkplatzProperty")
        brutto.cellValueFactory = PropertyValueFactory("bruttoProperty")
        netto.cellValueFactory = PropertyValueFactory("nettoProperty")
        nebenkosten.cellValueFactory = PropertyValueFactory("nebenkostenProperty")


        id.cellFactory = TextFieldTableCell.forTableColumn(IntegerStringConverter())
        name.cellFactory = TextFieldTableCell.forTableColumn()
        straße.cellFactory = TextFieldTableCell.forTableColumn()
        ort.cellFactory = TextFieldTableCell.forTableColumn()
        email.cellFactory = TextFieldTableCell.forTableColumn()
        telefon.cellFactory = TextFieldTableCell.forTableColumn()
        brutto.cellFactory = TextFieldTableCell.forTableColumn(IntegerStringConverter())
        netto.cellFactory = TextFieldTableCell.forTableColumn(IntegerStringConverter())
        nebenkosten.cellFactory = TextFieldTableCell.forTableColumn(IntegerStringConverter())
        parkplatz.setCellFactory { CheckBoxTableCell() }

        id.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setIdProperty(event.newValue)
        }

        name.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setNameProperty(event.newValue)
        }

        straße.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setStraßeProperty(event.newValue)
        }

        plz.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setPlzProperty(event.newValue)
        }

        ort.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setOrtProperty(event.newValue)
        }

        email.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setEmailProperty(event.newValue)
        }

        telefon.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setTelefonProperty(event.newValue)
        }

        netto.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setNettoProperty(event.newValue)
            selectedMieter.getBruttoPropertyElement().addListener { _, _, _ -> updateTable() }
            updateTable()
        }

        nebenkosten.setOnEditCommit { event ->
            val selectedMieter = event.rowValue
            selectedMieter.setNebenkostenProperty(event.newValue)
            //update the brutto value in the ui
            selectedMieter.getBruttoPropertyElement().addListener { _, _, _ -> updateTable() }
            updateTable()
        }

        updateTreeview()
    }


    private fun updateTreeview() {
        val rootItem = TreeItem("Immobilien")
        rootItem.isExpanded = true
        treeview.root = rootItem

        //add the immobilien to the treeview
        //therefor filter the immobilien based on the ort and strasse
        //and add the immobilie to the treeview
        for (immobilie in Utility.immobilien) {
            //check if there is already a ortItem with the same name
            var ortItem = rootItem.children.find { it.value == immobilie.ort }
            if (ortItem == null) {
                ortItem = TreeItem(immobilie.ort)
                rootItem.children.add(ortItem)
            }
//check if there is already a straßeItem with the same name
            var straßeItem = ortItem.children.find { it.value == immobilie.straßeNummer }
            if (straßeItem == null) {
                straßeItem = TreeItem(immobilie.straßeNummer)
                ortItem.children.add(straßeItem)
            }
            //add the immobilie to the straßeItem

        }

        treeview.setOnMouseClicked { event ->
            if (event.clickCount == 2) {
                val selectedItem = treeview.selectionModel.selectedItem
                if (selectedItem.isLeaf && selectedItem.parent != null) {
                    val straßeNummer = selectedItem.value
                    val ort = selectedItem.parent.value
                    val selectedImmobilie = Utility.immobilien.find { it.straßeNummer == straßeNummer && it.ort == ort } ?: return@setOnMouseClicked
                    loadMieterForImmobilie(selectedImmobilie)
                }
            }

        }
    }

    private fun updateTable() {
        //copy current items
        val table = tableview.items.toList()
        tableview.items.clear()
        tableview.items.addAll(table)
    }

    private fun loadMieterForImmobilie(immobilie: Immobilie) {
        // Filter the list of all Mieter to only include those that belong to the selected Immobilie
        val mieterForImmobilie = Utility.mieter.filter { it.getIdProperty() == immobilie.id }
        // Update the TableView to display the Mieter for the selected Immobilie
        tableview.items = FXCollections.observableArrayList(mieterForImmobilie)

    }
}
