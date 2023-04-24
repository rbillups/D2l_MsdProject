package com.example.d2l_msdproject.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.d2l_msdproject.R
import com.example.d2l_msdproject.ui.StartHereSections
import com.example.d2l_msdproject.ui.adapters.StartAdapter.StartViewHolder

class StartAdapter (private val context: Context, private val sections: List<StartHereSections>) :
    RecyclerView.Adapter<StartViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
            val view =
                LayoutInflater.from(context).inflate(R.layout.start_here_item, parent, false)
            return StartViewHolder(view)
        }

        override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
            val section = sections[position]
            holder.sectionTextView.text = section.title
            holder.sectionDescriptionTextView.text = section.file
        }

        override fun getItemCount(): Int {
            return sections.size
        }

        inner class StartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val cardView: CardView = itemView.findViewById(R.id.startHereCardView)
            val sectionTextView: TextView = itemView.findViewById(R.id.section)
            val sectionDescriptionTextView: TextView = itemView.findViewById(R.id.sectionDescription)
        }
    }