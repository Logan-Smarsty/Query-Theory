package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.os.Bundle;

public class MathQuestion extends AppCompatActivity {

=======
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MathQuestion extends AppCompatActivity {

    ImageView CatIcon;
    @SuppressLint("MissingInflatedId")
>>>>>>> acb390980ed917bb7a6b1a97ce8aaaa107842199
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_question);
<<<<<<< HEAD
    }
=======

        CatIcon = findViewById(R.id.Cat);
        CatIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MathQuestion.this, Categories.class);
            startActivity(intent);
        });
    }

>>>>>>> acb390980ed917bb7a6b1a97ce8aaaa107842199
}