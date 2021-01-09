package com.example.asdlab;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TestTable.class}, version = 1)
public abstract class TestDatabase extends RoomDatabase {
    private static final String DB_NAME = "test";
    private static TestDatabase instance;

    public static synchronized TestDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TestDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract TestDao testDao();
}
