package com.example.d2l_msdproject.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.d2l_msdproject.R
import com.example.d2l_msdproject.databinding.FragmentLearningModuleBinding
import com.example.d2l_msdproject.ui.adapters.StartAdapter

class startHere : Fragment() {

    companion object {
        fun newInstance() = startHere()
    }

    private lateinit var viewModel: StartHereViewModel
    private lateinit var binding: FragmentLearningModuleBinding
    private lateinit var startHereSections: ArrayList<StartHereSections>
    private lateinit var startAdapter: StartAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearningModuleBinding.inflate(inflater, container, false)
        val activity = requireActivity()
        startHereSections = ArrayList<StartHereSections>()

        startAdapter = StartAdapter(activity, startHereSections)
        val recycView = binding.mRecycler
        recycView.layoutManager = LinearLayoutManager(requireContext())
        recycView.adapter = startAdapter

        makeSections()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StartHereViewModel::class.java)
    }

    private fun makeSections(){
        val titleArray = arrayOf(
            getString(R.string.section1),
            getString(R.string.section2),
            getString(R.string.section3),
            getString(R.string.section4),
            getString(R.string.section5)
        )
        val descriptionArray = arrayOf(
            getString(R.string.section1Description),
            getString(R.string.section2Description),
            getString(R.string.section3Description),
            getString(R.string.section4Description),
            getString(R.string.section5Description)
        )

        var count = 0
        for (title in titleArray){
            val newSection = StartHereSections(titleArray[count], descriptionArray[count])
            startHereSections.add(newSection)
            startAdapter.notifyDataSetChanged()
            count++
        }
    }
}