package com.example.asdlab;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TestViewModel extends AndroidViewModel {
    private TestRepository repository;
    private LiveData<List<TestTable>> allTestTable;

    public TestViewModel(@NonNull Application application) {
        super(application);
        repository = new TestRepository(application);
    }

    public void insert_test_table(TestTable testTable) {
        repository.insert_test_table(testTable);
    }

    public void update_test_table(TestTable testTable) {
        repository.update_test_table(testTable);
    }

    public void delete_test_table(TestTable testTable) {
        repository.delete_test_table(testTable);
    }

    public LiveData<List<TestTable>> getAllTestTable() {
        allTestTable = repository.getAllTestTable();
        return allTestTable;
    }
}
