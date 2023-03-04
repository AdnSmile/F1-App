package com.vvwxx.bangkit.f1app

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vvwxx.bangkit.f1app.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEAM = "extra_team"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // menghilangkan supportActionBar
        val action = supportActionBar
        action?.hide()

        val team = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_TEAM, Team::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_TEAM)
        }

        if (team != null) {
            binding.imgItemPhoto.setImageResource(team.photo)
            binding.tvName.text = team.name
            binding.tvFullTeamName.text = team.fullTeamName
            binding.tvBase.text = team.base
            binding.tvTeamChief.text = team.teamChief
            binding.tvChassis.text = team.chassis
            binding.tvPowerUnit.text = team.powerUnit
            binding.tvTeamEntry.text = team.firstTeamEntry
            binding.tvChampion.text = team.worldChampionships
            binding.tvDesc.text = team.description

            binding.actionShare.setOnClickListener{
                val text = """
                    Full Team Name : ${team.fullTeamName}
                    Base : ${team.base}
                    Team Chief : ${team.teamChief}
                    Chassis : ${team.chassis}
                    Power Unit : ${team.powerUnit}
                    First Entry : ${team.firstTeamEntry}
                    Championships : ${team.worldChampionships}
                """.trimIndent()
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, text)
                startActivity(Intent.createChooser(shareIntent, "F1 TEAM"))
            }
        }
    }
}