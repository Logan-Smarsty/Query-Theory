package com.example.iron_deers_query_theory.Activities;

import static com.example.iron_deers_query_theory.R.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.iron_deers_query_theory.Fragments.CategoryFragment;
import com.example.iron_deers_query_theory.Fragments.HomeScreen_Fragment;
import com.example.iron_deers_query_theory.Fragments.ScoresFragment;
import com.example.iron_deers_query_theory.Fragments.SettingsFragment;
import com.example.iron_deers_query_theory.databinding.ActivityCategoryUpdateBinding;

public class CategoryUpdate extends AppCompatActivity
{
    ActivityCategoryUpdateBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeScreen_Fragment());

       binding.bottomNavigationView.setOnItemSelectedListener(item ->
       {
           int itemId = item.getItemId();
           if (itemId == id.category)
           {
               replaceFragment(new CategoryFragment());
           }
           else if (itemId == id.home)
           {
               replaceFragment(new HomeScreen_Fragment());
           }
           else if (itemId == id.settings)
           {
               replaceFragment(new SettingsFragment());
           }
           else if (itemId == id.scores)
           {
               replaceFragment(new ScoresFragment());
           }
           return true;
       });


    }
    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}