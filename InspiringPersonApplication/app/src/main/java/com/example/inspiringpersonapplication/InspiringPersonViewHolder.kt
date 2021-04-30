package com.example.inspiringpersonapplication

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpersonapplication.databinding.ItemInspiringPersonBinding
import com.squareup.picasso.Picasso

class InspiringPersonViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView){
    fun bind(inspiringPerson: InspiringPerson){
        val itemBinding = ItemInspiringPersonBinding.bind(itemView)
        itemBinding.tvItemPersonName.text = inspiringPerson.name
        itemBinding.tvItemDateOfBirthAndDeath.text = inspiringPerson.dateOfBirthAndDeath
        itemBinding.tvItemDescription.text = inspiringPerson.description
        Picasso.get()
            .load(inspiringPerson.image)
            .fit()
            .placeholder(R.drawable.unknown)
            .into(itemBinding.ivItemImage)
        itemBinding.ivItemImage.setOnClickListener{
            Toast.makeText(context, PeopleRepository.getInspiringPersonQuote(inspiringPerson.name), Toast.LENGTH_LONG).show()
        }

    }
}