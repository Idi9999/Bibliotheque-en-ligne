package com.example.bibliothqueenligne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.marvinlabs.widget.slideshow.SlideShowView

class choixprof : AppCompatActivity() {
    var viewPager:ViewPager?=null
    var images= intArrayOf(R.drawable.imm4,R.drawable.imm5,R.drawable.imm6,)
    var myadapter:viewadapter?=null

    private val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choixprof)
    viewPager= findViewById<ViewPager>(R.id.view) as ViewPager
        myadapter=viewadapter(this,images)
        viewPager!!.adapter=myadapter




    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menuchoixprof, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.operation -> {
                val intent = Intent(this, operationprof::class.java)
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