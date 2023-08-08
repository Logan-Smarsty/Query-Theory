package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class scienceQuestion2 extends AppCompatActivity {
    private Button SA1;
    private Button SA2;
    private Button SA3;
    private Button SA4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.science_question2);

        SA1 =  findViewById(R.id.sq2_1);
        SA2 = findViewById(R.id.sq2_2);
        SA3 = findViewById(R.id.sq2_3);
        SA4 = findViewById(R.id.sq2_4);
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
                Intent intent = new Intent(scienceQuestion2.this, scienceQuestion3.class);
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