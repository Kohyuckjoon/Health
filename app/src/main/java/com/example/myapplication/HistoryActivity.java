package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recycler_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HistoryAdapter();
        recyclerView.setAdapter(adapter);

        loadScores();
    }

    private void loadScores() {
        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedScores = pref.getString("score_list", "");

        List<Integer> scoreList = new ArrayList<>();
        if (!savedScores.isEmpty()) {
            String[] scores = savedScores.split(",");

            for (int i = 0; i < scores.length; i++) {
                String s = scores[i]; // i번째 인덱스의 값을 가져옴
                scoreList.add(Integer.parseInt(s));
            }
        }

        // 최신순으로 정렬 (선택사항)
        Collections.sort(scoreList);
        adapter.setScores(scoreList);
    }
}