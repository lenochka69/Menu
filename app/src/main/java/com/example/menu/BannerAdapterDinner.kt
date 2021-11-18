package com.example.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BannerAdapterDinner (private val bannerListDinner: List<BannerDinner>):
    RecyclerView.Adapter<BannerViewHolderDinner>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolderDinner {
        val bannerViewDinner = LayoutInflater.from(parent.context)
            .inflate(R.layout.dinner_banner,parent,false)
        return BannerViewHolderDinner(bannerViewDinner)
    }

    override fun onBindViewHolder(holder: BannerViewHolderDinner, position: Int) {
        val bannerDinner = bannerListDinner [position]
        holder.bind(bannerDinner)
    }

    override fun getItemCount(): Int {
        return bannerListDinner.size
    }
}
