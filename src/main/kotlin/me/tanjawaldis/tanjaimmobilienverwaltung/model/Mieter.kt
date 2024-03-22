package me.tanjawaldis.tanjaimmobilienverwaltung.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty

data class Mieter(var id: Int, var name: String, var strasse: String, var plz: Int, var ort: String, var email: String, var telefon: String, var parkplatz: Boolean, var netto: Int, var nebenkosten: Int) {

    //initialize the properties 
    private var idProperty: SimpleIntegerProperty = SimpleIntegerProperty(id)

    private var nameProperty: SimpleStringProperty = SimpleStringProperty(name)

    private var strasseProperty: SimpleStringProperty = SimpleStringProperty(strasse)

    private var plzProperty: SimpleIntegerProperty = SimpleIntegerProperty(plz)

    private var ortProperty: SimpleStringProperty = SimpleStringProperty(ort)

    private var emailProperty: SimpleStringProperty = SimpleStringProperty(email)

    private var telefonProperty: SimpleStringProperty = SimpleStringProperty(telefon)

    private var parkplatzProperty: SimpleBooleanProperty = SimpleBooleanProperty(parkplatz)

    private var bruttoProperty: SimpleIntegerProperty = SimpleIntegerProperty(nebenkosten + netto)

    private var nettoProperty: SimpleIntegerProperty = SimpleIntegerProperty(netto)

    private var nebenkostenProperty: SimpleIntegerProperty = SimpleIntegerProperty(nebenkosten)


    init {
        nettoProperty.addListener { _, _, _ -> updateBrutto() }
        nebenkostenProperty.addListener { _, _, _ -> updateBrutto() }
    }


    private fun updateBrutto() {
        bruttoProperty.set(nettoProperty.get() + nebenkostenProperty.get())
    }

    //getter and setter for the properties
    fun getIdProperty(): Int {
        return idProperty.get()
    }

    fun getNameProperty(): String {
        return nameProperty.get()
    }

    fun getStraßeProperty(): String {
        return strasseProperty.get()
    }

    fun getPlzProperty(): Int {
        return plzProperty.get()
    }

    fun getOrtProperty(): String {
        return ortProperty.get()
    }

    fun getEmailProperty(): String {
        return emailProperty.get()
    }

    fun getTelefonProperty(): String {
        return telefonProperty.get()
    }

    fun getParkplatzProperty(): Boolean {
        return parkplatzProperty.get()
    }

    fun getBruttoProperty(): Int {
        return bruttoProperty.get()
    }

    fun getBruttoPropertyElement(): SimpleIntegerProperty {
        return bruttoProperty
    }

    fun getNettoProperty(): Int {
        return nettoProperty.get()
    }

    fun getNebenkostenProperty(): Int {
        return nebenkostenProperty.get()
    }

    fun setIdProperty(id: Int) {
        idProperty.set(id)
    }

    fun setNameProperty(name: String) {
        nameProperty.set(name)
    }

    fun setStraßeProperty(straße: String) {
        strasseProperty.set(straße)
    }

    fun setPlzProperty(plz: Int) {
        plzProperty.set(plz)
    }

    fun setOrtProperty(ort: String) {
        ortProperty.set(ort)
    }

    fun setEmailProperty(email: String) {
        emailProperty.set(email)
    }

    fun setTelefonProperty(telefon: String) {
        telefonProperty.set(telefon)
    }

    fun setParkplatzProperty(parkplatz: Boolean) {
        parkplatzProperty.set(parkplatz)
    }


    fun setNettoProperty(netto: Int) {
        nettoProperty.set(netto)
        bruttoProperty.set(nebenkostenProperty.get() + netto)
    }

    fun setNebenkostenProperty(nebenkosten: Int) {
        nebenkostenProperty.set(nebenkosten)
        bruttoProperty.set(nebenkosten + nettoProperty.get())
    }


}
