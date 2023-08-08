package com.example.iron_deers_query_theory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class mathQuestion1 extends AppCompatActivity {



    private Button MA1;
    private Button MA2;
    private Button MA3;
    private Button MA4;

    int clicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_question1);


        MA1 =  findViewById(R.id.mq1_1);
        MA2 = findViewById(R.id.mq1_2);
        MA3 = findViewById(R.id.mq1_3);
        MA4 = findViewById(R.id.mq1_4);
        MA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mathQuestion1.this, mathQuestion2.class);
                startActivity(intent);
            }
        });

        MA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked += 1;

                if (clicked > 0)
                {
                    MA2.setBackgroundColor(Color.RED);
                }
            }
        });

        MA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        MA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }















}



