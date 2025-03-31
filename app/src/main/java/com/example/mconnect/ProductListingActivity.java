package com.example.mconnect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductListingActivity extends AppCompatActivity {
    // UI Components
    private ImageButton btnBack;
    private TextInputLayout tilCategory, tilTitle, tilBrandModel, tilPurchaseDate, tilOriginalPrice, tilPrice, tilLocation, tilDescription;
    private TextInputEditText etTitle, etBrandModel, etPurchaseDate, etOriginalPrice, etPrice, etDescription;
    private AutoCompleteTextView spinnerCategory, spinnerLocation;
    private RadioGroup rgCondition;
    private CheckBox cbNegotiable;
    private RecyclerView rvImages;
    private Button btnPreview;
    private List<Uri> selectedImages;
    private ImageAdapter imageAdapter;
    private static final int PICK_IMAGES_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);

        initViews();
        setupSpinners();
        setupClickListeners();
        setupImageAdapter();
    }

    private void initViews() {
        // Initialize all views
        btnBack = findViewById(R.id.btnBack);
        tilCategory = findViewById(R.id.tilCategory);
        tilTitle = findViewById(R.id.tilTitle);
        tilBrandModel = findViewById(R.id.tilBrandModel);
        tilPurchaseDate = findViewById(R.id.tilPurchaseDate);
        tilOriginalPrice = findViewById(R.id.tilOriginalPrice);
        tilPrice = findViewById(R.id.tilPrice);
        tilLocation = findViewById(R.id.tilLocation);
        tilDescription = findViewById(R.id.tilDescription);

        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerLocation = findViewById(R.id.spinnerLocation);
        etTitle = findViewById(R.id.etTitle);
        etBrandModel = findViewById(R.id.etBrandModel);
        etPurchaseDate = findViewById(R.id.etPurchaseDate);
        etOriginalPrice = findViewById(R.id.etOriginalPrice);
        etPrice = findViewById(R.id.etPrice);
        etDescription = findViewById(R.id.etDescription);

        rgCondition = findViewById(R.id.rgCondition);
        cbNegotiable = findViewById(R.id.cbNegotiable);
        rvImages = findViewById(R.id.rvImages);
        btnPreview = findViewById(R.id.btnPreview);

        selectedImages = new ArrayList<>();
    }

    private void setupSpinners() {
        // Setup category spinner
        String[] categories = {"Electronics", "Furniture", "Clothing", "Books", "Sports", "Others"};
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, categories);
        spinnerCategory.setAdapter(categoryAdapter);

        // Setup location spinner
        String[] locations = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Others"};
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, locations);
        spinnerLocation.setAdapter(locationAdapter);
    }

    private void setupClickListeners() {
        btnBack.setOnClickListener(v -> finish());

        btnPreview.setOnClickListener(v -> {
            if (validateInputs()) {
                Intent intent = new Intent(this, ProductPreviewActivity.class);
                // Pass all the data to preview activity
                intent.putExtra("category", spinnerCategory.getText().toString());
                intent.putExtra("title", etTitle.getText().toString());
                intent.putExtra("brandModel", etBrandModel.getText().toString());
                intent.putExtra("condition", getSelectedCondition());
                intent.putExtra("purchaseDate", etPurchaseDate.getText().toString());
                intent.putExtra("originalPrice", etOriginalPrice.getText().toString());
                intent.putExtra("price", etPrice.getText().toString());
                intent.putExtra("negotiable", cbNegotiable.isChecked());
                intent.putExtra("location", spinnerLocation.getText().toString());
                intent.putExtra("description", etDescription.getText().toString());
                startActivity(intent);
            }
        });

        etPurchaseDate.setOnClickListener(v -> showDatePicker());
    }

    private void setupImageAdapter() {
        imageAdapter = new ImageAdapter(this, selectedImages);
        rvImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvImages.setAdapter(imageAdapter);

        imageAdapter.setOnImageClickListener(new ImageAdapter.OnImageClickListener() {
            @Override
            public void onImageClick(int position) {
                // TODO: Implement image preview
            }

            @Override
            public void onDeleteClick(int position) {
                imageAdapter.removeImage(position);
            }
        });
    }

    private String getSelectedCondition() {
        int selectedId = rgCondition.getCheckedRadioButtonId();
        if (selectedId == R.id.rbNew) return "New";
        if (selectedId == R.id.rbLikeNew) return "Like New";
        if (selectedId == R.id.rbGood) return "Good";
        if (selectedId == R.id.rbFair) return "Fair";
        if (selectedId == R.id.rbNeedsRepair) return "Needs Repair";
        return "";
    }

    private void showDatePicker() {
        // Implement date picker dialog
        // This is a placeholder for the actual implementation
    }

    private boolean validateInputs() {
        boolean isValid = true;

        if (spinnerCategory.getText().toString().isEmpty()) {
            tilCategory.setError("Please select a category");
            isValid = false;
        }

        if (etTitle.getText().toString().isEmpty()) {
            tilTitle.setError("Please enter product name");
            isValid = false;
        }

        if (etBrandModel.getText().toString().isEmpty()) {
            tilBrandModel.setError("Please enter brand/model");
            isValid = false;
        }

        if (rgCondition.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select product condition", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        if (etPrice.getText().toString().isEmpty()) {
            tilPrice.setError("Please enter selling price");
            isValid = false;
        }

        if (spinnerLocation.getText().toString().isEmpty()) {
            tilLocation.setError("Please select location");
            isValid = false;
        }

        if (etDescription.getText().toString().isEmpty()) {
            tilDescription.setError("Please enter description");
            isValid = false;
        }

        return isValid;
    }
} 