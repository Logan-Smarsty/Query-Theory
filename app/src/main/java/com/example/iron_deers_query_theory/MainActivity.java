package com.example.iron_deers_query_theory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iron_deers_query_theory.Activities.CategoryUpdate;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity
{
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView GoogleBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleBtn = findViewById(R.id.GoogleBTN);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);
        GoogleBtn.setOnClickListener(v -> signIn());

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        MaterialButton LoginIn = findViewById(R.id.LogIn);
        //admin account info
        LoginIn.setOnClickListener(v ->
        {
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
            {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CategoryUpdate.class);
                startActivity(intent);
            } else {Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();}

            String txt_user = username.getText().toString();
            if(txt_user.isEmpty()){Toast.makeText(MainActivity.this, "Nothing Entered!", Toast.LENGTH_SHORT).show();}
            else{FirebaseDatabase.getInstance().getReference().child("Username").push().child("User:").setValue(txt_user);}

            String txt_pass = password.getText().toString();
            if(txt_pass.isEmpty()){Toast.makeText(MainActivity.this, "Nothing Entered!", Toast.LENGTH_SHORT).show();}
            else{FirebaseDatabase.getInstance().getReference().child("Password").push().child("Pass:").setValue(txt_user);}
        });
        }
    void signIn()
    {
        Intent signInIntent = gsc.getSignInIntent();
        Intent intent = new Intent(MainActivity.this, CategoryUpdate.class);
        startActivity(intent);
        startActivityForResult(signInIntent, 1000);
    }

    //Adding questions to Firebase
    @Override
    protected void onStart()
    {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {startActivity(new Intent(MainActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));}
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> city = new HashMap<>();

        //public firebase()
        city.put("Q1", "What is a hyperbole?");
        city.put("Q1 Answer", "An extreme or drawn-out exaggeration");
        city.put("Q1 option 1 " , "Recurring symbolic element in a story");
        city.put("Q1 option 2" , "Embellish of a simple sentence with details");
        city.put("Q1 option 3" , "A summarization of events");
        city.put("Q1 option 4" , "An extreme or drawn-out exaggeration");

        city.put("Q2", "What is a poem that uses the pattern of 3 lines, with lines that follow 5-7-5 syllables?");
        city.put("Q2 Answer", "Haiku");
        city.put("Q2 option 1 " , "Halibun");
        city.put("Q2 option 2" , "Haiku");
        city.put("Q2 option 3" , "Huitan");
        city.put("Q2 option 4" , "Hayku");

        city.put("Q3", "What is a poem with 5 stanzas, each with 3 lines with repeating alternating rhyme pattern?");
        city.put("Q3 Answer", "Villanelle");
        city.put("Q3 option 1 " , "Stornello");
        city.put("Q3 option 2" , "Terzanelle");
        city.put("Q3 option 3" , "Villanelle");
        city.put("Q3 option 4" , "Quintilla");

        city.put("Q4", "Who wrote Romeo and Juliet?");
        city.put("Q4 Answer", "William Shakespeare");
        city.put("Q4 option 1 " , "Oscar Wilde");
        city.put("Q4 option 2" , "Henrik Ibsen");
        city.put("Q4 option 3" , "John Webster");
        city.put("Q4 option 4" , "William Shakespeare");

        city.put("Q5", "What is the main character of the Odyssey?");
        city.put("Q5 Answer", "Odysseus");
        city.put("Q5 option 1 " , "Odysseus");
        city.put("Q5 option 2" , "Polyphemus");
        city.put("Q5 option 3" , "Circe");
        city.put("Q5 option 4" , "Calypso");

        city.put("Q6", "Which word rhymes with bough?");
        city.put("Q6 Answer", "Dough");
        city.put("Q6 option 1 " , "Through");
        city.put("Q6 option 2" , "Cough");
        city.put("Q6 option 3" , "Dough");
        city.put("Q6 option 4" , "Tough");

        city.put("Q7", "How many syllables are in caramel?");
        city.put("Q7 Answer", "3");
        city.put("Q7 option 1 " , "3");
        city.put("Q7 option 2" , "2");
        city.put("Q7 option 3" , "1");
        city.put("Q7 option 4" , "23");

        city.put("Q8", "Who wrote King Lear?");
        city.put("Q8 Answer", "William shakespeare");
        city.put("Q8 option 1 " , "Oscar Wilde");
        city.put("Q8 option 2" , "Henrik Ibsen");
        city.put("Q8 option 3" , "John Webster");
        city.put("Q8 option 4" , "William Shakespeare");

        city.put("Q9", "Who wrote Ride and Prejudice");
        city.put("Q9 Answer", "Jane Austin");
        city.put("Q9 option 1 " , "Virginia woolf");
        city.put("Q9 option 2" , "Jane Austin");
        city.put("Q9 option 3" , "Maya Angelou");
        city.put("Q9 option 4" , "J.K Rowling");

        city.put("Q10", "Which was written by Egar Allan Poe?");
        city.put("Q10 Answer", "The Raven");
        city.put("Q10 option 1 " , "The Raven Cycle");
        city.put("Q10 option 2" , "The Raven King");
        city.put("Q10 option 3" , "The Raven");
        city.put("Q10 option 4" , "The Raven Hair");
        db.collection("Quizzes").document("English").set(city).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {Toast.makeText(MainActivity.this, "Values added!", Toast.LENGTH_SHORT).show();}
            else {Toast.makeText(MainActivity.this, "Values failed to add.", Toast.LENGTH_SHORT).show();}
        });
        city.put("Q1", "What year did Christopher Columbus discover the Americas?");
        city.put("Q1 Answer", "1492");
        city.put("Q1 option 1 " , "1429");
        city.put("Q1 option 2" , "1776");
        city.put("Q1 option 3" , "1942");
        city.put("Q1 option 4" , "1492");

        city.put("Q2", "Who was the Roman emperor who stabbed the sea and declared war on Poseidon?");
        city.put("Q2 Answer", "Emperor Caligula");
        city.put("Q2 option 1 " , "Augustus");
        city.put("Q2 option 2" , "Claudius");
        city.put("Q2 option 3" , "Commodus");
        city.put("Q2 option 4" , "Emperor Caligula");

        city.put("Q3", "Who was the president of America during the Civil War?");
        city.put("Q3 Answer", "Abraham Lincoln");
        city.put("Q3 option 1 " , "Theodore Rosevelt");
        city.put("Q3 option 2" , "Abraham Lincoln");
        city.put("Q3 option 3" , "George Washington");
        city.put("Q3 option 4" , "John Adams");

        city.put("Q4", "Where was the attack during the WW2 era that sparked the US to enter the war?");
        city.put("Q4 Answer", "Pearl harbor, Hawaii");
        city.put("Q4 option 1 " , "Rhine River, Germany");
        city.put("Q4 option 2" , "Hiroshima, Japan");
        city.put("Q4 option 3" , "Pearl Harbor, Hawaii");
        city.put("Q4 option 4" , "Warsaw, Poland");

        city.put("Q5", "Which Greek god is considered to be the god of lightning?");
        city.put("Q5 Answer", "Zeus");
        city.put("Q5 option 1 " , "Poseidon");
        city.put("Q5 option 2" , "Zeus");
        city.put("Q5 option 3" , "Hades");
        city.put("Q5 option 4" , "Athena");

        city.put("Q6", "Who was the first ruler of the gods in Egyptian mythology");
        city.put("Q6 Answer", "Ra");
        city.put("Q6 option 1 " , "Osiris");
        city.put("Q6 option 2" , "Ra");
        city.put("Q6 option 3" , "Horus");
        city.put("Q6 option 4" , "Set");

        city.put("Q7", "Which was the largest empire in history?");
        city.put("Q7 Answer", "British");
        city.put("Q7 option 1 " , "British");
        city.put("Q7 option 2" , "Mongol");
        city.put("Q7 option 3" , "Roman");
        city.put("Q7 option 4" , "Ottoman");

        city.put("Q8", "Which was the longest empire in history?");
        city.put("Q8 Answer", "Roman");
        city.put("Q8 option 1 " , "Byzantine");
        city.put("Q8 option 2" , "Roman");
        city.put("Q8 option 3" , "Japanese");
        city.put("Q8 option 4" , "Zhou");

        city.put("Q9", "Which king was known for hiw amount of wives?");
        city.put("Q9 Answer", "Henry VIII");
        city.put("Q9 option 1 " , "Henry VI");
        city.put("Q9 option 2" , "Louis VII");
        city.put("Q9 option 3" , "Louis VI");
        city.put("Q9 option 4" , "Henry VIII");

        city.put("Q10", "how many oceans are in the world?");
        city.put("Q10 Answer", "5");
        city.put("Q10 option 1 " , "8");
        city.put("Q10 option 2" , "4");
        city.put("Q10 option 3" , "7");
        city.put("Q10 option 4" , "5");
        db.collection("Quizzes").document("History").set(city).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {Toast.makeText(MainActivity.this, "Values added!", Toast.LENGTH_SHORT).show();}
            else {Toast.makeText(MainActivity.this, "Values failed to add.", Toast.LENGTH_SHORT).show();}
        });
        city.put("Q1", "What is the square root of 25?");
        city.put("Q1 Answer", "5");
        city.put("Q1 option 1 " , "5");
        city.put("Q1 option 2" , "10");
        city.put("Q1 option 3" , "3");
        city.put("Q1 option 4" , "None of the Above");

        city.put("Q2", "What are the angles of a triangle equal to?");
        city.put("Q2 Answer", "180 Degrees");
        city.put("Q2 option 1 " , "90 Degrees");
        city.put("Q2 option 2" , "180 Degrees");
        city.put("Q2 option 3" , "60 Degrees");
        city.put("Q2 option 4" , "270 Degrees");

        city.put("Q3", "What is a dodecahedron?");
        city.put("Q3 Answer", "12-sided 3D shape");
        city.put("Q3 option 1 " , "12-sided 2D shape");
        city.put("Q3 option 2" , "20-sided 3D shape");
        city.put("Q3 option 3" , "10-sided 3D shape");
        city.put("Q3 option 4" , "12-sided 3D shape");

        city.put("Q4", "What is the Pythagorean Theorem");
        city.put("Q4 Answer", "a^2 + b^2 = c^2");
        city.put("Q4 option 1 " , "a^2 + b^2 = c^2");
        city.put("Q4 option 2" , "a^2 = b^2 + c^2");
        city.put("Q4 option 3" , "a^2 + b^2 = 0");
        city.put("Q4 option 4" , "a^2 - b^2 = c^2");

        city.put("Q5", "What is the answer to e^0?");
        city.put("Q5 Answer", "1");
        city.put("Q5 option 1 " , "e");
        city.put("Q5 option 2" , "e^0");
        city.put("Q5 option 3" , "1");
        city.put("Q5 option 4" , "0");

        city.put("Q6", "What is the Order of Operations?");
        city.put("Q6 Answer", "PEMDAS");
        city.put("Q6 option 1 " , "SADMEP");
        city.put("Q6 option 2" , "PEDMSA");
        city.put("Q6 option 3" , "PEMDAS");
        city.put("Q6 option 4" , "DASPEM");

        city.put("Q7", "What is the derivative of 4x^3 + 12x^2 - 6x + 7");
        city.put("Q7 Answer", "12x^2 + 24x - 6");
        city.put("Q7 option 1 " , "12x^2 + 24x + 7");
        city.put("Q7 option 2" , "4x^3 + 12x^2 - 6x");
        city.put("Q7 option 3" , "12x^2 + 24x + -6");
        city.put("Q7 option 4" , "4x^2 + 12x - 6");

        city.put("Q8", "Which is an irrational number?");
        city.put("Q8 Answer", "(10)^1/2");
        city.put("Q8 option 1 " , "(-1)^1/2");
        city.put("Q8 option 2" , "(10)^1/2");
        city.put("Q8 option 3" , "7/8");
        city.put("Q8 option 4" , "-3.4");

        city.put("Q9", "What is sin(x) / cos(x)");
        city.put("Q9 Answer", "tan(x)");
        city.put("Q9 option 1 " , "cot(x)");
        city.put("Q9 option 2" , "tan(x)");
        city.put("Q9 option 3" , "sec(x)");
        city.put("Q9 option 4" , "1");

        city.put("Q10", "What is x equal to for 4x^2 - 6x + 2?");
        city.put("Q10 Answer", "-1/2 , -1");
        city.put("Q10 option 1 " , "1/2 , 1");
        city.put("Q10 option 2" , "1/2 , -1");
        city.put("Q10 option 3" , "-1/2 , -1");
        city.put("Q10 option 4" , "-1/2 , 1");
        db.collection("Quizzes").document("Math").set(city).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {Toast.makeText(MainActivity.this, "Values added!", Toast.LENGTH_SHORT).show();}
            else {Toast.makeText(MainActivity.this, "Values failed to add.", Toast.LENGTH_SHORT).show();}
        });
        city.put("Q1", "What is the Periodic Symbol for Iron");
        city.put("Q1 Answer", "Fe");
        city.put("Q1 option 1 " , "In");
        city.put("Q1 option 2" , "Fr");
        city.put("Q1 option 3" , "Ir");
        city.put("Q1 option 4" , "Fe");

        city.put("Q2", "What is the word to describe the process of a flower absorbing sunlight to make energy for itself?");
        city.put("Q2 Answer", "Photosynthesis");
        city.put("Q2 option 1 " , "Philadelphus");
        city.put("Q2 option 2" , "Fibromyalgia");
        city.put("Q2 option 3" , "Photosynthesis");
        city.put("Q2 option 4" , "Photropism");

        city.put("Q3", "How many Alkali metals are there?");
        city.put("Q3 Answer", "6");
        city.put("Q3 option 1 " , "5");
        city.put("Q3 option 2" , "6");
        city.put("Q3 option 3" , "8");
        city.put("Q3 option 4" , "10");

        city.put("Q4", "How many man-made elements are there?");
        city.put("Q4 Answer", "26");
        city.put("Q4 option 1 " , "4");
        city.put("Q4 option 2" , "6");
        city.put("Q4 option 3" , "16");
        city.put("Q4 option 4" , "26");

        city.put("Q5", "What is the range of all types of EM radiation called");
        city.put("Q5 Answer", "Electromagnetic Spectrum");
        city.put("Q5 option 1 " , "Empirical Samarium");
        city.put("Q5 option 2" , "Electromagnetic Spectrum");
        city.put("Q5 option 3" , "Endothermic Mutation");
        city.put("Q5 option 4" , "Excretion Mimicry");

        city.put("Q6", "How many bones rae in the adult human body?");
        city.put("Q6 Answer", "206");
        city.put("Q6 option 1 " , "300");
        city.put("Q6 option 2" , "260");
        city.put("Q6 option 3" , "106");
        city.put("Q6 option 4" , "206");

        city.put("Q7", "How many systems run in the human body?");
        city.put("Q7 Answer", "11");
        city.put("Q7 option 1 " , "16");
        city.put("Q7 option 2" , "11");
        city.put("Q7 option 3" , "10");
        city.put("Q7 option 4" , "20");

        city.put("Q8", "What is a vital organ?");
        city.put("Q8 Answer", "Liver");
        city.put("Q8 option 1 " , "Stomach");
        city.put("Q8 option 2" , "Intestines");
        city.put("Q8 option 3" , "Liver");
        city.put("Q8 option 4" , "Pancreas");

        city.put("Q9", "What is the order of classifications?");
        city.put("Q9 Answer", "Kingdom, Phylum, Class, Order, Family, Genus, Species");
        city.put("Q9 option 1 " , "Domain, Kingdom, Phylum, Family, Genus, and Species");
        city.put("Q9 option 2" , "Kingdom, Phylum, Class, Order, Family, Genus, Species");
        city.put("Q9 option 3" , "Domain, Phylum, Class, Order, Family, Genus, Species");
        city.put("Q9 option 4" , "Domain, Phylum, Class, Order, Family, Genus, Species");

        city.put("Q10", "What do animal cells have that plant cells don't");
        city.put("Q10 Answer", "Lysosomes");
        city.put("Q10 option 1 " , "Cell Wall");
        city.put("Q10 option 2" , "Chloroplasts");
        city.put("Q10 option 3" , "Vacuole");
        city.put("Q10 option 4" , "Lysosomes");
        db.collection("Quizzes").document("Science").set(city).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {Toast.makeText(MainActivity.this, "Values added!", Toast.LENGTH_SHORT).show();}
            else {Toast.makeText(MainActivity.this, "Values failed to add.", Toast.LENGTH_SHORT).show();}
        });
    }}