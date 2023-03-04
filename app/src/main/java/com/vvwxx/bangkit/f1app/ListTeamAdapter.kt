package com.vvwxx.bangkit.f1app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vvwxx.bangkit.f1app.databinding.ItemRowTeamBinding

class ListTeamAdapter(private val listTeam: ArrayList<Team>,
                      private val onClick: (Team) -> Unit)
    : RecyclerView.Adapter<ListTeamAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listTeam.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listTeam[position])
    }

    inner class ListViewHolder(binding: ItemRowTeamBinding) : RecyclerView.ViewHolder(binding.root){
        val imgPhoto: ImageView = binding.imgItemPhoto
        val tvName: TextView = binding.tvItemName
        val tvDescription: TextView = binding.tvItemDescription

        fun bind(team: Team) {
            imgPhoto.setImageResource(team.photo)
            tvName.text = team.name
            tvDescription.text = team.description
            itemView.setOnClickListener { onClick(team) }
        }
    }
}