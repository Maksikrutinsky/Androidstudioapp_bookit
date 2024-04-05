package com.technifysoft.bookapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.technifysoft.bookapp.R;

public class ErrorActivity extends AppCompatActivity {


    Button btnReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_error);


        btnReport = (Button) findViewById(R.id.sendReportButton);

        btnReport.setOnClickListener(view -> {
            reportProblem();
        });

    }

    private void reportProblem(){

        String email = "Gal-ta@windowslive.com";
        String subject = "Reporting for app "+getString(R.string.app_name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,"");

        startActivity(Intent.createChooser(intent,"Choose an email client:"));
    }
}