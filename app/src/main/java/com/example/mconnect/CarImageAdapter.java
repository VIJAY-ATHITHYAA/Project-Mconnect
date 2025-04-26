package com.example.mconnect;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarImageAdapter extends RecyclerView.Adapter<CarImageAdapter.CarImageViewHolder> {
    private final List<Integer> images;

    public CarImageAdapter(List<Integer> images) {
        this.images = images;
    }

    public static class CarImageViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;

        public CarImageViewHolder(View view) {
            super(view);
            this.imageView = view.findViewById(android.R.id.content);
        }
    }

    @NonNull
    @Override
    public CarImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new CarImageViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarImageViewHolder holder, int position) {
        holder.imageView.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
} 