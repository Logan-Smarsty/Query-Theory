package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class englishQuestion8 extends AppCompatActivity {

    private Button EA1;
    private Button EA2;
    private Button EA3;
    private Button EA4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english_question8);




        EA1 =  findViewById(R.id.eq8_1);
        EA2 = findViewById(R.id.eq8_2);
        EA3 = findViewById(R.id.eq8_3);
        EA4 = findViewById(R.id.eq8_4);




        EA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        EA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                Intent intent = new Intent(englishQuestion8.this, englishQuestion9.class);
                startActivity(intent);
            }
        });
    }
}