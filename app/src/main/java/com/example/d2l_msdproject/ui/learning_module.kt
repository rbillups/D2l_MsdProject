package com.example.d2l_msdproject.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.d2l_msdproject.R
import com.example.d2l_msdproject.databinding.FragmentLearningModuleBinding
import com.example.d2l_msdproject.ui.adapters.LessonAdapter

class learning_module : Fragment() {

    companion object {
        fun newInstance() = learning_module()
    }

    //lateinit
    private lateinit var viewModel: LearningModuleViewModel
    private val modules = ArrayList<Module>()
    private lateinit var userList: ArrayList<Module>
    private lateinit var recv: RecyclerView
    private lateinit var lessonAdapter: LessonAdapter
    private lateinit var binding: FragmentLearningModuleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //setup binging
        binding = FragmentLearningModuleBinding.inflate(inflater, container, false)
        val activity = requireActivity()
        userList = ArrayList()

        //set up recycler view
        lessonAdapter = LessonAdapter(activity, userList)
        recv = binding.mRecycler
        recv.layoutManager = LinearLayoutManager(requireContext())
        recv.adapter = lessonAdapter

        //load recyclerview
        setUpModules()



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LearningModuleViewModel::class.java)
        // TODO: Use the ViewModel
    }


    fun setUpModules(){
        //load strings for modules
        val lessonArray = arrayOf(
            getString(R.string.lesson1),
            getString(R.string.lesson2),
            getString(R.string.lesson3),
            getString(R.string.lesson4),
            getString(R.string.lesson5),
            getString(R.string.lesson6),
            getString(R.string.lesson7),
            getString(R.string.lesson8),
            getString(R.string.lesson9),
            getString(R.string.lesson10),
            getString(R.string.lesson11),
            getString(R.string.lesson12),
            getString(R.string.lesson13)
        )

        //populate recycler view
        var count=0
        for (lesson in lessonArray) {

            val newModule=Module(lessonArray[count])
            userList.add(newModule)
            lessonAdapter.notifyDataSetChanged()
            count++
        }
    }

}