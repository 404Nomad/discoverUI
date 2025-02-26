package com.cfa.discoverui.database

import android.annotation.SuppressLint
import android.content.Context
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.cfa.discoverui.classes.Client

// on va faire passer des variables a notre database
class Database(context: Context):
    SQLiteOpenHelper(context, "client.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE client (id INTEGER PRIMARY KEY," +
                "raison TEXT, siret TEXT, adresse TEXT, email TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    // créer les fonctions CRUD

    // creation client
    fun create(o: Client) {
        // o = objet, GetTableName and hydrate
        writableDatabase.insert(o.getTableName(), null, o.hydrate())
    }

    // recupere le nombre d'enregistrements de la table client
    fun getNumEntries(): Int = DatabaseUtils.queryNumEntries(readableDatabase,
        "client", null).toInt() // count des clients

    // créer une fonction qui recupere tous les clients
    // on ajoute SuppressLint pour ignorer les warnings
    @SuppressLint("Range")
    fun getAllClients(): MutableList<Client> { // lister tous les clients
        val clients = mutableListOf<Client>()
        readableDatabase.rawQuery("SELECT * FROM client", null).use {
            //utiliser avec un cursor et iterer sur la liste de retour
            cursor -> while (cursor.moveToNext()) {
                val client = Client(
                    cursor.getString(cursor.getColumnIndex("raison")),
                    cursor.getString(cursor.getColumnIndex("siret")),
                    cursor.getString(cursor.getColumnIndex("adresse")),
                    cursor.getString(cursor.getColumnIndex("email"))
                )
            // je peux maintenent alimenter la liste avec l'objet client
            clients.add(client)
            }
        }
        return clients
    }

}




