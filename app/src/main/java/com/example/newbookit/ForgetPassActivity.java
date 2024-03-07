package com.example.newbookit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassActivity extends AppCompatActivity {

    Button btnForgotPass;
    EditText etUserEmail;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);


        btnForgotPass = (Button) findViewById(R.id.btnForgotPass);
        etUserEmail = (EditText) findViewById(R.id.etUserEmail);


        firebaseAuth = FirebaseAuth.getInstance();

        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUserEmail.getText().toString().trim() == null)
                {
                    firebaseAuth.sendPasswordResetEmail(etUserEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgetPassActivity.this,"Password send to your email", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ForgetPassActivity.this,LoginActivity.class));
                                finish();
                            }
                            else {
                                Toast.makeText(ForgetPassActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(ForgetPassActivity.this,"Enter your email", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

}