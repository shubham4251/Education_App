package com.abd.educationapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ModuleActivity extends AppCompatActivity {
    private TextView practiceTv;
    private TextView quizTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        practiceTv = findViewById(R.id.practiceTv);
        quizTv  = findViewById(R.id.quizTv);
        quizTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuleActivity.this,QuizActivity.class);
                startActivity(intent);
            }
        });
        practiceTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuleActivity.this, PracticeProblemActivity.class);
                startActivity(intent);
            }
        });

    }

}