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

import com.example.iron_deers_query_theory.Fragments.CategoryFragment;
import com.example.iron_deers_query_theory.Fragments.ScoresFragment;
import com.example.iron_deers_query_theory.Classes.QuestionBuild;
import com.example.iron_deers_query_theory.R;
import com.example.iron_deers_query_theory.databinding.MathQuestionBinding;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MathQuestion extends AppCompatActivity
{
    ArrayList<QuestionBuild> list = new ArrayList<>();
    MathQuestionBinding binding;
    private int count = 0;
    private int position = 0;
    private int score = 0;

    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = MathQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        resetTimer();
        timer.start();

        list.add(new QuestionBuild("Q1: What is the square root of 25?",
                "5", "10", "3", "None of the above", "5"));

        list.add(new QuestionBuild(" Q2: What are the angles of a triangle equal to?",
                "90 degrees", "180 degrees", "60 degrees", "270 degrees", "180 degrees"));

        list.add(new QuestionBuild("Q3: What is a dodecahedron?",
                "12-sided 2D shape", "20-sided 3D shape", "10-sided 3D shape", "12-sided 3D shape", "12-sided 3D shape"));

        list.add(new QuestionBuild("Q4: What is the Pythagorean Theorem?",
                "a^2 + b^2 = c^2", "a^2 = b^2 + c^2", "a^2 + b^2 = 0", "a^2 - b^2 = c^2", "a^2 + b^2 = c^2"));

        list.add(new QuestionBuild("Q5: What is the answer to e^0?",
                "e", "e^0", "1", "0", "0"));

        list.add(new QuestionBuild(" Q6: What is the Order of Operations?", "SADMEP", "PEDMSA", "PEMDAS", "DASPEM", "PEMDAS"));

        list.add(new QuestionBuild("Q7: What is the derivative of 4x^3 + 12x^2 - 6x + 7?",
                "12x^2 + 24x + 7", "4x^3 + 12x^2 - 6x", "12x^2 + 24x - 6", "4x^2 + 12x - 6", "12x^2 + 24x - 6"));

        list.add(new QuestionBuild("Q8: Which one of the following is an irrational number?",
                "√-1", "√10", "-3.4", "⅞", "√10"));

        list.add(new QuestionBuild("Q9: What is sin(x)/cos(x)?",
                "cot(x)", "tan(x)", "sec(x)", "1", "tan(x)"));

        list.add(new QuestionBuild("Q10: What is x equal to for 0 = 4x^2 - 6x + 2?",
                "½, 1", "½, -1", "-½, -1", "-½, 1", "-½, -1"));

        Button quit = findViewById(R.id.Quit_btn);

        quit.setOnClickListener(v ->
        {
            Intent intent = new Intent(MathQuestion.this, ScoresFragment.class);
            startActivity(intent);
        });

        for(int i = 0; i < 4; i ++)
        {
            binding.OptionContainer.getChildAt(i).setOnClickListener(v -> checkAnswer((Button) v));
        }
        playAnimation(binding.Question, 0,list.get(position).getQuestion());

        binding.NextBtn.setOnClickListener(v ->
        {
            if(timer != null) {timer.cancel();}
            assert timer != null;
            timer.start();

            binding.NextBtn.setEnabled(false);
            binding.NextBtn.setAlpha((float)0.3);
            enableOption();
            position ++;

            if(position == list.size())
            {
                Intent intent = new Intent(MathQuestion.this, ScoresFragment.class);
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
        timer = new CountDownTimer(30000, 3000) {
            @Override
            public void onTick(long millisUntilFinished)
            {
                binding.Time.setText(String.valueOf(millisUntilFinished/1000));
            }
            @Override
            public void onFinish()
            {
                Dialog dialog = new Dialog(MathQuestion.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.out_of_time_screen);
                dialog.findViewById(R.id.Try_again_btn).setOnClickListener(v ->
                {
                    Intent intent = new Intent(MathQuestion.this, CategoryFragment.class);
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
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener()
                {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation)
                    {
                        if(value == 0 && count <4)
                        {
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
                    public void onAnimationCancel(@NonNull Animator animation) { }
                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) { }
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
    @SuppressLint("SetTextI18n")
    private void checkAnswer(Button selectedOption)
    {
        if(timer != null) {timer.cancel();}
        binding.NextBtn.setEnabled(true);
        binding.NextBtn.setAlpha(1);

        if(selectedOption.getText().toString().equals(list.get(position).getCorrectAnswer()))
        {
            score ++;
            selectedOption.setBackgroundResource(R.drawable.back_color_green);
            //Code to Display the Current Score
            TextView cat = findViewById(R.id.scores);
            cat.setText("Score:" + score  + "/10");
        }
        else
        {
            selectedOption.setBackgroundResource(R.drawable.back_color_red);
            Button correctOption = binding.OptionContainer.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundResource(R.drawable.back_color_green);
        }
        FirebaseDatabase.getInstance().getReference().child("Math").push().child("Score").setValue(score);
    }
}