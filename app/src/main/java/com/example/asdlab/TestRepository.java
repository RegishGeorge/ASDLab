package com.example.asdlab;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TestRepository {
    private TestDao testDao;
    private LiveData<List<TestTable>> allTestTable;

    public TestRepository(Application application) {
        TestDatabase database = TestDatabase.getInstance(application);
        testDao = database.testDao();
    }

    public void insert_test_table(TestTable testTable) {
        new InsertTestTableAsyncTask(testDao).execute(testTable);
    }

    public void update_test_table(TestTable testTable) {
        new UpdateTestTableAsyncTask(testDao).execute(testTable);
    }

    public void delete_test_table(TestTable testTable) {
        new DeleteTestTableAsyncTask(testDao).execute(testTable);
    }

    public LiveData<List<TestTable>> getAllTestTable() {
        allTestTable = testDao.getAllTestTable();
        return allTestTable;
    }

    private static class InsertTestTableAsyncTask extends AsyncTask<TestTable, Void, Void> {
        private TestDao testDao;

        private InsertTestTableAsyncTask(TestDao testDao) {
            this.testDao = testDao;
        }

        @Override
        protected Void doInBackground(TestTable... testTables) {
            testDao.insert_test_table(testTables[0]);
            return null;
        }
    }

    private static class UpdateTestTableAsyncTask extends AsyncTask<TestTable, Void, Void> {
        private TestDao testDao;

        private UpdateTestTableAsyncTask(TestDao testDao) {
            this.testDao = testDao;
        }

        @Override
        protected Void doInBackground(TestTable... testTables) {
            testDao.update_test_table(testTables[0]);
            return null;
        }
    }

    private static class DeleteTestTableAsyncTask extends AsyncTask<TestTable, Void, Void> {
        private TestDao testDao;

        private DeleteTestTableAsyncTask(TestDao testDao) {
            this.testDao = testDao;
        }

        @Override
        protected Void doInBackground(TestTable... testTables) {
            testDao.delete_test_table(testTables[0]);
            return null;
        }
    }
}
