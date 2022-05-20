package com.example.bibliothqueenligne

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.marvinlabs.widget.slideshow.SlideShowView

class choixetudiant : AppCompatActivity() {
    var viewPager:ViewPager?=null
    var images= intArrayOf(R.drawable.imm4,R.drawable.imm5,R.drawable.imm6,)
    var myadapter:viewadapter?=null

    private val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choixetudiant)
        viewPager= findViewById<ViewPager>(R.id.view) as ViewPager
        myadapter=viewadapter(this,images)
        viewPager!!.adapter=myadapter




    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menuetudiant, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.contact -> {
                val intent = Intent(Intent.ACTION_CALL)
                intent.setData(Uri.parse("tel:" +21260744545))
                startActivity(intent)
            }

            R.id.siteweb -> {
                val intent = Intent(Intent.ACTION_WEB_SEARCH)
                intent.putExtra(SearchManager.QUERY, "http://www.ensas.uca.ma/#/")
                startActivity(intent)
            }


            R.id.afficherlivres -> {
                val intent = Intent(this, operationetudiant::class.java)
                startActivity(intent)
            }
            R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


        return  false


    }



}