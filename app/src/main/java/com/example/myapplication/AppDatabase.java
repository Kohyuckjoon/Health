package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Score.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ScoreDao scoreDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final android.content.Context context){
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = androidx.room.Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "evaluation_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
