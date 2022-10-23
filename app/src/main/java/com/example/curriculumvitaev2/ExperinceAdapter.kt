package com.example.curriculumvitaev2

import android.content.Intent
import android.location.Address
import android.provider.Settings.NameValueTable.NAME
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ExperinceAdapter(var championsList: MutableList<ExperienceData>) : RecyclerView.Adapter<ExperinceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperinceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.addexperience, parent, false)

        return ExperinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExperinceViewHolder, position: Int) {

        val name = championsList[position].companyname
        val role = championsList[position].companyaddress

        holder.championPic.setImageResource(championsList[position].companyimage)
        holder.championName.text = name
        holder.championRole.text = role

//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.contextconst val PICTURE = "PICTURE")
//            intent.apply {
//                putExtra(PICTURE, championsList[position].companyname)
//                putExtra(NAME, name)
//                putExtra(Address, role)
//            }
//            holder.itemView.context.startActivity(intent)
//        }

        holder.btnDelete.setOnClickListener {
            //TODO 13 "Delete a champion from the database and refresh the recyclerView"



        }

    }

    override fun getItemCount() = championsList.size

}