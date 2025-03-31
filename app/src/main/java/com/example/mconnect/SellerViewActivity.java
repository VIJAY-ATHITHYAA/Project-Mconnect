package com.example.mconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class SellerViewActivity extends AppCompatActivity {
    // UI Components
    private ImageButton btnBack;
    private Button btnGiveDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_view);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        // Initialize all view
        btnGiveDetails = findViewById(R.id.btnGiveDetails);
    }

    private void setupClickListeners() {
       btnGiveDetails.setOnClickListener(v -> {
            // Navigate to ProductListingActivity
            Intent intent = new Intent(this, ProductListingActivity.class);
            startActivity(intent);
        });
    }
} 