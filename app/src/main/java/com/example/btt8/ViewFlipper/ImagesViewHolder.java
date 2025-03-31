package com.example.btt8.ViewFlipper;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btt8.R;

public class ImagesViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    public ImagesViewHolder(@NonNull View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.imgView);
    }
}
