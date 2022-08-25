package com.example.trlblzrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyLibrary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_library);
    }

    public void openActivity(View v){
        Intent i =new Intent(MyLibrary.this,LibrarySubjects.class);
        startActivity(i);
    }
}