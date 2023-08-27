package com.example.iron_deers_query_theory.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iron_deers_query_theory.Activities.EnglishQuestion;
import com.example.iron_deers_query_theory.Activities.HistoryQuestion;
import com.example.iron_deers_query_theory.Activities.MathQuestion;
import com.example.iron_deers_query_theory.Activities.ScienceQuestion;
import com.example.iron_deers_query_theory.R;
/*
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public CategoryFragment() { }
    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {}
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        CardView Math = view.findViewById(R.id.math_cardview);
        CardView History = view.findViewById(R.id.history_cardview);
        CardView English = view.findViewById(R.id.english_cardview);
        CardView Science = view.findViewById(R.id.science_cardview);

        English.setOnClickListener(v ->
        {
           Intent intent = new Intent(getActivity(), EnglishQuestion.class);
           startActivity(intent);
        });
        Math.setOnClickListener(v ->
        {
            Intent intent = new Intent(getActivity(), MathQuestion.class);
            startActivity(intent);
        });
        Science.setOnClickListener(v ->
        {
            Intent intent = new Intent(getActivity(), ScienceQuestion.class);
            startActivity(intent);
        });
        History.setOnClickListener(v ->
        {
            Intent intent = new Intent(getActivity(), HistoryQuestion.class);
            startActivity(intent);
        });
        return view;
    }
}