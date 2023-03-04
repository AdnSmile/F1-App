package com.vvwxx.bangkit.f1app

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vvwxx.bangkit.f1app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var rvTeams: RecyclerView
    private val list = ArrayList<Team>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvTeams = binding.rvTeams
        rvTeams.setHasFixedSize(true)

        list.addAll(getListTeams())
        showRecycleList()

        // menghilangkan supportActionBar
        val action = supportActionBar
        action?.hide()

        binding.ivAbout.setOnClickListener {
            val moveAboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(moveAboutIntent)
        }
    }

    private fun getListTeams(): ArrayList<Team> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataFullName = resources.getStringArray(R.array.data_full_name)
        val dataBase = resources.getStringArray(R.array.data_base)
        val dataTeamChief = resources.getStringArray(R.array.data_team_chief)
        val dataChassis = resources.getStringArray(R.array.data_chassis)
        val dataChampiont = resources.getStringArray(R.array.data_world_championt)
        val dataPowerUnit = resources.getStringArray(R.array.data_power_unit)
        val dataFirstEntry = resources.getStringArray(R.array.data_first_team_entry)

        val listTeam = ArrayList<Team>()
        for (i in dataName.indices) {
            val team = Team(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),
                dataFullName[i], dataBase[i], dataTeamChief[i], dataChassis[i], dataPowerUnit[i],
                dataFirstEntry[i] ,dataChampiont[i])
            listTeam.add(team)
        }
        return listTeam
    }

    private fun showRecycleList() {
        // menyesuaikan layout saat mode potrait atau landscape
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvTeams.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvTeams.layoutManager = LinearLayoutManager(this)
        }

        val listTeamAdapter = ListTeamAdapter(list)
        rvTeams.adapter = listTeamAdapter

        listTeamAdapter.setOnItemClickCallback(object: ListTeamAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Team) {
                showSelectedTeam(data)
            }
        })
    }

    private fun showSelectedTeam(team: Team) {
        val moveDetailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveDetailIntent.putExtra(DetailActivity.EXTRA_TEAM, team)
        startActivity(moveDetailIntent)
//        Toast.makeText(this, "Kamu memilih ${team.name}", Toast.LENGTH_SHORT).show()
    }
}