package com.geeks.noteapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.geeks.noteapp.R
import com.geeks.noteapp.data.OnBoarding
import com.geeks.noteapp.databinding.ItemOnBoardingBinding

class OnBoardViewPagerAdapter : Adapter<OnBoardViewPagerAdapter.OnBoardingViewHolder>() {

    private val arrayList = arrayListOf(
        OnBoarding(R.raw.animation_one, "Очень удобный фунционал"),
        OnBoarding(R.raw.animation_two, "Быстрый, качественный продукт"),
        OnBoarding(R.raw.animation_three, "Куча функций и интересных фишек")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = arrayList.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) = with(binding) {
            onBoarding.image.let {
                animImg.setAnimation(onBoarding.image)
                animImg.playAnimation()
            }
            if (adapterPosition == 0){
                ivOne.setBackgroundResource(R.color.active)
            }else if(adapterPosition == 1){
                ivOne.setBackgroundResource(R.color.gray)
                ivTwo.setBackgroundResource(R.color.active)
                ivThree.setBackgroundResource(R.color.gray)
            }else if(adapterPosition == 2){
                ivOne.setBackgroundResource(R.color.gray)
                ivTwo.setBackgroundResource(R.color.gray)
                ivThree.setBackgroundResource(R.color.active)
            }
            onTxt2.isVisible = adapterPosition == arrayList.lastIndex // 2
            viewPagerBtn.isVisible = adapterPosition != arrayList.lastIndex // 2 != 2
            onTxt.text = onBoarding.title
        }

    }
}