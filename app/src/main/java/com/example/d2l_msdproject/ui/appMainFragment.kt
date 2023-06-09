package com.example.d2l_msdproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.d2l_msdproject.R
import com.example.d2l_msdproject.databinding.FragmentAppMainBinding
import com.example.d2l_msdproject.ui.adapters.ViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


class appMainFragment : Fragment() {

    //private val viewModel: appDashFragment by viewModels()
    private lateinit var binding: FragmentAppMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//binding set up
        binding= FragmentAppMainBinding.inflate(inflater, container, false)

        //viewpager adapter setup
        val viewPager: ViewPager2 = binding.viewPager2
        val bottomNavigationView: BottomNavigationView = binding.bottomNav

        //attach fragment activity to adapter
        val activity = requireActivity()
        val viewPagerAdapter = ViewPagerAdapter(activity)
        viewPager.adapter = viewPagerAdapter

        //bottom nav on click
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.startHereBottomNav -> viewPager.currentItem = 0
                R.id.learningModBottomNav -> viewPager.currentItem = 1
//                R.id.profileBottomNav -> viewPager.currentItem=2
            }
            true
        }

       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}

