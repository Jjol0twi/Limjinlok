package com.example.limjinlok

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.limjinlok.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this@MainActivity) }

    private var rainbow = GradientDrawable(
        GradientDrawable.Orientation.TL_BR,
        intArrayOf(
            Color.RED,
            Color.MAGENTA,
            Color.BLUE,
            Color.CYAN,
            Color.GREEN,
            Color.YELLOW,
            Color.RED,
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.background = rainbow

        initView()
    }

    private fun initView() = with(binding) {
        mainViewPagerAdapter.addTabList(Contactlist(), "Contact")
        mainViewPagerAdapter.addTabList(MyPageFragment(), "My Page")
        viewPager.adapter = mainViewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = mainViewPagerAdapter.getTitleByIndex(pos)
        }.attach()
    }
}