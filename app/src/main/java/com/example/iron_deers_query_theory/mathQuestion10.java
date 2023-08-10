package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mathQuestion10 extends AppCompatActivity {
    private Button MA1;
    private Button MA2;
    private Button MA3;
    private Button MA4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_question10);






        MA1 =  findViewById(R.id.mq10_1);
        MA2 = findViewById(R.id.mq10_2);
        MA3 = findViewById(R.id.mq10_3);
        MA4 = findViewById(R.id.mq10_4);

        MA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        MA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });



        MA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mathQuestion10.this, CategoryUpdate.class);
                startActivity(intent);
            }
        });


        MA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}