package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class scienceQuestion8 extends AppCompatActivity {
    private Button SA1;
    private Button SA2;
    private Button SA3;
    private Button SA4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.science_question8);

        SA1 =  findViewById(R.id.sq8_1);
        SA2 = findViewById(R.id.sq8_2);
        SA3 = findViewById(R.id.sq8_3);
        SA4 = findViewById(R.id.sq8_4);
        SA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        SA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        SA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scienceQuestion8.this, scienceQuestion9.class);
                startActivity(intent);
            }
        });



        SA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}