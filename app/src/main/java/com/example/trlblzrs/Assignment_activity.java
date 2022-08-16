package com.example.trlblzrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.trlblzrs.databinding.ActivityMainBinding;

public class Assignment_activity extends AppCompatActivity {


    RadioGroup radioGroup;
    RadioButton writeAssignmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        radioGroup = findViewById(R.id.radiogrp);
        writeAssignmentBtn = findViewById(R.id.typeAssignment);
        writeAssignmentBtn.setChecked(true);
        replaceFragment(new Write_assignment_fragment());



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioBtn = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioBtn);

                switch (index){
                    case 0:
                        replaceFragment(new Write_assignment_fragment());
                        break;
                    case 1:
                        replaceFragment(new Upload_assignment_fragment());
                        break;

                }
            }
        });




    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}