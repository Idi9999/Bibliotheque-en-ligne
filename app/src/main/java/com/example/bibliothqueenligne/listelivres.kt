package com.example.bibliothqueenligne

import android.app.DownloadManager
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
import com.android.volley.Request.Method.GET
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.lang.reflect.Method

class listelivres : Fragment() {

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
      // Inflate the layout for this fragment
          val view= inflater.inflate(R.layout.fragment_listelivres, container, false)
          val liste= ArrayList<livre>()
          val base_url="http://192.168.0.109/loginandroid/listerlivres.php"
          var recycler=view.findViewById<RecyclerView>(R.id.recycler)
          recycler.layoutManager = LinearLayoutManager(activity)

          val queue = Volley.newRequestQueue(activity)
          val stringReq= StringRequest(
                  Request.Method.GET, base_url,
                  { response ->

                          val array= JSONArray(response)
                          for(i in 0 until array.length()){
                                  val objet=array.getJSONObject(i)
                                  val titre:String=objet.getString("titre")
                                  val resume:String=objet.getString("resume")
                              val photo= R.drawable.photo
                              val livre=livre(titre,resume)

                                  liste.add(livre)
                          }

                          recycler.adapter =livreadapter(liste)

                  },
                  { Log.d("API", "that didn't work") })
          queue.add(stringReq)


          return view
  }


        }


