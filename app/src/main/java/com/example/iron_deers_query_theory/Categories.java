package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Categories extends AppCompatActivity {

    Button Math;
    ImageView CatIcon;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);


        Math = findViewById(R.id.CatMath);
        Math.setVisibility(View.VISIBLE);
        Math.setBackgroundColor(Color.TRANSPARENT);

        Math.setOnClickListener(v -> {
            Intent intent = new Intent(Categories.this, MathQuestion.class);
            startActivity(intent);
        });
    }
}