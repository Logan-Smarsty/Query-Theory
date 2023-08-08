package com.example.iron_deers_query_theory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView GoogleBtn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleBtn = findViewById(R.id.GoogleBTN);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);


        GoogleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        MaterialButton LoginIn = (MaterialButton) findViewById(R.id.LogIn);

        //admin account info

        LoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, CategoryUpdate.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                 }
            }
        });


    }


   @Override
    protected void onStart() {
       super.onStart();

       FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

       if (user != null) {
           startActivity(new Intent(MainActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
       }




        //class firebase
        //{
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> city = new HashMap<>();

        Map<String, Object> practice = new HashMap<>();


        //public firebase()
        city.put("name", "Please work");
        city.put("state", "Florida");
        city.put("class", "PP3");


        db.collection("cities").document("IronDeer").set(city).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "Values added!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Values failed to add.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        }


       // }
   // }

    void signIn()
    {

        Intent signInIntent = gsc.getSignInIntent();

        Intent intent = new Intent(MainActivity.this, CategoryUpdate.class);
        startActivity(intent);
        startActivityForResult(signInIntent, 1000);




    }};





