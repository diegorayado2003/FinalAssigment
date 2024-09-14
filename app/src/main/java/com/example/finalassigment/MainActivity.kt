package com.example.finalassigment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.finalassigment.network.RetrofitInstance
import com.example.finalassigment.data.SportsResponse


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var sportsAdapter: SportsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from API
        fetchSportsData()
    }

    private fun fetchSportsData() {
        RetrofitInstance.api.getSports().enqueue(object : Callback<SportsResponse> {
            override fun onResponse(call: Call<SportsResponse>, response: Response<SportsResponse>) {
                if (response.isSuccessful) {
                    val sportsList = response.body()?.entities
                    sportsList?.let {
                        // Set up the adapter with the retrieved data
                        sportsAdapter = SportsAdapter(it)
                        recyclerView.adapter = sportsAdapter
                    }
                }
            }

            override fun onFailure(call: Call<SportsResponse>, t: Throwable) {
                // Handle error
            }
        })
    }
}