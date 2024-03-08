package com.example.newbookit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardAdminActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    TextView subTitleTv;
    ImageButton logoutBtn;

    Button addCategoryBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);


        subTitleTv = (TextView)findViewById(R.id.subTitleTv);
        logoutBtn = (ImageButton)findViewById(R.id.logoutBtn);
        addCategoryBtn = (Button)findViewById(R.id.addCategoryBtn);
        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                checkUser();
            }
        });
        //handle Click,start Book add screen
        addCategoryBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardAdminActivity.this,CategoryAddActivity.class));
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
            subTitleTv.setText(email);
        }
    }
}