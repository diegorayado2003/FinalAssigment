package com.example.finalassigment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class SportDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports_detail)

        val description = intent.getStringExtra("SPORT_DESCRIPTION")
        val tvSportDescription: TextView = findViewById(R.id.tvSportDescription)
        tvSportDescription.text = description
    }
}