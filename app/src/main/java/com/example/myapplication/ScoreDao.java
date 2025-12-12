package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDao {
    @Insert
    void insert(Score score); // insert

    @Query("SELECT * FROM SCORE_TABLE ORDER BY id DESC")
    List<Score> getAllScores();
}
