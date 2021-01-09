package com.example.asdlab;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TestDao {
    @Insert
    void insert_test_table(TestTable testTable);

    @Update
    void update_test_table(TestTable testTable);

    @Delete
    void delete_test_table(TestTable testTable);

    @Query("SELECT * FROM TESTTABLE")
    LiveData<List<TestTable>> getAllTestTable();
}
