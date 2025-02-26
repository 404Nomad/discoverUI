package com.cfa.discoverui.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cfa.discoverui.R
import org.w3c.dom.Text

//recupere notre liste de clients
// on va heriter d'une classe intégrée
// adapter est une classe qui existe si RecyclerView existe
// on la type avec une classe
// systeme de relfexibilité
class ClientAdapter(val clients: MutableList<Client>): RecyclerView.Adapter<ClientAdapter.ViewHolder>() {
        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val cardView = itemView.findViewById<CardView>(R.id.client_card)
            val raison = itemView.findViewById<TextView>(R.id.client_raison)
            val siret = itemView.findViewById<TextView>(R.id.client_siret)
            val adresse = itemView.findViewById<TextView>(R.id.client_adresse)
            val email = itemView.findViewById<TextView>(R.id.client_email)
        }

    // renvoyer la vue
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false)
        return ViewHolder(viewItem)
    }

    // renvoyer la taille du tableau
    override fun getItemCount(): Int {
        return clients.size
    }

    // positionner les donnees
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val client = clients[position]
        holder.raison.text = client.raison
        holder.siret.text = client.siret
        holder.adresse.text = client.adresse
        holder.email.text = client.email
    }
}