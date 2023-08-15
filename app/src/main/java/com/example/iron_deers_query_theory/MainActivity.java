package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iron_deers_query_theory.Activities.CategoryUpdate;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity
{
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView GoogleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleBtn = findViewById(R.id.GoogleBTN);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {signIn();}
        });


        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        MaterialButton LoginIn = (MaterialButton) findViewById(R.id.LogIn);

        //admin account info

        LoginIn.setOnClickListener(v -> {
            if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
            {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CategoryUpdate.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });



    }
    void signIn()
    {

        Intent signInIntent = gsc.getSignInIntent();

        Intent intent = new Intent(MainActivity.this, CategoryUpdate.class);
        startActivity(intent);
        startActivityForResult(signInIntent, 1000);


    }};