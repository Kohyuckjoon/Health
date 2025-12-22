package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout clSelfExamination;

    Button btn_self_examination;
    Button btn_evaluation;

    RadioButton rd_01;
    RadioButton rd_02;
    RadioButton rd_03;
    RadioButton rd_04;
    RadioButton rd_05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn_self_examination = findViewById(R.id.btn_self_examination);
        btn_evaluation = findViewById(R.id.btn_evaluation);

        btn_self_examination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EvaluationActivity.class);
                startActivity(intent);
            }
        });

        btn_evaluation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}