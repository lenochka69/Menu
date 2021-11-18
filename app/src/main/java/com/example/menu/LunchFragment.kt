package com.example.menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

private const val LAST_RANDOM_VALUE = "LAST_RANDOM_VALUE"

class LunchFragment : Fragment() {

    private lateinit var diceImageViewLunch: ImageView
    private lateinit var randomizeButtonLunch: Button
    private lateinit var buttonBorscht: Button
    private lateinit var buttonFish:Button
    private lateinit var buttonMushroom :Button
    private lateinit var buttonChicken :Button
    private lateinit var buttonKharcho:Button
    private lateinit var buttonFastfood: Button
    private lateinit var userRecyclerLunch: RecyclerView
    private var randomValue = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lunch, container, false)
        diceImageViewLunch = view.findViewById(R.id.dice_image_lunch)
        randomizeButtonLunch = view.findViewById(R.id.randomize_button_lunch)
        savedInstanceState?.let { randomValue = it.getInt(LAST_RANDOM_VALUE) }
        rollDice(randomValue)

        buttonBorscht = view.findViewById(R.id.borscht)
        buttonFish = view.findViewById(R.id.fish_soup)
        buttonMushroom = view.findViewById(R.id.mushroom_soup)
        buttonChicken = view.findViewById(R.id.chicken_soup)
        buttonKharcho = view.findViewById(R.id.kharcho)
        buttonFastfood = view.findViewById(R.id.fast_food)

        val linkBorscht = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=12")
        val intentBorscht = Intent(Intent.ACTION_VIEW,linkBorscht)
        buttonBorscht.setOnClickListener{
            startActivity(Intent(intentBorscht))
        }
        val linkFish = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=470/")
        val intentFish = Intent(Intent.ACTION_VIEW,linkFish)
        buttonFish.setOnClickListener {
            startActivity(Intent(intentFish))

        }

        val linkMushroom = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=710")
        val intentMushroom = Intent(Intent.ACTION_VIEW,linkMushroom)
        buttonMushroom.setOnClickListener {
            startActivity(Intent(intentMushroom))
        }

        val linkChicken = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=713")
        val intentChicken = Intent(Intent.ACTION_VIEW,linkChicken)
        buttonChicken.setOnClickListener {
            startActivity(Intent(intentChicken))
        }

        val linkKharcho = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=488")
        val intentKharcho = Intent(Intent.ACTION_VIEW,linkKharcho)
        buttonKharcho.setOnClickListener {
            startActivity(Intent(intentKharcho))
        }

        val linkFastfood = Uri.parse("https://yandex.ru/maps/org/makdonalds/11319914475/")
        val intentFastfood = Intent(Intent.ACTION_VIEW, linkFastfood)
        buttonFastfood.setOnClickListener {
            startActivity(Intent(intentFastfood))
        }


        val bannerListLunch:List<BannerLunch> = listOf(
            BannerLunch(R.mipmap.soup,"Супы"),
            BannerLunch(R.mipmap.egg,"Яйца"),
            BannerLunch(R.mipmap.meal,"Мясные блюда"),
            BannerLunch(R.mipmap.panc,"Блинчики"),
            BannerLunch(R.mipmap.chee,"Сыр и творожок"),
        )




        userRecyclerLunch = view.findViewById(R.id.recyclerView_lunch)
        userRecyclerLunch.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        userRecyclerLunch.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        userRecyclerLunch.adapter = BannerAdappterLunch(bannerListLunch)

        randomizeButtonLunch.setOnClickListener {
            randomValue = Random.nextInt(1, 6)
            rollDice(randomValue)
        }

        return view
    }

    private fun rollDice(randomValue: Int) {
        diceImageViewLunch.setImageResource(
            when (randomValue) {
                1 -> R.mipmap.dice11_foreground
                2 -> R.mipmap.dice2_foreground
                3 -> R.mipmap.dice3_foreground
                4 -> R.mipmap.dice4_foreground
                5 -> R.mipmap.dice5_foreground
                6 -> R.mipmap.dice6_foreground
                else -> R.mipmap.dice11_foreground
            }
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_RANDOM_VALUE, randomValue)
    }

}