package com.example.d2l_msdproject.ui.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.d2l_msdproject.R
import com.example.d2l_msdproject.ui.Module
import com.example.d2l_msdproject.ui.webViewModule

class LessonAdapter(private val context: Context, private val lessons: List<Module>) :
    RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.learning_module_item, parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.lessonNameTextView.text = lesson.name
        holder.subSection1TextView.text = context.getString(R.string.slides)
        holder.subSection2TextView.text = context.getString(R.string.lab)

        // Create a bundle to hold the data
        val bundle = Bundle()

        // Put the data in the bundle, with a key-value pair
        bundle.putInt("itemNum", position+1)
        // Set click listener on subSection1TextView

        holder.subSection1TextView.setOnClickListener {
            bundle.putBoolean("Slides?",true)


            it.findNavController()?.navigate(R.id.action_appMainFragment_to_webViewModule,bundle)
        }
        holder.subSection2TextView.setOnClickListener{
            bundle.putBoolean("Slides?",false)

            it.findNavController()?.navigate(R.id.action_appMainFragment_to_webViewModule,bundle)
        }
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    inner class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.myCardView)
        val lessonNameTextView: TextView = itemView.findViewById(R.id.lessonName)
        val subSection1TextView: TextView = itemView.findViewById(R.id.subSection1TextView)
        val subSection2TextView: TextView = itemView.findViewById(R.id.subSection2TextView)



    }
}

