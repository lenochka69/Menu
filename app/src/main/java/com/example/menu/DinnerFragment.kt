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

class DinnerFragment : Fragment() {
    private lateinit var diceImageViewDinner: ImageView
    private lateinit var randomizeButtonDinner: Button
    private lateinit var buttonBeef: Button
    private lateinit var buttonPork:Button
    private lateinit var buttonChickenDinner:Button
    private lateinit var buttonTurkey:Button
    private lateinit var buttonSeafood:Button
    private lateinit var buttonVegetarianism: Button
    private lateinit var userRecyclerDinner: RecyclerView

    private var randomValue = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dinner, container, false)
        diceImageViewDinner = view.findViewById(R.id.dice_image_dinner)
        randomizeButtonDinner = view.findViewById(R.id.randomize_button_dinner)
        savedInstanceState?.let { randomValue = it.getInt(LAST_RANDOM_VALUE) }
        rollDice(randomValue)

        buttonBeef=view.findViewById(R.id.beef)
        buttonPork = view.findViewById(R.id.pork)
        buttonChickenDinner = view.findViewById(R.id.chicken_dinner)
        buttonTurkey = view.findViewById(R.id.turkey)
        buttonSeafood = view.findViewById(R.id.seafood)
        buttonVegetarianism = view.findViewById(R.id.vegetarianism)

        val linkBeef = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=74/")
        val intentBeef = Intent(Intent.ACTION_VIEW,linkBeef)
        buttonBeef.setOnClickListener {
            startActivity(Intent(intentBeef))
        }

        val linkPork = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=297")
        val intentPork = Intent(Intent.ACTION_VIEW,linkPork)
        buttonPork.setOnClickListener {
            startActivity(Intent(intentPork))
        }

        val linkChickenDinner = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=933")
        val intentChickenDinner = Intent(Intent.ACTION_VIEW, linkChickenDinner)
        buttonChickenDinner.setOnClickListener {
            startActivity(Intent(intentChickenDinner))
        }
        val linkTurkey = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=938")
        val intentTurkey = Intent(Intent.ACTION_VIEW,linkTurkey)
        buttonTurkey.setOnClickListener {
            startActivity(Intent(intentTurkey))
        }

        val linkSeafood = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=53")
        val intentSeafood = Intent(Intent.ACTION_VIEW,linkSeafood)
        buttonSeafood.setOnClickListener {
            startActivity(Intent(intentSeafood))
        }

        val linkVegetarianism = Uri.parse("https://www.russianfood.com/recipes/bytype/?fid=216")
        val intentVegetarianism = Intent(Intent.ACTION_VIEW, linkVegetarianism)
        buttonVegetarianism.setOnClickListener {
            startActivity(Intent(intentVegetarianism))
        }
        val bannerListDinner:List<BannerDinner> = listOf(
            BannerDinner(R.drawable.meal_r,"Говядина"),
            BannerDinner(R.drawable.final1200,"Курица"),
            BannerDinner(R.drawable.tyr,"Индейка"),
            BannerDinner(R.drawable.moreprodukty,"Морепродукты"),
            BannerDinner(R.drawable.vegan,"Веган"),
            BannerDinner(R.drawable.svinina,"Свинина"),
        )




        userRecyclerDinner = view.findViewById(R.id.recyclerView_dinner)
        userRecyclerDinner.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        userRecyclerDinner.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        userRecyclerDinner.adapter = BannerAdapterDinner(bannerListDinner)


        randomizeButtonDinner.setOnClickListener {
            randomValue = Random.nextInt(1, 6)
            rollDice(randomValue)
        }

        return view
    }

    //подкидывает кубик
    private fun rollDice(randomValue: Int) {
        diceImageViewDinner.setImageResource(
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
