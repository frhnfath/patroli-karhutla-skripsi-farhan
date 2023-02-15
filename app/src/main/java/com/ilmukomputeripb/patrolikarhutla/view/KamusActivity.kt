package com.ilmukomputeripb.patrolikarhutla.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.adapter.ListKamusAdapter
import com.ilmukomputeripb.patrolikarhutla.data.KamusIstilahData
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityKamusBinding

class KamusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKamusBinding
    private lateinit var rvKamus: RecyclerView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var listKamusAdapter: ListKamusAdapter
    private val list = ArrayList<KamusIstilahData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKamusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listKamusAdapter = ListKamusAdapter(list)
//      enable navigation drawer
        binding.apply {
            toggle = ActionBarDrawerToggle(this@KamusActivity, myDrawerLayout, R.string.nav_open, R.string.nav_close)
            myDrawerLayout.addDrawerListener(toggle)
            toggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navView.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.nav_beranda-> {
                        val intent  = Intent(this@KamusActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_hotspot_sipongi-> {
                        val intent = Intent(this@KamusActivity, HotspotMapsActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_logout-> {
                        val intent = Intent(this@KamusActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                true
            }
        }
        rvKamus = binding.rvKamus
        rvKamus.setHasFixedSize(true)

        list.addAll(getKamusData())
        showRecyclerList(list)
        supportActionBar?.setTitle(R.string.kamus_istilah)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.lowercase()
                if (query != null) {
                    filteredList(query)
                }
                return true
            }
        })
        return true
    }

    private fun filteredList(text: String) {
        val filteredList: ArrayList<KamusIstilahData> = ArrayList()

        for (item in list) {
            if (item.title?.lowercase()?.contains(text.lowercase()) == true) {
                filteredList.add(item)
                Log.d("Item", "$item")
                Log.d("Filtered List", "$filteredList")
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
            showRecyclerList(list)
        } else {
            listKamusAdapter.filterList(filteredList)
            showRecyclerList(filteredList)
            listKamusAdapter.notifyDataSetChanged()
        }
    }

    private fun showRecyclerList(list: ArrayList<KamusIstilahData>) {
        rvKamus.layoutManager = LinearLayoutManager(this)
        val listKamusAdapter = ListKamusAdapter(list)
        rvKamus.adapter = listKamusAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) true
        return super.onOptionsItemSelected(item)
    }

    private fun getKamusData(): ArrayList<KamusIstilahData> {
        val kamusTitle = resources.getStringArray(R.array.title)
        val kamusDescription = resources.getStringArray(R.array.description)
        val kamusSource = resources.getStringArray(R.array.source)
        val listKamus = ArrayList<KamusIstilahData>()
        for (i in title.indices) {
            val kamusIstilahData = KamusIstilahData(kamusTitle[i], kamusDescription[i], kamusSource[i])
            listKamus.add(kamusIstilahData)
        }
        val listKamusSorted = listKamus.sortedBy { it.title }.toCollection(ArrayList())
        return listKamusSorted
    }
}