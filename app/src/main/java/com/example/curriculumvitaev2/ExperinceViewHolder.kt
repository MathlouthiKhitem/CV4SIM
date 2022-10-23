package com.example.curriculumvitaev2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExperinceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val championPic : ImageView = itemView.findViewById<ImageView>(R.id.imageView2)
    val championName : TextView = itemView.findViewById<TextView>(R.id.company_name)
    val championRole : TextView = itemView.findViewById<TextView>(R.id.company_address)
    val btnDelete : ImageView = itemView.findViewById(R.id.delet)

}