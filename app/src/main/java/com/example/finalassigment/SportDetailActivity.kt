package com.example.finalassigment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class SportDetailActivity : AppCompatActivity() {

    private lateinit var tvSportName: TextView
    private lateinit var tvPlayerCount: TextView
    private lateinit var tvFieldType: TextView
    private lateinit var tvOlympicSport: TextView
    private lateinit var tvDescription: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports_detail)

        // Initialize views
        tvSportName = findViewById(R.id.tvSportName)
        tvPlayerCount = findViewById(R.id.tvPlayerCount)
        tvFieldType = findViewById(R.id.tvFieldType)
        tvOlympicSport = findViewById(R.id.tvOlympicSport)
        tvDescription = findViewById(R.id.tvDescription)


        // Retrieve the data from the intent
        val sportName = intent.getStringExtra("sportName") ?: "Sport"
        val playerCount = intent.getIntExtra("playerCount", 0)
        val fieldType = intent.getStringExtra("fieldType") ?: "Unknown"
        val olympicSport = intent.getBooleanExtra("olympicSport", false)
        val description = intent.getStringExtra("SPORT_DESCRIPTION") ?: "No description available"

        // Set the data to the TextViews
        tvSportName.text = "$sportName"
        tvPlayerCount.text = "Player Count: $playerCount"
        tvFieldType.text = "Field Type: $fieldType"
        tvOlympicSport.text = "Olympic Sport: ${if (olympicSport) "Yes" else "No"}"
        tvDescription.text = "$description"


    }



    fun goBackToDashboard(view: View) {
        finish()
    }
}