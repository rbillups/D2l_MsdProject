package com.example.d2l_msdproject.ui.adapters

import com.example.d2l_msdproject.ui.learning_module
import com.example.d2l_msdproject.ui.startHere
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments: List<Fragment> = listOf(
        startHere(),
        learning_module()

    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}