package com.strubber.onboardingscreen

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class SlideAdapter : PagerAdapter() {

    private val header = listOf("EAT","SLEEP","CODE")
    private val description = listOf("simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown ",
        "is a long established fact that a reader will be distracted by the readable content of a page when looking ",
        "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form")
    private val imgRes = listOf(R.drawable.group_10,R.drawable.group_11,R.drawable.group_12)

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int = header.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.slide_layout,container,false)

        val tvHead = view.findViewById<TextView>(R.id.txt_head)
        val tvDesc = view.findViewById<TextView>(R.id.txt_desc)
        val img = view.findViewById<ImageView>(R.id.img_slide)

        tvHead.text = header[position]
        tvDesc.text = description[position]
        img.setImageResource(imgRes[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}