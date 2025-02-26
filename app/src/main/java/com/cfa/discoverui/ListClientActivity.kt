package com.cfa.discoverui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cfa.discoverui.classes.Client
import com.cfa.discoverui.classes.ClientAdapter
import com.cfa.discoverui.database.Database

class ListClientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_client)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val database = Database(this)

        //si la base est vide on ajoute deux clients
        if(database.getNumEntries() == 0) {
            database.create(Client("Kori", "13335446ddf54", "Perpignan zone indus", "kori@kori.fr"))
            database.create(Client("Paul", "7334546ddf54", "Perpignan zone Polygone", "paul@paul.fr"))
        }

        val listeClients: MutableList<Client> = database.getAllClients()

        var adapter = ClientAdapter(listeClients)
        val recycler = findViewById<RecyclerView>(R.id.recycler_client)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }
}