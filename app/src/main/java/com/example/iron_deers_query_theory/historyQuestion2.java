package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class historyQuestion2 extends AppCompatActivity {
    private Button HA1;
    private Button HA2;
    private Button HA3;
    private Button HA4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_question2);
        HA1 = findViewById(R.id.hq2_1);
        HA2 = findViewById(R.id.hq2_2);
        HA3 = findViewById(R.id.hq2_3);
        HA4 = findViewById(R.id.hq2_4);
        HA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        HA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        HA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        HA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(historyQuestion2.this, historyQuestion3.class);
                startActivity(intent);
            }
        });
    }
}