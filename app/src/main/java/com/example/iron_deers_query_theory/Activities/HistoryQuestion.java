package com.example.iron_deers_query_theory.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.iron_deers_query_theory.Classes.QuestionBuild;
import com.example.iron_deers_query_theory.Fragments.ScoresFragment;
import com.example.iron_deers_query_theory.R;
import com.example.iron_deers_query_theory.databinding.HistoryQuestionBinding;

import java.util.ArrayList;

public class HistoryQuestion extends AppCompatActivity
{

    ArrayList<QuestionBuild> list = new ArrayList<>();
    HistoryQuestionBinding binding;
    private int count = 0;
    private int position = 0;
    private int score = 0;

    CountDownTimer timer;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = HistoryQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list.add(new QuestionBuild("What year did Christopher Columbus discover the Americas?",
                "1429", "1776", "1942", "1492", "1492"));

        list.add(new QuestionBuild("Who was the Roman emperor who stabbed the sea and declared war on Poseidon?",
                "Augustus", "Claudius", "Commodus", "Emperor Caligula", "Emperor Caligula"));

        list.add(new QuestionBuild("Who was the President of America during the civil war?",
                "Theodore Roosevelt", "Abraham Lincoln", "George Washington", "John Adams", "Abraham Lincoln"));

        list.add(new QuestionBuild("Where was the attack during the WW2 era that sparked the US to enter the war?",
                "Rhine River, Germany", "Hiroshima, Japan", "Pearl Harbor, Hawaii", "Warsaw, Poland", "Pearl Harbor, Hawaii"));

        list.add(new QuestionBuild("Which Greek god is considered to be the God of lightning?",
                "Poseidon", "Zeus", "Hades", "Athena", "Zeus"));

        list.add(new QuestionBuild("Who was the first ruler of the gods in Egyptian mythology?",
                "Osiris", "Ra", "Horus", "Set", "Ra"));

        list.add(new QuestionBuild("Which one of the following was the largest empire in history?",
                "British", "Mongol", "Roman", "Ottoman", "British"));

        list.add(new QuestionBuild("Which one of the following was the longest empire in history?",
                "Byzantine", "Roman", "Japanese", "Zhou", "Roman"));

        list.add(new QuestionBuild("Which king was known for his amount of wives?",
                "Henry VI", "Louis VIII", "Louis VI", "Henry VIII", "Henry VIII"));

        list.add(new QuestionBuild("How many oceans are in the world?",
                "8", "4", "7", "5", "5"));


        Button quit = findViewById(R.id.Quit_btn);

        quit.setOnClickListener(v ->
        {
            Intent intent = new Intent(HistoryQuestion.this, CategoryUpdate.class);
            startActivity(intent);
        });

        for(int i = 0; i < 4; i ++)
        {
            binding.OptionContainer.getChildAt(i).setOnClickListener(v -> checkAnswer((Button) v));
        }

        playAnimation(binding.Question, 0,list.get(position).getQuestion());

        binding.NextBtn.setOnClickListener(v -> {


            binding.NextBtn.setEnabled(false);
            binding.NextBtn.setAlpha((float)0.3);
            enableOption();
            position ++;

            if(position == list.size())
            {
                Intent intent = new Intent(HistoryQuestion.this, ScoresFragment.class);
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
        binding.NextBtn.setEnabled(true);
        binding.NextBtn.setAlpha(1);

        if(selectedOption.getText().toString().equals(list.get(position).getCorrectAnswer()))
        {
            score ++;
            selectedOption.setBackgroundResource(R.drawable.back_color_green);
        }
        else
        {
            selectedOption.setBackgroundResource(R.drawable.back_color_red);

            Button correctOption = (Button) binding.OptionContainer.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundResource(R.drawable.back_color_green);
        }
    }

}