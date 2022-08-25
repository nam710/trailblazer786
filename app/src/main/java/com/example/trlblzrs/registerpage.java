package com.example.trlblzrs;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registerpage extends AppCompatActivity {

 EditText editTextName, editTextEmail, editTextPassword;
 Button btn_student, btn_teacher;
 String EmailPattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
 ProgressDialog ProgressDialog;
 FirebaseAuth mAuth;
 FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        //TextView lgnbtn=findViewById(R.id.textView5);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextName=findViewById(R.id.editTextName);
        editTextPassword=findViewById(R.id.editTextPassword);
        btn_student=findViewById(R.id.buttonStudent);
        mAuth=FirebaseAuth.getInstance();
        mUser=FirebaseAuth.getInstance().getCurrentUser();
        ProgressDialog=new ProgressDialog(this);

        btn_student.setOnClickListener(view -> {
            performAuth();
        });

    }

    private void performAuth() {
        String Email=editTextEmail.getText().toString();
        String Password=editTextPassword.getText().toString();
        String Name=editTextName.getText().toString();

        if(!Email.matches(EmailPattern))
        {
            editTextEmail.setError("Enter a Valid Email Address");
        }
        else if(Password.isEmpty()||Password.length()<6)
        {
            editTextPassword.setError("Enter a valid password with at least 6 characters");
        }
        else
        {
            ProgressDialog.setMessage("'Knowledge raises the low while ignorance brings down the mighty.'");
            ProgressDialog.setTitle("Registering...");
            ProgressDialog.setCanceledOnTouchOutside(false);
            ProgressDialog.show();

            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(task -> {

                if(task.isSuccessful())
                {
                    ProgressDialog.dismiss();
                    SendUserToNextActivity();
                    Toast.makeText(registerpage.this,"SUCCESSFULLY REGISTERED!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ProgressDialog.dismiss();
                    Toast.makeText(registerpage.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void SendUserToNextActivity() {
        Intent intent=new Intent(registerpage.this,MainActivity.class);
        intent.setFlags(FLAG_ACTIVITY_CLEAR_TASK| FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}