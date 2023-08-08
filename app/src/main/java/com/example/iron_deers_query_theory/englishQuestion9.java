package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class englishQuestion9 extends AppCompatActivity {
    private Button EA1;
    private Button EA2;
    private Button EA3;
    private Button EA4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english_question9);

        EA1 = findViewById(R.id.eq9_1);
        EA2 = findViewById(R.id.eq9_2);
        EA3 = findViewById(R.id.eq9_3);
        EA4 = findViewById(R.id.eq9_4);


        EA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        EA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(englishQuestion9.this, englishQuestion10.class);
                startActivity(intent);
            }
        });

        EA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        EA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}