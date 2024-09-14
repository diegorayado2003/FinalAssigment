package com.example.finalassigment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassigment.data.Sport

class SportsAdapter(private val sportsList: List<Sport>) : RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {

    class SportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSportName: TextView = itemView.findViewById(R.id.tvSportName)
        val tvSportDescription: TextView = itemView.findViewById(R.id.tvSportDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport, parent, false)
        return SportsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sport = sportsList[position]
        holder.tvSportName.text = sport.sportName
        holder.tvSportDescription.text = sport.description
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }
}