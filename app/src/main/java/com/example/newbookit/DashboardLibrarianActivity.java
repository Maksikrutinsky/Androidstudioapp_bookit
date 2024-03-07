package com.example.newbookit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardLibrarianActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    TextView subTitleTvLib;
    ImageButton logoutBtnLib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_librarian);


        subTitleTvLib = (TextView)findViewById(R.id.subTitleTvLib);
        logoutBtnLib = (ImageButton)findViewById(R.id.logoutBtnLib);
        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();

        logoutBtnLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                checkUser();
            }
        });

    }

    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        else {
            String email = firebaseUser.getEmail();
            subTitleTvLib.setText(email);
        }
    }

}