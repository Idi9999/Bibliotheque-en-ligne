package com.example.bibliothqueenligne

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class livreadapteretudiant (var listelivre:ArrayList<livre>): RecyclerView.Adapter<livreadapteretudiant.myviewholder>() {


    inner  class myviewholder(var itemview: View): RecyclerView.ViewHolder(itemview) {



        //val imagecouverture: ImageView = itemview.findViewById<ImageView>(R.id.imageView)
        val titre: TextView = itemview.findViewById<TextView>(R.id.titre)
        val resume: TextView = itemview.findViewById<TextView>(R.id.resumé)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.livrelayout,
            parent, false)
        val context=parent.context
        val holder=myviewholder(layout)


        return myviewholder(layout)
    }
    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.titre.text=listelivre[position].titre
        holder.resume.text=listelivre[position].resumé
       // holder.imagecouverture.setImageResource(listelivre[position].imagecouverture)
        holder.itemview.setOnClickListener {  val intent= Intent(holder.titre.context,operationetudiant::class.java)
            val bundle= Bundle()
            bundle.putString("titrelivre",holder.titre.toString())
            intent.putExtra("bundle",bundle)
            holder.titre.context.startActivity(intent)
        }


    }
    override fun getItemCount(): Int = listelivre.size


}