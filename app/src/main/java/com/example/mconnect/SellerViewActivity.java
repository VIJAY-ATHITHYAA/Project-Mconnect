package com.example.mconnect;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SellerViewActivity extends AppCompatActivity {
    private TextInputEditText etCarNumber;
    private MaterialButton btnGetPrice;
    private BottomNavigationView bottomNavigation;
    private MaterialButton btnBuy;
    private MaterialButton btnSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_view);

        // Initialize views
        initViews();
        // Setup listeners
        setupListeners();
        // Setup bottom navigation
        setupBottomNavigation();
    }

    private void initViews() {
        etCarNumber = findViewById(R.id.etCarNumber);
        btnGetPrice = findViewById(R.id.btnGetPrice);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        btnBuy = findViewById(R.id.btnBuy);
        btnSell = findViewById(R.id.btnSell);
    }

    private void setupListeners() {
        btnGetPrice.setOnClickListener(v -> {
            String carNumber = etCarNumber.getText().toString();
            if (!carNumber.isEmpty()) {
                // TODO: Implement car price calculation logic
                // You can make an API call or implement your own logic here
            }
        });

        btnBuy.setOnClickListener(v -> {
            // TODO: Implement buy functionality
        });

        btnSell.setOnClickListener(v -> {
            // TODO: Implement sell functionality
        });
    }

    private void setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener(menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.navigation_home) {
                // Handle home navigation
                return true;
            } else if (itemId == R.id.navigation_buy) {
                // Handle buy navigation
                return true;
            } else if (itemId == R.id.navigation_favorites) {
                // Handle favorites navigation
                return true;
            } else if (itemId == R.id.navigation_sell) {
                // Handle sell navigation
                return true;
            } else if (itemId == R.id.navigation_account) {
                // Handle account navigation
                return true;
            }
            return false;
        });
    }
} 