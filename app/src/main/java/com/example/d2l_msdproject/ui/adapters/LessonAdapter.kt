package com.example.d2l_msdproject.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.d2l_msdproject.R
import com.example.d2l_msdproject.ui.Module

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

