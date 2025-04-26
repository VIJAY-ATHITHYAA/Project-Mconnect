package com.example.mconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import java.util.Arrays;
import java.util.List;

public class CarDetailsActivity extends AppCompatActivity {
    private ViewPager2 imageSlider;
    private ImageButton btnPrevious;
    private ImageButton btnNext;
    private ImageButton btnMenu;
    private MaterialButton btnFreeInspection;
    private MaterialButton btnListMyCar;
    private BottomNavigationView bottomNavigation;
    private List<View> dotIndicators;
    private TextView tvLocation;
    private TextView tvEstimatedPrice;
    private TextView tvCarModel;

    // Sample car images - replace with your actual car images
    private final List<Integer> carImages = Arrays.asList(
        R.drawable.car_background, // Placeholder image
        R.drawable.car_background,
        R.drawable.car_background
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        initViews();
        setupImageSlider();
        setupClickListeners();
        setupBottomNavigation();
        loadCarDetails();
    }

    private void initViews() {
        imageSlider = findViewById(R.id.imageSlider);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnMenu = findViewById(R.id.btnMenu);
        btnFreeInspection = findViewById(R.id.btnFreeInspection);
        btnListMyCar = findViewById(R.id.btnListMyCar);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        tvLocation = findViewById(R.id.tvLocation);
        tvEstimatedPrice = findViewById(R.id.tvEstimatedPrice);
        tvCarModel = findViewById(R.id.tvCarModel);

        // Initialize dot indicators
        dotIndicators = Arrays.asList(
            findViewById(R.id.dot1),
            findViewById(R.id.dot2),
            findViewById(R.id.dot3)
        );
    }

    private void setupImageSlider() {
        CarImageAdapter adapter = new CarImageAdapter(carImages);
        imageSlider.setAdapter(adapter);
        imageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateDotIndicators(position);
                updateNavigationButtons(position);
            }
        });
    }

    private void updateNavigationButtons(int position) {
        btnPrevious.setVisibility(position == 0 ? View.INVISIBLE : View.VISIBLE);
        btnNext.setVisibility(position == carImages.size() - 1 ? View.INVISIBLE : View.VISIBLE);
    }

    private void setupClickListeners() {
        btnMenu.setOnClickListener(v -> {
            // TODO: Implement menu click
            // For example: open a drawer menu or show options menu
        });

        btnPrevious.setOnClickListener(v -> {
            int currentItem = imageSlider.getCurrentItem();
            if (currentItem > 0) {
                imageSlider.setCurrentItem(currentItem - 1);
            }
        });

        btnNext.setOnClickListener(v -> {
            int currentItem = imageSlider.getCurrentItem();
            if (currentItem < (imageSlider.getAdapter() != null ? imageSlider.getAdapter().getItemCount() : 0) - 1) {
                imageSlider.setCurrentItem(currentItem + 1);
            }
        });

        btnFreeInspection.setOnClickListener(v -> {
            // TODO: Implement free inspection booking
        });

        btnListMyCar.setOnClickListener(v -> {
            // TODO: Implement car listing process
        });
    }

    private void setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener(menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.navigation_home) {
                finish(); // Return to home
                return true;
            } else if (itemId == R.id.navigation_buy) {
                // Already in buy/details view
                return true;
            } else if (itemId == R.id.navigation_favorites) {
                // TODO: Navigate to favorites
                return true;
            } else if (itemId == R.id.navigation_sell) {
                // TODO: Navigate to sell screen
                return true;
            } else if (itemId == R.id.navigation_account) {
                // TODO: Navigate to account screen
                return true;
            }
            return false;
        });
    }

    private void loadCarDetails() {
        // In a real app, you would load these details from an intent or API
        tvLocation.setText("Ramanathapuram");
        tvEstimatedPrice.setText("RS: 25,000,00");
        tvCarModel.setText("Mercedes-Benz GLA");
    }

    private void updateDotIndicators(int selectedPosition) {
        for (int i = 0; i < dotIndicators.size(); i++) {
            View dot = dotIndicators.get(i);
            dot.setBackgroundResource(
                i == selectedPosition ? R.drawable.dot_selected : R.drawable.dot_unselected
            );
        }
    }
} 