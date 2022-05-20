package com.example.bibliothqueenligne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction

class operationprof : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operationprof)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menuprof, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Ajouteretudiant -> {
                val intent = Intent(this, ajouteretudiant::class.java)
                startActivity(intent)
            }
            R.id.Ajouterreservation -> {
                val intent = Intent(this, ajouterreservation1::class.java)
                startActivity(intent)
            }
            R.id.Ajouterlivre -> {
                val intent = Intent(this, ajouterlivre::class.java)
                startActivity(intent)
            }
            R.id.retireretudiant -> {
                val intent = Intent(this, retireretudiant1::class.java)
                startActivity(intent)
            }
            R.id.retirerlivre -> {
                val intent = Intent(this, retirerlivre::class.java)
                startActivity(intent)
            }
            R.id.retirerreservation -> {
                val intent = Intent(this, retirerreservation::class.java)
                startActivity(intent)
            }
        }
        return false
    }
    fun A(view: android.view.View) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        //fragmentTransaction.add(R.id.frag, FragmentB())
        fragmentTransaction.replace(R.id.frag, listeetudiants())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    fun B(view: android.view.View) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        //fragmentTransaction.add(R.id.fragmentcontainer, FragmentB())
        fragmentTransaction.replace(R.id.frag, listereservations())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


    }
    fun C(view: android.view.View) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        //fragmentTransaction.add(R.id.fragmentcontainer, FragmentB())
        fragmentTransaction.replace(R.id.frag, listelivres())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


    }
}


