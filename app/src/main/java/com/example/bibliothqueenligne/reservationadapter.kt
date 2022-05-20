package com.example.bibliothqueenligne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class reservationadapter(var listereservations:ArrayList<reservation>): RecyclerView.Adapter<reservationadapter.myviewholder>() {

    inner  class myviewholder(var itemview: View): RecyclerView.ViewHolder(itemview) {

        val numero: TextView = itemview.findViewById<TextView>(R.id.numero)
        val titrelivre: TextView = itemview.findViewById<TextView>(R.id.titrelivre)
        val nomeleve: TextView = itemview.findViewById<TextView>(R.id.nomeleve)
        val date: TextView = itemview.findViewById<TextView>(R.id.date)
        val dateretour: TextView = itemview.findViewById<TextView>(R.id.dateretour)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.reservationlayout,
            parent, false)
        return myviewholder(layout)
    }
    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.numero.text=listereservations[position].numero.toString()
        holder.titrelivre.text=listereservations[position].titrelivre.toString()
        holder.nomeleve.text=listereservations[position].nometudiant
        holder.date.text=listereservations[position].date.toString()
        holder.dateretour.text=listereservations[position].dateretour.toString()

    }
    override fun getItemCount(): Int = listereservations.size


}