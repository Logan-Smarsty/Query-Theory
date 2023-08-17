package com.example.iron_deers_query_theory.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.iron_deers_query_theory.Classes.QuestionBuild;
import com.example.iron_deers_query_theory.Fragments.CategoryFragment;
import com.example.iron_deers_query_theory.Fragments.ScoresFragment;
import com.example.iron_deers_query_theory.R;
import com.example.iron_deers_query_theory.databinding.ScienceQuestionBinding;

import java.util.ArrayList;

public class ScienceQuestion extends AppCompatActivity
{
    ArrayList<QuestionBuild> list = new ArrayList<>();
    ScienceQuestionBinding binding;
    private int count = 0;
    private int position = 0;
    private int score = 0;

    private String dog = score + "/10";

    Button selectedOption;

    CountDownTimer timer;

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ScienceQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        resetTimer();
        timer.start();

        list.add(new QuestionBuild("Q1: What is the Periodic Symbol for Iron?",
                "In", "Fr", "Ir", "Fe", "Fe"));

        list.add(new QuestionBuild("Q2: What is the word to describe the process of a flower absorbing sunlight to make energy for itself?",
                "Philadelphus", "Fibromyalgia", "Photosynthesis", "Phototropism", "Photosynthesis"));

        list.add(new QuestionBuild("Q3: How many Alkali metals are there?",
                "5", "6", "8", "10", "6"));

        list.add(new QuestionBuild("Q4: How many man-made elements are there?",
                "4", "6", "16", "26", "26"));

        list.add(new QuestionBuild("Q5: What is the range of all types of EM radiation called?",
                "Empirical Samarium", "Electromagnetic Spectrum", "Endothermic Mutation", "Excretion Mimicry", "Electromagnetic Spectrum"));

        list.add(new QuestionBuild("Q6: How many bones are in the adult human body?",
                "300", "260", "106", "206", "206"));

        list.add(new QuestionBuild("Q7: How many systems run the human body?",
                "16", "11", "10", "20", "11"));

        list.add(new QuestionBuild("Q8: Which one of the following is a vital organ?",
                "Stomach", "Intestines", "Liver", "Pancreas", "Liver"));

        list.add(new QuestionBuild("Q9: What is the order of classifications?",
                "Domain, Kingdom, Phylum, Family, Genus, and Species", "Kingdom, Phylum, Class, Order, Family, Genus, Species",
                "Domain, Phylum, Class, Order, Family, Genus, Species", "Kingdom, Phylum, Order, Family, Class, Genus, Species",
                "Kingdom, Phylum, Class, Order, Family, Genus, Species"));

        list.add(new QuestionBuild("Q10: What do animal cells have that plant cells do not?",
                "Cell Wall", "Chloroplasts", "Vacuole", "Lysosomes", "Lysosomes"));
        Button quit = findViewById(R.id.Quit_btn);

        quit.setOnClickListener(v ->
        {
            Intent intent = new Intent(ScienceQuestion.this, CategoryFragment.class);
            startActivity(intent);
        });

        for(int i = 0; i < 4; i ++)
        {
            binding.OptionContainer.getChildAt(i).setOnClickListener(v -> checkAnswer((Button) v));
        }

        playAnimation(binding.Question, 0,list.get(position).getQuestion());

        binding.NextBtn.setOnClickListener(v ->
        {
            if(timer != null)
            {
                timer.cancel();
            }
            assert timer != null;
            timer.start();

            binding.NextBtn.setEnabled(false);
            binding.NextBtn.setAlpha((float)0.3);
            enableOption();
            position ++;

            if(position == list.size())
            {
                Intent intent = new Intent(ScienceQuestion.this, ScoresFragment.class);
                intent.putExtra("score", score);
                intent.putExtra("total",list.size());
                startActivity(intent);
                finish();
                return;
            }
            count = 0;

            playAnimation(binding.Question, 0, list.get(position).getQuestion());
        });
    }
    private void resetTimer()
    {
        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished)
            {
                binding.Time.setText(String.valueOf(millisUntilFinished/1000));
            }
            @Override
            public void onFinish()
            {
                Dialog dialog = new Dialog(ScienceQuestion.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.out_of_time_screen);
                dialog.findViewById(R.id.Try_again_btn).setOnClickListener(v ->
                {
                    Intent intent = new Intent(ScienceQuestion.this, CategoryFragment.class);
                    startActivity(intent);
                    finish();
                });
                dialog.show();
            }
        };
    }
    private void playAnimation(View view, int value, String data)
    {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation)
                    {
                        if(value == 0 && count <4){

                            String option = "";

                            if(count == 0)
                            {
                                option = list.get(position).getOpt1();
                            }
                            else if (count == 1)
                            {
                                option = list.get(position).getOpt2();
                            }
                            else if (count == 2)
                            {
                                option = list.get(position).getOpt3();
                            }
                            else if (count == 3)
                            {
                                option = list.get(position).getOpt4();
                            }
                            playAnimation(binding.OptionContainer.getChildAt(count), 0, option);
                            count ++;
                        }
                    }
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onAnimationEnd(@NonNull Animator animation)
                    {
                        if(value == 0)
                        {
                            try
                            {
                                ((TextView)view).setText(data);
                                binding.QuestionNums.setText(position + 1 + "/" + list.size());
                            }
                            catch (Exception e)
                            {
                                ((Button)view).setText(data);
                            }
                            view.setTag(data);
                            playAnimation(view, 1, data);
                        }
                    }
                    @Override
                    public void onAnimationCancel(@NonNull Animator animation)
                    {

                    }
                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation)
                    {

                    }





                });
    }
    private void enableOption()
    {
        for(int i = 0; i <4; i++)
        {
            binding.OptionContainer.getChildAt(i).setEnabled(true);

            binding.OptionContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_option);
        }
    }
    private void checkAnswer(Button selectedOption)
    {
        if(timer != null)
        {
            timer.cancel();
        }
        binding.NextBtn.setEnabled(true);
        binding.NextBtn.setAlpha(1);

        if(selectedOption.getText().toString().equals(list.get(position).getCorrectAnswer()))
        {
          score++;
            selectedOption.setBackgroundResource(R.drawable.back_color_green);



            //Code to Display the Current Score
            TextView cat = (TextView)findViewById(R.id.scores);
            cat.setText("      Score:" + score  + "/10");



        }
        else
        {
            selectedOption.setBackgroundResource(R.drawable.back_color_red);

            Button correctOption = binding.OptionContainer.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundResource(R.drawable.back_color_green);
        }
    }




}









