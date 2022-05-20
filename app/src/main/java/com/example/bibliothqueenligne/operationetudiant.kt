package com.example.bibliothqueenligne

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class operationetudiant : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operationetudiant)

        val liste= ArrayList<livre>()
        val base_url="http://192.168.0.109/loginandroid/listerlivres.php"
        val recycler=findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)

        val queue = Volley.newRequestQueue(this)
        val stringReq= StringRequest(
            Request.Method.GET, base_url,
            { response ->
                Toast.makeText(this,"entre", Toast.LENGTH_LONG).show()
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

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }



        }
    return false
    }
}


