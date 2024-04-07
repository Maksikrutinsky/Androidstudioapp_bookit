package com.technifysoft.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.technifysoft.bookapp.databinding.ActivityTermsOfUseBinding;

public class Terms_ofUseActivity extends AppCompatActivity {

    private ActivityTermsOfUseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermsOfUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // הוספת כותרת לפעילות תנאי השימוש
        setTitle("תנאי שימוש");

        // הגדרת התוכן של תנאי השימוש
        String termsOfUseContent = " \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +\n" +
                "                \"כאן יש להוסיף את תוכן תנאי השימוש.\\n\" +.";
        binding.termsOfUseContent.setText(termsOfUseContent);

        // הוספת האזנה לכפתור חזרה
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
