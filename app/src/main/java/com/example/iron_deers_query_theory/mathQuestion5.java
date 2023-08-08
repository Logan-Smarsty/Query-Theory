package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mathQuestion5 extends AppCompatActivity {
    private Button MA1;
    private Button MA2;
    private Button MA3;
    private Button MA4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_question5);



        MA1 =  findViewById(R.id.mq5_1);
        MA2 = findViewById(R.id.mq5_2);
        MA3 = findViewById(R.id.mq5_3);
        MA4 = findViewById(R.id.mq5_4);

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

            }
        });


        MA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mathQuestion5.this, mathQuestion6.class);
                startActivity(intent);
            }
        });
    }
}