package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class historyQuestion5 extends AppCompatActivity {
    private Button HA1;
    private Button HA2;
    private Button HA3;
    private Button HA4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_question5);
        HA1 = findViewById(R.id.hq5_1);
        HA2 = findViewById(R.id.hq5_2);
        HA3 = findViewById(R.id.hq5_3);
        HA4 = findViewById(R.id.hq5_4);
        HA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        HA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(historyQuestion5.this, historyQuestion6.class);
                startActivity(intent);
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

            }
        });
    }
}