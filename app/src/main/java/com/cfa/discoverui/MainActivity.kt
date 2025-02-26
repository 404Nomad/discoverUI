package com.cfa.discoverui


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {

    // taglog pour tracer ce que l'on fait, dans le logcat (Tests et checks)
    val TAG = MainActivity::class.java.simpleName

    //::surcharger une méthode qui appartient a AppCompatActivity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add -> {
                val intent = Intent(this, ClientFormActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_supp -> {
                return super.onOptionsItemSelected(item)
            }
            R.id.action_show -> {
                val intent = Intent(this, secondActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // r pour Res
        var titre:TextView = findViewById<TextView>(R.id.titreActivity)

        //apeller log
        Log.i(TAG, "le titre original est = ${titre.text}")
        titre.text = "voici mon nouveau titre"

        val btn1:Button = findViewById<Button>(R.id.btn1)
        val reponse:TextView = findViewById<TextView>(R.id.reponse)
        var i = 0
        btn1.setOnClickListener {
            reponse.text = "J'ai cliqué sur le bouton 1: $i fois"
            i++
        }

        // set mon champ reponse et btn3
        findViewById<Button>(R.id.btn3).setOnClickListener {
            reponse.text = ""
            // re instancier compteur a zero
            i = 0
            Toast.makeText(this,
                "Un super message et un reset du champ reponse",
                Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            val intent = Intent(this, ListClientActivity::class.java)
            startActivity(intent)
        }

        // definir classe de destination
        // definir des informations a envoyer a cette activité
        findViewById<Button>(R.id.btn).setOnClickListener {
            val intent = Intent(this, secondActivity::class.java )
            intent.putExtra("nom", "CFA")
            intent.putExtra("date", "25/02/2025")
            intent.putExtra("user", "Pierre")
            startActivity(intent)
        }



    }
}