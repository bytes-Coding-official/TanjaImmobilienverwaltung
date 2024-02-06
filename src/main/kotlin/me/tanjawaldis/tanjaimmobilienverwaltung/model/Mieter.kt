package me.tanjawaldis.tanjaimmobilienverwaltung.model

import javafx.beans.property.*

class Mieter(id: Int, name: String, straße: String, plz: Int, ort: String, email: String, telefon: String, parkplatz: Boolean, brutto: Int, netto: Int, nebenkosten: Int) {


    private var idProperty: IntegerProperty
    private var nameProperty: StringProperty
    private var straßeProperty: StringProperty
    private var plzProperty: IntegerProperty
    private var ortProperty: StringProperty
    private var emailProperty: StringProperty
    private var telefonProperty: StringProperty
    private var parkplatzProperty: BooleanProperty
    private var bruttoProperty: IntegerProperty
    private var nettoProperty: IntegerProperty
    private var nebenkostenProperty: IntegerProperty


    init {
        //initialize the properties 
        idProperty = SimpleIntegerProperty(id)
        nameProperty = SimpleStringProperty(name)
        straßeProperty = SimpleStringProperty(straße)
        plzProperty = SimpleIntegerProperty(plz)
        ortProperty = SimpleStringProperty(ort)
        emailProperty = SimpleStringProperty(email)
        telefonProperty = SimpleStringProperty(telefon)
        parkplatzProperty = SimpleBooleanProperty(parkplatz)
        bruttoProperty = SimpleIntegerProperty(brutto)
        nettoProperty = SimpleIntegerProperty(netto)
        nebenkostenProperty = SimpleIntegerProperty(nebenkosten)
    }

    //getter and setter for the properties
    fun getIdProperty(): Int {
        return idProperty.get()
    }

    fun getNameProperty(): String {
        return nameProperty.get()
    }

    fun getStraßeProperty(): String {
        return straßeProperty.get()
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
        straßeProperty.set(straße)
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

    fun setBruttoProperty(brutto: Int) {
        bruttoProperty.set(brutto)
    }

    fun setNettoProperty(netto: Int) {
        nettoProperty.set(netto)
    }

    fun setNebenkostenProperty(nebenkosten: Int) {
        nebenkostenProperty.set(nebenkosten)
    }


}
