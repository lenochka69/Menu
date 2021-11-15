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
import kotlin.random.Random

private const val LAST_RANDOM_VALUE = "LAST_RANDOM_VALUE"

class Breakfast : Fragment() {
    //ранняя инициализация переменных для вью
    private lateinit var diceImageView: ImageView
    private lateinit var randomizeButton: Button
    private lateinit var buttonMilK: Button
    private lateinit var buttonPorridge:Button
    private lateinit var buttonPancakes:Button
    private lateinit var buttonCheese:Button
    private lateinit var buttonEggs:Button
    private lateinit var buttonMuesli: Button

    private var randomValue = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_breakfast, container, false)
        diceImageView = view.findViewById(R.id.dice_image_breakfast)
        randomizeButton = view.findViewById(R.id.randomize_button_breakfast)
        savedInstanceState?.let { randomValue = it.getInt(LAST_RANDOM_VALUE) }
        rollDice(randomValue)

        buttonMilK=view.findViewById(R.id.milk)
        buttonPorridge = view.findViewById(R.id.porridge)
        buttonPancakes = view.findViewById(R.id.pancakes)
        buttonEggs = view.findViewById(R.id.eggs)
        buttonCheese = view.findViewById(R.id.cheese)
        buttonMuesli = view.findViewById(R.id.muesli)

        val linkMilk = Uri.parse("https://www.photorecept.ru/smart-filter/zavtrak-iz-moloka")
        val intentMilk = Intent(Intent.ACTION_VIEW,linkMilk)
        buttonMilK.setOnClickListener{
            startActivity(Intent(intentMilk))
        }
        val linkPorridge = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=489,926")
        val intentPorridge = Intent(Intent.ACTION_VIEW,linkPorridge)
        buttonPorridge.setOnClickListener {
            startActivity(Intent(intentPorridge))

        }

        val linkPancakes = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=810,926")
        val intentPancakes = Intent(Intent.ACTION_VIEW,linkPancakes)
        buttonPancakes.setOnClickListener {
            startActivity(Intent(intentPancakes))
        }

        val linkEggs = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=97,926")
        val intentEggs = Intent(Intent.ACTION_VIEW,linkEggs)
        buttonEggs.setOnClickListener {
            startActivity(Intent(intentEggs))
        }

        val linkCheese = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=926,1075")
        val intentCheese = Intent(Intent.ACTION_VIEW,linkCheese)
        buttonCheese.setOnClickListener {
            startActivity(Intent(intentCheese))
        }

        val linkMuesli = Uri.parse("https://www.povarenok.ru/recipes/category/384/")
        val intentMuesli = Intent(Intent.ACTION_VIEW, linkMuesli)
        buttonMuesli.setOnClickListener {
            startActivity(Intent(intentMuesli))
        }


        randomizeButton.setOnClickListener {
            randomValue = Random.nextInt(1, 6)
            rollDice(randomValue)
        }

        return view
    }


    //подкидывает кубик
    private fun rollDice(randomValue: Int) {
        diceImageView.setImageResource(
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
    //сохраняет состояние
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_RANDOM_VALUE, randomValue)
    }

}