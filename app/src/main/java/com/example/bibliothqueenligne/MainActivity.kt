package com.example.bibliothqueenligne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

//import android.content.Intent;
import android.net.Uri;
//import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

class MainActivity : AppCompatActivity() {

    var viewPager: ViewPager?=null
    var images= intArrayOf(R.drawable.imm4, R.drawable.imm5, R.drawable.imm6)
    var myadapter:viewadapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewPager= findViewById<ViewPager>(R.id.view) as ViewPager
        myadapter=viewadapter(this,images)
        viewPager!!.adapter=myadapter

        val prof=findViewById<Button>(R.id.prof)
        val etudiant=findViewById<Button>(R.id.etudiant)



        prof.setOnClickListener{
            //val nom="Professeur"
            //val choix= 1

            //val bundle= Bundle()
            //intent.putExtra("nom",nom)
            //intent.putExtra("choix", choix)
           // intent.putExtra("bundle", bundle)
            val intent= Intent(this, connexion1::class.java)
            startActivity(intent)
        }
        etudiant.setOnClickListener{
            //val nom="Etudiant"
            //val choix =2
            val intent1= Intent(this, choixetudiant::class.java)

            //val bundle= Bundle()
            //intent.putExtra("nom",nom)
            //intent.putExtra("choix", choix)
            // intent.putExtra("bundle", bundle)
            startActivity(intent1)
        }


    }


}

