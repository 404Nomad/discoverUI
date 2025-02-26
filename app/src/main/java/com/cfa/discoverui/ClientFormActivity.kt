package com.cfa.discoverui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cfa.discoverui.classes.Client
import com.cfa.discoverui.database.Database

class ClientFormActivity : AppCompatActivity() {

    val TAG = ClientFormActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_form)

        // connexion bdd
        val database = Database(this)

        // recuperer nos biutons save et annuler
        val save = findViewById<Button>(R.id.btn_save)
        val cancel = findViewById<Button>(R.id.btn_cancel)

        // Save
        save.setOnClickListener {
            val client = Client(
                findViewById<EditText>(R.id.field_raison).text.toString(),
                findViewById<EditText>(R.id.field_siret).text.toString(),
                findViewById<EditText>(R.id.field_adresse).text.toString(),
                findViewById<EditText>(R.id.field_email).text.toString()
            )
            database.create(client)
            val intent = Intent(this, ListClientActivity::class.java) // destination
            startActivity(intent) // affiche la liste
        }

        // Annuler
        cancel.setOnClickListener {
            val main = Intent(this, MainActivity::class.java) // destination
            startActivity(main) // renvoie au Home
        }

    }
}