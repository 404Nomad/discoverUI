package com.cfa.discoverui.classes

import android.content.ContentValues
import android.os.Parcel
import android.os.Parcelable

data class Client(val raison:String?, val siret:String?,
                    val adresse:String?, val email:String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {}

    override fun toString(): String {
        var sb = StringBuilder()
        sb.append(raison).append("|")
        sb.append(siret).append("|")
        sb.append(adresse).append("|")
        sb.append(email)
        return sb.toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(raison)
        parcel.writeString(siret)
        parcel.writeString(adresse)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Client> {
        override fun createFromParcel(parcel: Parcel): Client {
            return Client(parcel)
        }

        override fun newArray(size: Int): Array<Client?> {
            return arrayOfNulls(size)
        }
    }

    // créet une fonctiuon qui renvoie un string et crtéer le return client qui est le nom de notre table
    fun getTableName():String {
        return "client"
    }

    // nouvelle fonctiuon pour hydrater
    fun hydrate(): ContentValues {
        val values = ContentValues()
        values.put("raison", this.raison)
        values.put("siret", this.siret)
        values.put("adresse", this.adresse)
        values.put("email", this.email)
        return values
    }
}
