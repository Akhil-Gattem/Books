package com.example.samplebooks.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ScreenSlidePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2 // Number of pages
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BooksFragment()
            1 -> AudioFragment()
            else -> BooksFragment()
        }
    }
}

