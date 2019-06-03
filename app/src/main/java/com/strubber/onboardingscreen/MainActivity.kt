package com.strubber.onboardingscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.text.Html
import android.view.View
import android.view.ViewParent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dot: Array<TextView>
    private var currentPage = 0
    private val listener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {

        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        }

        override fun onPageSelected(p0: Int) {
            currentPage = p0
            addIndicator(p0)

            when (p0) {
                0 -> {
                    btn_next.isEnabled = true
                    btn_back.isEnabled = false

                    btn_next.text = "next"
                    btn_back.text = ""

                    btn_back.visibility = View.INVISIBLE

                }
                dot.size - 1 -> {
                    btn_next.isEnabled = true
                    btn_back.isEnabled = true

                    btn_next.text = "finish"
                    btn_back.text = "prev"

                    btn_back.visibility = View.VISIBLE
                }
                else -> {
                    btn_next.isEnabled = true
                    btn_back.isEnabled = true

                    btn_next.text = "next"
                    btn_back.text = "prev"

                    btn_back.visibility = View.VISIBLE
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adapter
        val adapter = SlideAdapter()
        view_pager.adapter = adapter

        //add indicator
        addIndicator(0)

        //handle viewpager
        view_pager.addOnPageChangeListener(listener)
        btn_next.setOnClickListener {
            view_pager.currentItem = currentPage+1
        }
        btn_back.setOnClickListener {
            view_pager.currentItem = currentPage-1
        }
    }

    private fun addIndicator(position: Int) {

        dot = Array(3) { TextView(this) }
        linear_indicator.removeAllViews()

        for (i in 0 until dot.size) {
            dot[i] = TextView(this)
            dot[i].text = Html.fromHtml("&#8226;")
            dot[i].textSize = 35.0f
            dot[i].setTextColor(resources.getColor(R.color.colorTransWhite))

            linear_indicator.addView(dot[i])
        }
        if (dot.isNotEmpty())
            dot[position].setTextColor(resources.getColor(R.color.colorAccent))
    }


}
