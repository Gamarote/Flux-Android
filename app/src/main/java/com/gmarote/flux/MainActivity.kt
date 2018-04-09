package com.gmarote.flux

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.gmarote.flux.Common.Adapters.FragmentsAdapter
import com.gmarote.flux.Counter.CounterFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.view.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_counter -> {
                appBar.msgText.text = "Contador"
                fragmentView.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list -> {
//                fragmentView.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(appBar as Toolbar)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        var adapter = FragmentsAdapter(supportFragmentManager, arrayListOf(CounterFragment()))

        fragmentView.adapter = adapter

        fragmentView.currentItem = 0
        navigation.selectedItemId = R.id.navigation_counter
        appBar.msgText.text = "Contador"

        fragmentView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> navigation.selectedItemId = R.id.navigation_counter
                    1 -> navigation.selectedItemId = R.id.navigation_list
                }
            }

        })
    }
}
