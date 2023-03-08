package com.ilmukomputeripb.patrolikarhutla.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.uifragment.main.SectionsPagerAdapter
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityPatroliBinding

class PatroliActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPatroliBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPatroliBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.patroli)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.save_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_form -> {
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}