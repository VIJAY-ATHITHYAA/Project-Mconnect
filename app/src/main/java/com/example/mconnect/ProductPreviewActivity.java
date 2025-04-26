package com.example.mconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;

public class ProductPreviewActivity extends AppCompatActivity {
    // UI Components
    private ImageButton btnBack;
    private ViewPager2 viewPagerImages;
    private TextView tvStatus, tvCategory, tvTitle, tvBrandModel, tvCondition, tvPrice, tvOriginalPrice, tvNegotiable;
    private TextView tvLocation, tvDescription, tvPurchaseDate;
    private MaterialButton btnEdit, btnPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_preview);

        initViews();
        setupClickListeners();
        loadProductData();
    }

    private void initViews() {
        // Initialize all views
        btnBack = findViewById(R.id.btnBack);
        viewPagerImages = findViewById(R.id.viewPagerImages);
        tvStatus = findViewById(R.id.tvStatus);
        tvCategory = findViewById(R.id.tvCategory);
        tvTitle = findViewById(R.id.tvTitle);
        tvBrandModel = findViewById(R.id.tvBrandModel);
        tvCondition = findViewById(R.id.tvCondition);
        tvPrice = findViewById(R.id.tvPrice);
        tvOriginalPrice = findViewById(R.id.tvOriginalPrice);
        tvNegotiable = findViewById(R.id.tvNegotiable);
        tvLocation = findViewById(R.id.tvLocation);
        tvDescription = findViewById(R.id.tvDescription);
        tvPurchaseDate = findViewById(R.id.tvPurchaseDate);
        btnEdit = findViewById(R.id.btnEdit);
        btnPublish = findViewById(R.id.btnPublish);
    }

    private void setupClickListeners() {
        btnBack.setOnClickListener(v -> finish());

        btnEdit.setOnClickListener(v -> {
            // Return to ProductListingActivity with current data
            finish();
        });

        btnPublish.setOnClickListener(v -> {
            // TODO: Implement publish functionality
            // This should save the product to your database and update the status
            tvStatus.setText("Published");
            tvStatus.setBackgroundResource(R.drawable.bg_status_published);
            btnPublish.setEnabled(false);
        });
    }

    private void loadProductData() {
        // Get data from intent
        String category = getIntent().getStringExtra("category");
        String title = getIntent().getStringExtra("title");
        String brandModel = getIntent().getStringExtra("brandModel");
        String condition = getIntent().getStringExtra("condition");
        String purchaseDate = getIntent().getStringExtra("purchaseDate");
        String originalPrice = getIntent().getStringExtra("originalPrice");
        String price = getIntent().getStringExtra("price");
        boolean negotiable = getIntent().getBooleanExtra("negotiable", false);
        String location = getIntent().getStringExtra("location");
        String description = getIntent().getStringExtra("description");

        // Set data to views
        tvCategory.setText(category);
        tvTitle.setText(title);
        tvBrandModel.setText(brandModel);
        tvCondition.setText(condition);
        tvPurchaseDate.setText("Purchased: " + purchaseDate);
        tvOriginalPrice.setText("Original Price: ₹" + originalPrice);
        tvPrice.setText("₹" + price);
        tvNegotiable.setVisibility(negotiable ? View.VISIBLE : View.GONE);
        tvLocation.setText(location);
        tvDescription.setText(description);

        // TODO: Setup ViewPager2 with product images
        // This will require implementing an adapter for the ViewPager2
    }
} 