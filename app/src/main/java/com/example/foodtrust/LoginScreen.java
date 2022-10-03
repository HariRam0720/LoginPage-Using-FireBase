package com.example.foodtrust;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {
    private  Button login,register;
   private EditText email,pass;
   private ProgressBar progressBar;
   FirebaseAuth fbAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        fbAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.login_btn);
        register =findViewById(R.id.register_btn);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        progressBar = findViewById(R.id.progress_loader);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginScreen.this,Register.class);
                startActivity(i);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p = pass.getText().toString();
                if(e.isEmpty()&&p.isEmpty()){
                    Toast.makeText(LoginScreen.this,"Check User Name and Password",Toast.LENGTH_SHORT).show();
                }else
                {


                fbAuth.signInWithEmailAndPassword(e,p)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(LoginScreen.this,"Success",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginScreen.this,Dashboard.class);
                        startActivity(i);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginScreen.this,"Error",Toast.LENGTH_SHORT).show();

                            }
                        });

                }
            }
        });
    }
}