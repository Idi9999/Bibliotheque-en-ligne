package com.example.bibliothqueenligne

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import kotlin.collections.ArrayList


class listereservations : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_listereservations, container, false)
        val liste= ArrayList<reservation>()
        val base_url="http://192.168.0.109/loginandroid/listereservations.php"
        var recycler=view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(activity)

        val queue = Volley.newRequestQueue(activity)
        val stringReq= StringRequest(
            Request.Method.GET, base_url,
            { response ->

                val array= JSONArray(response)
                for(i in 0 until array.length()){
                    val objet=array.getJSONObject(i)
                    val numero:String=objet.getString("numero")
                    val titrelivre:String=objet.getString("titrelivre")
                    val nometudiant:String=objet.getString("nometudiant")
                    val prenometudiant:String=objet.getString("prenometudiant")
                    val date:String=objet.getString("date")
                    val dateretour:String=objet.getString("dateretour")
                    val reservation= reservation(titrelivre,numero,nometudiant,prenometudiant,date,dateretour)

                    liste.add(reservation)
                }
                recycler.adapter =reservationadapter(liste)
            },
            { Log.d("API", "that didn't work") })
        queue.add(stringReq)


        return view
    }

}