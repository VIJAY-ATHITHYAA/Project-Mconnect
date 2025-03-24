package com.example.mconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

public class ProductPreviewActivity extends AppCompatActivity {
    private ViewPager2 imageSlider;
    private LinearLayout layoutDots;
    private TextView tvProductTitle;
    private TextView tvPrice;
    private TextView tvProductType;
    private TextView tvCategory;
    private TextView tvCondition;
    private TextView tvLocation;
    private TextView tvWarranty;
    private TextView tvDelivery;
    private TextView tvNegotiable;
    private TextView tvBillAvailable;
    private TextView tvDescription;
    private MaterialButton btnEdit;
    private MaterialButton btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_preview);

        initViews();
        setupClickListeners();
        loadProductDetails();
    }

    private void initViews() {
        imageSlider = findViewById(R.id.imageSlider);
        layoutDots = findViewById(R.id.layoutDots);
        tvProductTitle = findViewById(R.id.tvProductTitle);
        tvPrice = findViewById(R.id.tvPrice);
        tvProductType = findViewById(R.id.tvProductType);
        tvCategory = findViewById(R.id.tvCategory);
        tvCondition = findViewById(R.id.tvCondition);
        tvLocation = findViewById(R.id.tvLocation);
        tvWarranty = findViewById(R.id.tvWarranty);
        tvDelivery = findViewById(R.id.tvDelivery);
        tvNegotiable = findViewById(R.id.tvNegotiable);
        tvBillAvailable = findViewById(R.id.tvBillAvailable);
        tvDescription = findViewById(R.id.tvDescription);
        btnEdit = findViewById(R.id.btnEdit);
        btnConfirm = findViewById(R.id.btnConfirm);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> onBackPressed());
    }

    private void setupClickListeners() {
        btnEdit.setOnClickListener(v -> {
            // Return to editing activity
            finish();
        });

        btnConfirm.setOnClickListener(v -> {
            // TODO: Implement confirmation logic
            // Save product listing to database
            // Show success message
            // Navigate to home/listings
        });
    }

    private void loadProductDetails() {
        // Get data from intent
        Intent intent = getIntent();
        if (intent != null) {
            // Set product title
            String title = intent.getStringExtra("title");
            tvProductTitle.setText(title);

            // Set price
            String price = intent.getStringExtra("price");
            tvPrice.setText(String.format("₹%s", price));

            // Set product type and category
            String productType = intent.getStringExtra("productType");
            String category = intent.getStringExtra("category");
            tvProductType.setText(productType);
            tvCategory.setText(category);

            // Set condition
            String condition = intent.getStringExtra("condition");
            tvCondition.setText(condition);

            // Set location
            String location = intent.getStringExtra("location");
            tvLocation.setText(location);

            // Set description
            String description = intent.getStringExtra("description");
            tvDescription.setText(description);

            // Set features visibility
            boolean hasWarranty = intent.getBooleanExtra("warranty", false);
            boolean hasDelivery = intent.getBooleanExtra("delivery", false);
            boolean isNegotiable = intent.getBooleanExtra("negotiable", false);
            boolean hasBill = intent.getBooleanExtra("billAvailable", false);

            tvWarranty.setVisibility(hasWarranty ? View.VISIBLE : View.GONE);
            tvDelivery.setVisibility(hasDelivery ? View.VISIBLE : View.GONE);
            tvNegotiable.setVisibility(isNegotiable ? View.VISIBLE : View.GONE);
            tvBillAvailable.setVisibility(hasBill ? View.VISIBLE : View.GONE);

            // Setup image slider if images are provided
            String[] imageUris = intent.getStringArrayExtra("images");
            if (imageUris != null && imageUris.length > 0) {
                setupImageSlider(imageUris);
            }
        }
    }

    private void setupImageSlider(String[] imageUris) {
        // TODO: Implement image slider adapter
        // Create dots indicators
        for (int i = 0; i < imageUris.length; i++) {
            View dot = new View(this);
            int size = getResources().getDimensionPixelSize(R.dimen.dot_size);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
            params.setMargins(8, 0, 8, 0);
            dot.setLayoutParams(params);
            dot.setBackgroundResource(i == 0 ? R.drawable.dot_selected : R.drawable.dot_unselected);
            layoutDots.addView(dot);
        }

        // Setup ViewPager2 page change callback
        imageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateDotIndicators(position);
            }
        });
    }

    private void updateDotIndicators(int selectedPosition) {
        int count = layoutDots.getChildCount();
        for (int i = 0; i < count; i++) {
            View dot = layoutDots.getChildAt(i);
            dot.setBackgroundResource(i == selectedPosition ? R.drawable.dot_selected : R.drawable.dot_unselected);
        }
    }
} 