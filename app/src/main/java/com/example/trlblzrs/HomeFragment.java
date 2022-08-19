package com.example.trlblzrs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Context thisContext;
    private Button createClassBtn;
    private Button timeTableBtn;
    CalendarView calendarView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ArrayList<ClassModel> holder;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        createClassBtn = (Button) view.findViewById(R.id.button);
        createClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inflater.getContext(),Create_Class.class);
                startActivity(intent);

            }
        });

        timeTableBtn = (Button)view.findViewById(R.id.timeTableEditBtn);
        timeTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inflater.getContext(), Timetable.class);
                startActivity(intent);
            }
        });

        calendarView = container.findViewById(R.id.my_calendar);


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        holder = new ArrayList<>();


        ClassModel ob1 = new ClassModel("Class 10", "Computers");
        holder.add(ob1);
        ClassModel ob2 = new ClassModel("Class 11", "Guest Lecture");
        holder.add(ob2);
        ClassModel ob3 = new ClassModel("Class 10", "English");
        holder.add(ob3);
        ClassModel ob4 = new ClassModel("Class 12", "Mathematics");
        holder.add(ob4);
        ClassModel ob5 = new ClassModel("Class 11", "Chemistry");
        holder.add(ob5);
        ClassModel ob6 = new ClassModel("Class 11", "Biology");
        holder.add(ob6);
        ClassModel ob7 = new ClassModel("Class 12", "Physics");
        holder.add(ob7);

        recyclerView.setAdapter(new RecyclerAdapterClass(holder));
        thisContext = inflater.getContext();


        return view;
    }




}