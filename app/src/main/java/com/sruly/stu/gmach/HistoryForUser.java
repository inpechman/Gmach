package com.sruly.stu.gmach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sruly.stu.gmach.logic.DBM;

public class HistoryForUser extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_for_user);
        recyclerView = findViewById(R.id.history_for_user_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DBM dbm = DBM.getInstance(getApplicationContext());
        long user_id = getIntent().getLongExtra("user_id", -1);
        recyclerView.setAdapter(new HistoryForUserAdapter(dbm.getOperationsForUser(user_id), getApplicationContext()));
    }
}
