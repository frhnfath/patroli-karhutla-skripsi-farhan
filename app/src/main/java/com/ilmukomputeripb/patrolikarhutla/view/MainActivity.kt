package com.ilmukomputeripb.patrolikarhutla.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ilmukomputeripb.patrolikarhutla.NotesFragment
import com.ilmukomputeripb.patrolikarhutla.ProfileFragment
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = dateFormatter()
        checkPermissions()
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

        // setting bottom navigation
        setCurrentFragment(NotesFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.patroli->setCurrentFragment(NotesFragment())
                R.id.profile->setCurrentFragment(ProfileFragment())
            }
            true
        }
    }

    private fun checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100)
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateFormatter(): String {
        val date = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.getDefault())
        val formattedDate = formatter.format(date)
        return "Laporan $formattedDate"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) true
        return super.onOptionsItemSelected(item)
    }
}