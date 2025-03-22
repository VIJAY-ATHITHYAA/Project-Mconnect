package com.example.mconnect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SellerViewActivity : AppCompatActivity() {

    private lateinit var etCarNumber: TextInputEditText
    private lateinit var btnGetPrice: MaterialButton
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var btnBuy: MaterialButton
    private lateinit var btnSell: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller_view)

        // Initialize views
        initViews()
        // Setup listeners
        setupListeners()
        // Setup bottom navigation
        setupBottomNavigation()
    }

    private fun initViews() {
        etCarNumber = findViewById(R.id.etCarNumber)
        btnGetPrice = findViewById(R.id.btnGetPrice)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        btnBuy = findViewById(R.id.btnBuy)
        btnSell = findViewById(R.id.btnSell)
    }

    private fun setupListeners() {
        btnGetPrice.setOnClickListener {
            val carNumber = etCarNumber.text.toString()
            if (carNumber.isNotEmpty()) {
                // TODO: Implement car price calculation logic
                // You can make an API call or implement your own logic here
            }
        }

        btnBuy.setOnClickListener {
            // TODO: Implement buy functionality
        }

        btnSell.setOnClickListener {
            // TODO: Implement sell functionality
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
} 