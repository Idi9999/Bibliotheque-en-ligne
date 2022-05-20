package com.example.bibliothqueenligne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class etudiantadapter(var listeetudiants:ArrayList<etudiant>): RecyclerView.Adapter<etudiantadapter.myviewholder>() {

    inner  class myviewholder(var itemview: View): RecyclerView.ViewHolder(itemview) {

        val id: TextView = itemview.findViewById<TextView>(R.id.id)
        val nom: TextView = itemview.findViewById<TextView>(R.id.nom)
        val prenom: TextView = itemview.findViewById<TextView>(R.id.prenom)
        val classe: TextView = itemview.findViewById<TextView>(R.id.classe)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.etudiantlayout,
            parent, false)
        return myviewholder(layout)
    }
    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.id.text=listeetudiants[position].id.toString()
        holder.nom.text=listeetudiants[position].nom
        holder.prenom.text=listeetudiants[position].prenom
        holder.classe.text=listeetudiants[position].classe


    }
    override fun getItemCount(): Int = listeetudiants.size


}