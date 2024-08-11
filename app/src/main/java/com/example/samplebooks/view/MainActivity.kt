package com.example.samplebooks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.samplebooks.R
import com.example.samplebooks.common.ViewModelFactory
import com.example.samplebooks.databinding.ActivityMainBinding
import com.example.samplebooks.repository.DataRepository
import com.example.samplebooks.viewmodel.DataViewModel
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DataViewModel
    val listArray = arrayOf(
        "Text",
        "Audio",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(DataRepository()))[DataViewModel::class.java]
        setContentView(binding.root)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = listArray[position]
        }.attach()
    }

}