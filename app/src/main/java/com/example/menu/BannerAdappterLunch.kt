package com.example.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BannerAdappterLunch (private val bannerListLunch: List<BannerLunch>):
    RecyclerView.Adapter<BannerViewHolderLunch>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolderLunch {
            val bannerViewLunch = LayoutInflater.from(parent.context)
                .inflate(R.layout.lunch_banner,parent,false)
            return BannerViewHolderLunch(bannerViewLunch)
        }

        override fun onBindViewHolder(holder: BannerViewHolderLunch, position: Int) {
            val bannerLunch = bannerListLunch [position]
            holder.bind(bannerLunch)
        }

        override fun getItemCount(): Int {
            return bannerListLunch.size
        }
    }
