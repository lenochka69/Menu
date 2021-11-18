package com.example.menu

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BannerViewHolderDinner (itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(banner: BannerDinner) {
        val bannerImageViewDinner: ImageView = itemView.findViewById(R.id.banner_image_dinner)
        val bannerDescriptorDinner: TextView = itemView.findViewById(R.id.description_text_dinner)

        bannerImageViewDinner.setImageDrawable(itemView.context.getDrawable(banner.imageResDinner))
        bannerDescriptorDinner.text = banner.descriptionDinner
    }
}