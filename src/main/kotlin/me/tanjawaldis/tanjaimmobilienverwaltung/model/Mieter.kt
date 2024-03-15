package me.tanjawaldis.tanjaimmobilienverwaltung.model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty

data class Mieter(var id: Int, var name: String, var straße: String, var plz: Int, var ort: String, var email: String, var telefon: String, var parkplatz: Boolean, var netto: Int, var nebenkosten: Int) {


    @Transient
    private var idProperty: SimpleIntegerProperty

    @Transient
    private var nameProperty: SimpleStringProperty

    @Transient
    private var straßeProperty: SimpleStringProperty

    @Transient
    private var plzProperty: SimpleIntegerProperty

    @Transient
    private var ortProperty: SimpleStringProperty

    @Transient
    private var emailProperty: SimpleStringProperty

    @Transient
    private var telefonProperty: SimpleStringProperty

    @Transient
    private var parkplatzProperty: SimpleBooleanProperty

    @Transient
    private var bruttoProperty: SimpleIntegerProperty

    @Transient
    private var nettoProperty: SimpleIntegerProperty

    @Transient
    private var nebenkostenProperty: SimpleIntegerProperty


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
        nettoProperty = SimpleIntegerProperty(netto)
        nebenkostenProperty = SimpleIntegerProperty(nebenkosten)
        bruttoProperty = SimpleIntegerProperty(nebenkosten + netto)
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


    fun setNettoProperty(netto: Int) {
        nettoProperty.set(netto)
        bruttoProperty.set(nebenkostenProperty.get() + netto)
    }

    fun setNebenkostenProperty(nebenkosten: Int) {
        nebenkostenProperty.set(nebenkosten)
        bruttoProperty.set(nebenkosten + nettoProperty.get())
    }


}
