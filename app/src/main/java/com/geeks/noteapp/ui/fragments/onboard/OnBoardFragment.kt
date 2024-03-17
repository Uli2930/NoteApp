package com.geeks.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.geeks.noteapp.ui.adapter.OnBoardViewPagerAdapter
import com.geeks.noteapp.databinding.FragmentOnBoardBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        nextButton()
        tablayout()
    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
    }

    private fun setupListener() = with(binding.viewPager2) {
        binding.nextText.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)

            }


        }


    }

    private fun nextButton() = with(binding) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        nextText.isVisible = true
                        goTxt.isVisible = false
                    }

                    1 -> {
                        nextText.isVisible = true
                        goTxt.isVisible = false
                    }

                    2 -> {
                        nextText.isVisible = false
                        goTxt.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }

        })
    }

    private fun tablayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { _, _ ->
        }.attach()
    }

}