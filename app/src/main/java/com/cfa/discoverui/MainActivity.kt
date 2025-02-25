package com.cfa.discoverui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // taglog pour tracer ce que l'on fait, dans le logcat (Tests et checks)
    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}