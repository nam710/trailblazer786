package com.example.trlblzrs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Create_Class extends AppCompatActivity {

    List<String> MyList;
    Button b;
    TextInputEditText clas,sub;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);
        b = findViewById(R.id.createClassBtn);
        clas = (TextInputEditText) findViewById(R.id.cla);
        sub = findViewById(R.id.sub);
        reference = FirebaseDatabase.getInstance().getReference();
        MyList = new ArrayList<>();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadList(clas.getText().toString(), sub.getText().toString());
                Intent i = new Intent(Create_Class.this,MainActivity.class);
                startActivity(i);
            }
        });
    }


    public void uploadList(String s1, String s2) {
        MyList.add(s1+" "+s2);
        reference.setValue(MyList).addOnCompleteListener(task -> {
            if(task.isSuccessful())
            {
                Toast.makeText(getApplicationContext(),"Class has been created",Toast.LENGTH_SHORT).show();
            }
            else
            {
                    Toast.makeText(getApplicationContext(),"Retry After Some Time!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}