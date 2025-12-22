package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView tv_score;

    int total_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        tv_score = findViewById(R.id.tv_score);

        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            total_score = extra.getInt("TOTAL_SCORE", 0);
            String scoreText = "당신의 점수는 " + total_score + "점입니다.";
            tv_score.setText(scoreText);
        } else {
            tv_score.setText("점수 정보를 불러올 수 없습니다.");
        }
    }
}