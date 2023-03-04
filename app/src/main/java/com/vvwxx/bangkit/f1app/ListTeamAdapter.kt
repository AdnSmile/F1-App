package com.vvwxx.bangkit.f1app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vvwxx.bangkit.f1app.databinding.ItemRowTeamBinding

class ListTeamAdapter(private val listTeam: ArrayList<Team>)
    : RecyclerView.Adapter<ListTeamAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listTeam.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listTeam[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listTeam[holder.adapterPosition])
        }
    }

    class ListViewHolder(binding: ItemRowTeamBinding) : RecyclerView.ViewHolder(binding.root){
        val imgPhoto: ImageView = binding.imgItemPhoto
        val tvName: TextView = binding.tvItemName
        val tvDescription: TextView = binding.tvItemDescription
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Team)
    }
}