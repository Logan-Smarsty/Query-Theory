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
import com.example.iron_deers_query_theory.databinding.EnglishQuestionBinding;

import java.util.ArrayList;

public class EnglishQuestion extends AppCompatActivity
{
    ArrayList<QuestionBuild> list = new ArrayList<>();
    EnglishQuestionBinding binding;
    private int count = 0;
    private int position = 0;
    private int score = 0;

    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = EnglishQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        resetTimer();
        timer.start();

        list.add(new QuestionBuild("Q1: What is hyperbole?",
                "Recurring symbolic element in a story", "Embellish of a simple sentence with details",
                "A summarization of events", "An extreme or drawn-out exaggeration", "An extreme or drawn-out exaggeration"));

        list.add(new QuestionBuild("Q2: What is a poem that uses the pattern of 3 lines, with lines that follow 5-7-5 syllables?",
                "Haibun", "Haiku", "Huitain", "Hayku", "Haiku"));

        list.add(new QuestionBuild("Q3: What is a poem with 5 stanzas, each with 3 lines with a repeating alternating rhyme pattern?",
                "Stornello", "Terzanelle", "Villanelle", "Quintilla", "Villanelle"));

        list.add(new QuestionBuild("Q4: Who wrote Romeo and Juliet?",
                "Oscar Wilde", "Henrik Ibsen", "John Webster", "William Shakespeare", "William Shakespeare"));

        list.add(new QuestionBuild("Q5: Who is the main character of the Odyssey?",
                "Odysseus", "Polyphemus", "Circe", "Calypso", "Odysseus"));

        list.add(new QuestionBuild("Q6: Which word rhymes with bough?",
                "Through", "Cough", "Dough", "Tough", "Dough"));

        list.add(new QuestionBuild("Q7: How many syllables are in caramel?",
                "3", "2", "1", "23", "3"));

        list.add(new QuestionBuild("Q8: Who wrote King Lear?",
                "Oscar Wilde", "Henrik Ibsen", "John Webster", "William Shakespeare", "William Shakespeare"));

        list.add(new QuestionBuild("Q9: Who wrote Pride and Prejudice?",
                "Virginia Woolf", "Jane Austin", "Maya Angelou", "J. K. Rowling", "Jane Austin"));

        list.add(new QuestionBuild("Q10: Which one of the following was written by Edgar Allan Poe?",
                "The Raven Cycle", "The Raven King", "The Raven", "The Raven Heir", "The Raven"));

        Button quit = findViewById(R.id.Quit_btn);

        quit.setOnClickListener(v ->
        {
            Intent intent = new Intent(EnglishQuestion.this, CategoryUpdate.class);
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
                Intent intent = new Intent(EnglishQuestion.this, ScoresFragment.class);
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
                Dialog dialog = new Dialog(EnglishQuestion.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.out_of_time_screen);
                dialog.findViewById(R.id.Try_again_btn).setOnClickListener(v -> {
                    Intent intent = new Intent(EnglishQuestion.this, CategoryFragment.class);
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
            score ++;
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