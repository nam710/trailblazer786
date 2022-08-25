package com.example.trlblzrs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginpage extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button btn_login;
    String EmailPattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    android.app.ProgressDialog ProgressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        editTextEmail=findViewById(R.id.Email);
        editTextPassword=findViewById(R.id.PASSWORD);

        btn_login.setOnClickListener(v -> PerformLogin());

    }

    private void PerformLogin() {
        String Email=editTextEmail.getText().toString();
        String Password=editTextPassword.getText().toString();

        if(!Email.matches(EmailPattern))
        {
            editTextEmail.setError("Enter a Valid Email Address");
        }
        else if(Password.isEmpty()||Password.length()<6)
        {
            editTextPassword.setError("Enter a valid password with at least 6 characters");
        }
        else {
            ProgressDialog.setMessage("ENTERING THE SCHOOL GATE!");
            ProgressDialog.setTitle("LOGGING IN.....");
            ProgressDialog.setCanceledOnTouchOutside(false);
            ProgressDialog.show();

            mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                                    
                }
            });
        }
    }
}