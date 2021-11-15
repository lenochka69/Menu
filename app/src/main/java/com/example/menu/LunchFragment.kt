package com.example.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

private const val LAST_RANDOM_VALUE = "LAST_RANDOM_VALUE"

class LunchFragment : Fragment() {

    //ранняя инициализация переменных для вью
    private lateinit var diceImageView: ImageView
    private lateinit var randomizeButton: Button

    private var randomValue = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_breakfast, container, false)
        diceImageView = view.findViewById(R.id.dice_image_breakfast)
        randomizeButton = view.findViewById(R.id.randomize_button_breakfast)
        savedInstanceState?.let { randomValue = it.getInt(LAST_RANDOM_VALUE) }
        rollDice(randomValue)

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