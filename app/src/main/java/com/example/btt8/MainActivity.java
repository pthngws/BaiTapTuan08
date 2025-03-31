package com.example.btt8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermain);

        Button btnFragment = findViewById(R.id.btnFragmentStatusOrder);
        Button btnRecyclerView = findViewById(R.id.btnRecyclerViewIndicator);
        Button btnViewFlipper = findViewById(R.id.btnViewFlipper);

        btnFragment.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.example.btt8.FragmentStatusOrder.MainActivity.class);
            startActivity(intent);
        });

        btnRecyclerView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.example.btt8.RecyclerViewIndicator.MainActivity.class);
            startActivity(intent);
        });

        btnViewFlipper.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.example.btt8.ViewFlipper.MainActivity.class);
            startActivity(intent);
        });

    }
}
