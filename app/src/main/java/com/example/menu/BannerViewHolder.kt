package com.example.menu

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind (banner: Banner){
        val bannerImageView: ImageView = itemView.findViewById(R.id.milk_for)
        val bannerDescriptorTextView: TextView = itemView.findViewById(R.id.description_text_view)

        bannerImageView.setImageDrawable(itemView.context.getDrawable(banner.imageRes))
        bannerDescriptorTextView.text = banner.description
    }
}