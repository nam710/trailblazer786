package com.example.trlblzrs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
        b=findViewById(R.id.button2);
        clas= (TextInputEditText) findViewById(R.id.cla);
        sub=findViewById(R.id.sub);
        reference= FirebaseDatabase.getInstance().getReference();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);
        MyList=new ArrayList<>();
        b.setOnClickListener(v -> {
            uploadList(clas.getText().toString(),sub.getText().toString());
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