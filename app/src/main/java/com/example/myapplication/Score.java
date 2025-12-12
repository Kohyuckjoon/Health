package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "score_table")
public class Score {
    @PrimaryKey(autoGenerate = true)
    private int id; // ID 항목
    private int finalScore; // 최종 합산 점수

    public Score(int finalScore) {
//        this.id = id;
        this.finalScore = finalScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", finalScore=" + finalScore +
                '}';
    }
}
