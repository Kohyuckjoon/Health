package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private AppDatabase db;
    private RecyclerView recyclerView;
    private HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);

        db = AppDatabase.getDatabase(this);
        recyclerView = findViewById(R.id.recycler_history);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HistoryAdapter();
        recyclerView.setAdapter(adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<Score> scores = db.scoreDao().getAllScores();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setScores(scores);
                    }
                });
            }
        }).start();
    }
}