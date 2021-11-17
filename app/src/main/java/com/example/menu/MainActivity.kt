package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "LAST_SELECTED_ITEM"
private val BREAKFAST_FRAGMENT = Breakfast().javaClass.name
private val LUNCH_FRAGMENT = LunchFragment().javaClass.name
private val DINNER_FRAGMENT = DinnerFragment().javaClass.name

class MainActivity : AppCompatActivity() {

 private var breakfastFragment = Breakfast()
    private var lunchFragment = LunchFragment()
    private var dinnerFragment = DinnerFragment()

    private lateinit var bottomNavigationMenu: BottomNavigationView
    private lateinit var userRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationMenu = findViewById(R.id.bottom_navigator)

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.breakfast -> {
                    fragment =
                        savedInstanceState?.let {
                            supportFragmentManager.getFragment(it, BREAKFAST_FRAGMENT)
                        } ?: breakfastFragment
                }
                R.id.lunch -> {
                    fragment =
                        savedInstanceState?.let {
                            supportFragmentManager.getFragment(it, LUNCH_FRAGMENT)
                        } ?: lunchFragment
                }
                R.id.dinner -> {
                    fragment =
                        savedInstanceState?.let {
                            supportFragmentManager.getFragment(it, DINNER_FRAGMENT)
                        } ?: dinnerFragment
                }
            }
            replaceFragment(fragment!!)
            true
        }

        val bannerList:List<Banner> = listOf(
            Banner(R.drawable.dinner_foreground,"Молоко"),
            Banner(R.drawable.dinner_foreground,"Wfq")
        )


        userRecyclerView = findViewById(R.id.recyclerView)
        userRecyclerView.layoutManager
        LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        userRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        userRecyclerView.adapter = BannerAdapter (bannerList)



        //восстановление состояния нижней навиагции
        //если не сохранено то по дефолту выбрать R.id.number
        bottomNavigationMenu.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.breakfast
    }

    //сохрнаим состояние последнего нажатого элемента нижней навигации
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationMenu.selectedItemId)

        //сохраняем интсанцию конкретного фрагмента
        val fragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(outState, fragment.javaClass.name, fragment)
        super.onSaveInstanceState(outState)
    }

    //функция замены фрагментов с помощью supportFragmentManager
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_view, fragment)
            .addToBackStack(null)
            .commit()
    }
}



