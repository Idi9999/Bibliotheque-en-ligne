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


class listeetudiants : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_listeetudiants, container, false)
        val liste= ArrayList<etudiant>()
        val base_url="http://192.168.0.109/loginandroid/listeretudiants.php"
        val recycler=view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(activity)

        val queue = Volley.newRequestQueue(activity)
        val stringReq= StringRequest(
            Request.Method.GET, base_url,
            { response ->

                val array= JSONArray(response)
                for(i in 0..array.length()-1){
                    val objet=array.getJSONObject(i)
                    val nom:String=objet.getString("nom")
                    val prenom:String=objet.getString("prenom")
                    val classe:String=objet.getString("classe")
                    val id:String=objet.getString("id")

                    val etudiant1= etudiant(id,nom,prenom,classe)
                    liste.add(etudiant1)
                }
                recycler.adapter =etudiantadapter(liste)
            },
            { Log.d("API", "that didn't work") })
        queue.add(stringReq)



        return view
    }

}