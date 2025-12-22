package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EvaluationActivity extends AppCompatActivity {

    Button btnSave;

    private RadioButton rd_01_01;
    private RadioButton rd_01_02;
    private RadioButton rd_01_03;
    private RadioButton rd_01_04;
    private RadioButton rd_01_05;

    private RadioButton rd_02_01;
    private RadioButton rd_02_02;
    private RadioButton rd_02_03;
    private RadioButton rd_02_04;
    private RadioButton rd_02_05;

    private RadioButton rd_03_01;
    private RadioButton rd_03_02;
    private RadioButton rd_03_03;
    private RadioButton rd_03_04;
    private RadioButton rd_03_05;

    private RadioButton rd_04_01;
    private RadioButton rd_04_02;
    private RadioButton rd_04_03;
    private RadioButton rd_04_04;
    private RadioButton rd_04_05;

    private RadioButton rd_05_01;
    private RadioButton rd_05_02;
    private RadioButton rd_05_03;
    private RadioButton rd_05_04;
    private RadioButton rd_05_05;

    private RadioButton rd_06_01;
    private RadioButton rd_06_02;
    private RadioButton rd_06_03;
    private RadioButton rd_06_04;
    private RadioButton rd_06_05;

    // 1번 문항
    int number_01_01 = 0;
    int number_01_02 = 0;
    int number_01_03 = 0;
    int number_01_04 = 0;
    int number_01_05 = 0;

    // 2번 문항
    int number_02_01 = 0;
    int number_02_02 = 0;
    int number_02_03 = 0;
    int number_02_04 = 0;
    int number_02_05 = 0;

    // 3번 문항
    int number_03_01 = 0;
    int number_03_02 = 0;
    int number_03_03 = 0;
    int number_03_04 = 0;
    int number_03_05 = 0;

    // 4번 문항
    int number_04_01 = 0;
    int number_04_02 = 0;
    int number_04_03 = 0;
    int number_04_04 = 0;
    int number_04_05 = 0;

    // 5번 문항
    int number_05_01 = 0;
    int number_05_02 = 0;
    int number_05_03 = 0;
    int number_05_04 = 0;
    int number_05_05 = 0;

    // 6번 문항
    int number_06_01 = 0;
    int number_06_02 = 0;
    int number_06_03 = 0;
    int number_06_04 = 0;
    int number_06_05 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_evaluation);

        rd_01_01 = findViewById(R.id.rd_01_01); // 5점
        rd_01_02 = findViewById(R.id.rd_01_02); // 4점
        rd_01_03 = findViewById(R.id.rd_01_03); // 3점
        rd_01_04 = findViewById(R.id.rd_01_04); // 2점
        rd_01_05 = findViewById(R.id.rd_01_05); // 1점

        rd_02_01 = findViewById(R.id.rd_02_01); // 5점
        rd_02_02 = findViewById(R.id.rd_02_02); // 4점
        rd_02_03 = findViewById(R.id.rd_02_03); // 3점
        rd_02_04 = findViewById(R.id.rd_02_04); // 2점
        rd_02_05 = findViewById(R.id.rd_02_05); // 1점

        rd_03_01 = findViewById(R.id.rd_03_01); // 5점
        rd_03_02 = findViewById(R.id.rd_03_02); // 4점
        rd_03_03 = findViewById(R.id.rd_03_03); // 3점
        rd_03_04 = findViewById(R.id.rd_03_04); // 2점
        rd_03_05 = findViewById(R.id.rd_03_05); // 1점

        rd_04_01 = findViewById(R.id.rd_04_01); // 5점
        rd_04_02 = findViewById(R.id.rd_04_02); // 4점
        rd_04_03 = findViewById(R.id.rd_04_03); // 3점
        rd_04_04 = findViewById(R.id.rd_04_04); // 2점
        rd_04_05 = findViewById(R.id.rd_04_05); // 1점

        rd_05_01 = findViewById(R.id.rd_05_01); // 5점
        rd_05_02 = findViewById(R.id.rd_05_02); // 4점
        rd_05_03 = findViewById(R.id.rd_05_03); // 3점
        rd_05_04 = findViewById(R.id.rd_05_04); // 2점
        rd_05_05 = findViewById(R.id.rd_05_05); // 1점

        rd_06_01 = findViewById(R.id.rd_06_01); // 5점
        rd_06_02 = findViewById(R.id.rd_06_02); // 4점
        rd_06_03 = findViewById(R.id.rd_06_03); // 3점
        rd_06_04 = findViewById(R.id.rd_06_04); // 2점
        rd_06_05 = findViewById(R.id.rd_06_05); // 1점

        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalScore = calculate(); // 점수 계산 로직

                saveToPreferences(finalScore); // Preferences 사용하여 점수 저장

                // 결과화면으로 이동 + 합산 데이터 넘기기
                Intent intent = new Intent(EvaluationActivity.this, ResultActivity.class);
                intent.putExtra("TOTAL_SCORE", finalScore);
                startActivity(intent);
            }
        });
    }

    private void saveToPreferences(int score) {
        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        // 기존 데이터 불러오기 (쉼표로 구분된 문자열)
        String savedScores = pref.getString("score_list", "");

        // 새 점수 추가 (예: "15,20,10,")
        if (savedScores.isEmpty()) {
            savedScores = String.valueOf(score);
        } else {
            savedScores = savedScores + "," + score;
        }

        editor.putString("score_list", savedScores);
        editor.apply();

        Toast.makeText(this, "점수가 저장되었습니다.", Toast.LENGTH_SHORT).show();
    }

    private int calculate() {
        int sum = 0;

        number_01_01 = 0;
        number_01_02 = 0;
        number_01_03 = 0;
        number_01_04 = 0;
        number_01_05 = 0;

        number_02_01 = 0;
        number_02_02 = 0;
        number_02_03 = 0;
        number_02_04 = 0;
        number_02_05 = 0;

        number_03_01 = 0;
        number_03_02 = 0;
        number_03_03 = 0;
        number_03_04 = 0;
        number_03_05 = 0;

        number_04_01 = 0;
        number_04_02 = 0;
        number_04_03 = 0;
        number_04_04 = 0;
        number_04_05 = 0;

        number_05_01 = 0;
        number_05_02 = 0;
        number_05_03 = 0;
        number_05_04 = 0;
        number_05_05 = 0;

        number_06_01 = 0;
        number_06_02 = 0;
        number_06_03 = 0;
        number_06_04 = 0;
        number_06_05 = 0;

        if (rd_01_01.isChecked()) {
            number_01_01 = 5;
        } else if (rd_01_02.isChecked()) {
            number_01_02 = 4;
        } else if (rd_01_03.isChecked()) {
            number_01_03 = 3;
        } else if (rd_01_04.isChecked()) {
            number_01_04 = 2;
        } else if (rd_01_05.isChecked()) {
            number_01_05 = 1;
        }

        if (rd_02_01.isChecked()) {
            number_02_01 = 5;
        } else if (rd_02_02.isChecked()) {
            number_02_02 = 4;
        } else if (rd_02_03.isChecked()) {
            number_02_03 = 3;
        } else if (rd_02_04.isChecked()) {
            number_02_04 = 2;
        } else if (rd_02_05.isChecked()) {
            number_02_05 = 1;
        }

        if (rd_03_01.isChecked()) {
            number_03_01 = 5;
        } else if (rd_03_02.isChecked()) {
            number_03_02 = 4;
        } else if (rd_03_03.isChecked()) {
            number_03_03 = 3;
        } else if (rd_03_04.isChecked()) {
            number_03_04 = 2;
        } else if (rd_03_05.isChecked()) {
            number_03_05 = 1;
        }

        if (rd_04_01.isChecked()) {
            number_04_01 = 5;
        } else if (rd_04_02.isChecked()) {
            number_04_02 = 4;
        } else if (rd_04_03.isChecked()) {
            number_04_03 = 3;
        } else if (rd_04_04.isChecked()) {
            number_04_04 = 2;
        } else if (rd_04_05.isChecked()) {
            number_04_05 = 1;
        }

        if (rd_05_01.isChecked()) {
            number_05_01 = 5;
        } else if (rd_05_02.isChecked()) {
            number_05_02 = 4;
        } else if (rd_05_03.isChecked()) {
            number_05_03 = 3;
        } else if (rd_05_04.isChecked()) {
            number_05_04 = 2;
        } else if (rd_05_05.isChecked()) {
            number_05_05 = 1;
        }

        if (rd_06_01.isChecked()) {
            number_06_01 = 5;
        } else if (rd_06_02.isChecked()) {
            number_06_02 = 4;
        } else if (rd_06_03.isChecked()) {
            number_06_03 = 3;
        } else if (rd_06_04.isChecked()) {
            number_06_04 = 2;
        } else if (rd_06_05.isChecked()) {
            number_06_05 = 1;
        }

        sum = number_01_01 + number_01_02 + number_01_03 + number_01_04 + number_01_05
                + number_02_01 + number_02_02 + number_02_03 + number_02_04 + number_02_05
                + number_03_01 + number_03_02 + number_03_03 + number_03_04 + number_03_05
                + number_04_01 + number_04_02 + number_04_03 + number_04_04 + number_04_05
                + number_05_01 + number_05_02 + number_05_03 + number_05_04 + number_05_05
                + number_06_01 + number_06_02 + number_06_03 + number_06_04 + number_06_05;

        return sum;
    }
}