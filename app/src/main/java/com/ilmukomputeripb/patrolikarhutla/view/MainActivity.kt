package com.ilmukomputeripb.patrolikarhutla.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//      enable navigation drawer
        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, myDrawerLayout, R.string.nav_open, R.string.nav_close)
            myDrawerLayout.addDrawerListener(toggle)
            toggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navView.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.nav_kamus-> {
                        val intent = Intent(this@MainActivity, KamusActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_hotspot_sipongi-> {
                        val intent = Intent(this@MainActivity, HotspotMapsActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_logout-> {
                        val intent = Intent(this@MainActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) true
        return super.onOptionsItemSelected(item)
    }
}