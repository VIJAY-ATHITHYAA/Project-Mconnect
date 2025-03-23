package com.example.mconnect

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class SellerLocationActivity : AppCompatActivity() {
    private lateinit var imageSlider: ViewPager2
    private lateinit var btnPrevious: ImageButton
    private lateinit var btnNext: ImageButton
    private lateinit var btnMenu: ImageButton
    private lateinit var btnAdders: MaterialButton
    private lateinit var btnPinCode: MaterialButton
    private lateinit var btnAutoDetect: MaterialButton
    private lateinit var btnUploadImage: MaterialButton
    private lateinit var btnNextStep: MaterialButton
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var dotIndicators: List<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller_location)

        initViews()
        setupImageSlider()
        setupClickListeners()
        setupBottomNavigation()
    }

    private fun initViews() {
        imageSlider = findViewById(R.id.imageSlider)
        btnPrevious = findViewById(R.id.btnPrevious)
        btnNext = findViewById(R.id.btnNext)
        btnMenu = findViewById(R.id.btnMenu)
        btnAdders = findViewById(R.id.btnAdders)
        btnPinCode = findViewById(R.id.btnPinCode)
        btnAutoDetect = findViewById(R.id.btnAutoDetect)
        btnUploadImage = findViewById(R.id.btnUploadImage)
        btnNextStep = findViewById(R.id.btnNextStep)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Initialize dot indicators
        val dotsContainer = findViewById<View>(R.id.dotsIndicator)
        dotIndicators = listOf(
            dotsContainer.findViewById(R.id.dot1),
            dotsContainer.findViewById(R.id.dot2),
            dotsContainer.findViewById(R.id.dot3)
        )
    }

    private fun setupImageSlider() {
        // TODO: Set up ViewPager2 adapter with car images
        imageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateDotIndicators(position)
            }
        })
    }

    private fun setupClickListeners() {
        btnMenu.setOnClickListener {
            // TODO: Implement menu click
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

        btnAdders.setOnClickListener {
            // TODO: Implement address selection
        }

        btnPinCode.setOnClickListener {
            // TODO: Implement pin code entry
        }

        btnAutoDetect.setOnClickListener {
            // TODO: Implement location auto-detection
        }

        btnUploadImage.setOnClickListener {
            // TODO: Implement image upload
        }

        btnNextStep.setOnClickListener {
            // TODO: Navigate to next step
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    // Handle home navigation
                    true
                }
                R.id.navigation_buy -> {
                    // Handle buy navigation
                    true
                }
                R.id.navigation_favorites -> {
                    // Handle favorites navigation
                    true
                }
                R.id.navigation_sell -> {
                    // Handle sell navigation
                    true
                }
                R.id.navigation_account -> {
                    // Handle account navigation
                    true
                }
                else -> false
            }
        }
    }

    private fun updateDotIndicators(selectedPosition: Int) {
        dotIndicators.forEachIndexed { index, dot ->
            dot.isSelected = index == selectedPosition
        }
    }
} 