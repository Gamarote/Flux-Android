package com.gmarote.flux.Common.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Gabriel Marote on 4/8/2018.
 */
class FragmentsAdapter(fm: FragmentManager, var fragments:ArrayList<Fragment>): FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return  fragments.size
    }

}