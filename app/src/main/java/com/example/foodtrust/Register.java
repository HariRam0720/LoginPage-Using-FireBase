package com.example.foodtrust;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText name, email,pass;
    Button btn ;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;
    FirebaseUser fbUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.r_name);
        email = findViewById(R.id.r_email);
        pass = findViewById(R.id.r_pass);
        btn = findViewById(R.id.register_btn);
        firebaseAuth  = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n,e,p;
                n=name.getText().toString();
                e=email.getText().toString();
                p=pass.getText().toString();
                if(n.isEmpty()&&e.isEmpty()&&p.isEmpty()){
                    Toast.makeText(Register.this,"Check the Given inputs",Toast.LENGTH_SHORT).show();
                }else
                {
                        firebaseAuth.createUserWithEmailAndPassword(e,p)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        HashMap<String,String> user =new HashMap<>();
                                        user.put("Name",n);
                                        fbUser = firebaseAuth.getCurrentUser();
                                      String d = fbUser.getUid();
                                        firestore.collection("users").document(d).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Intent i = new Intent(Register.this,Dashboard.class);
                                                startActivity(i);
                                            }
                                        });
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                    }
                                });
                }
            }
        });

    }
}