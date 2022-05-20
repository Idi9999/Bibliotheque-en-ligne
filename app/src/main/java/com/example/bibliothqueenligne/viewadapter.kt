package com.example.bibliothqueenligne

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter

class viewadapter(context: Context, var images:IntArray) :PagerAdapter() {
    lateinit var layoutinflater:LayoutInflater
    override fun getCount(): Int {

        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
       return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = layoutinflater.inflate(R.layout.images,container,false)
        val imageview= view.findViewById<View>(R.id.image) as ImageView
        imageview.setImageResource(images[position])
        container.addView(view)
        return view
    }

    init {
        layoutinflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }


}