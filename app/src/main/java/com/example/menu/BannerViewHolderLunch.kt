package com.example.menu

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class BannerViewHolderLunch (itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(banner: BannerLunch) {
        val bannerImageViewLunch: ImageView = itemView.findViewById(R.id.banner_image_lunch)
        val bannerDescriptorLunch: TextView = itemView.findViewById(R.id.description_text_lunch)

        bannerImageViewLunch.setImageDrawable(itemView.context.getDrawable(banner.imageResLunch))
        bannerDescriptorLunch.text = banner.descriptionLunch
    }
}