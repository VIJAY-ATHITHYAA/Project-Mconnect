package com.example.mconnect

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class CarDetailsActivity : AppCompatActivity() {
    private lateinit var imageSlider: ViewPager2
    private lateinit var btnPrevious: ImageButton
    private lateinit var btnNext: ImageButton
    private lateinit var btnMenu: ImageButton
    private lateinit var btnFreeInspection: MaterialButton
    private lateinit var btnListMyCar: MaterialButton
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var dotIndicators: List<View>
    private lateinit var tvLocation: TextView
    private lateinit var tvEstimatedPrice: TextView
    private lateinit var tvCarModel: TextView

    // Sample car images - replace with your actual car images
    private val carImages = listOf(
        R.drawable.car_background, // Placeholder image
        R.drawable.car_background,
        R.drawable.car_background
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        initViews()
        setupImageSlider()
        setupClickListeners()
        setupBottomNavigation()
        loadCarDetails()
    }

    private fun initViews() {
        imageSlider = findViewById(R.id.imageSlider)
        btnPrevious = findViewById(R.id.btnPrevious)
        btnNext = findViewById(R.id.btnNext)
        btnMenu = findViewById(R.id.btnMenu)
        btnFreeInspection = findViewById(R.id.btnFreeInspection)
        btnListMyCar = findViewById(R.id.btnListMyCar)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        tvLocation = findViewById(R.id.tvLocation)
        tvEstimatedPrice = findViewById(R.id.tvEstimatedPrice)
        tvCarModel = findViewById(R.id.tvCarModel)

        // Initialize dot indicators
        dotIndicators = listOf(
            findViewById(R.id.dot1),
            findViewById(R.id.dot2),
            findViewById(R.id.dot3)
        )
    }

    private fun setupImageSlider() {
        val adapter = CarImageAdapter(carImages)
        imageSlider.adapter = adapter
        imageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateDotIndicators(position)
                updateNavigationButtons(position)
            }
        })
    }

    private fun updateNavigationButtons(position: Int) {
        btnPrevious.visibility = if (position == 0) View.INVISIBLE else View.VISIBLE
        btnNext.visibility = if (position == carImages.size - 1) View.INVISIBLE else View.VISIBLE
    }

    private fun setupClickListeners() {
        btnMenu.setOnClickListener {
            // TODO: Implement menu click
            // For example: open a drawer menu or show options menu
        }

        btnPrevious.setOnClickListener {
            val currentItem = imageSlider.currentItem
            if (currentItem > 0) {
                imageSlider.currentItem = currentItem - 1
            }
        }

        btnNext.setOnClickListener {
            val currentItem = imageSlider.currentItem
            if (currentItem < (imageSlider.adapter?.itemCount ?: 0) - 1) {
                imageSlider.currentItem = currentItem + 1
            }
        }

        btnFreeInspection.setOnClickListener {
            // TODO: Implement free inspection booking
        }

        btnListMyCar.setOnClickListener {
            // TODO: Implement car listing process
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    finish() // Return to home
                    true
                }
                R.id.navigation_buy -> {
                    // Already in buy/details view
                    true
                }
                R.id.navigation_favorites -> {
                    // TODO: Navigate to favorites
                    true
                }
                R.id.navigation_sell -> {
                    // TODO: Navigate to sell screen
                    true
                }
                R.id.navigation_account -> {
                    // TODO: Navigate to account screen
                    true
                }
                else -> false
            }
        }
    }

    private fun loadCarDetails() {
        // In a real app, you would load these details from an intent or API
        tvLocation.text = "Ramanathapuram"
        tvEstimatedPrice.text = "RS: 25,000,00"
        tvCarModel.text = "Mercedes-Benz GLA"
    }

    private fun updateDotIndicators(selectedPosition: Int) {
        dotIndicators.forEachIndexed { index, dot ->
            dot.setBackgroundResource(
                if (index == selectedPosition) R.drawable.dot_selected
                else R.drawable.dot_unselected
            )
        }
    }
} 