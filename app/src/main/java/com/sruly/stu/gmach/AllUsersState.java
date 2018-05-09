package com.sruly.stu.gmach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sruly.stu.gmach.logic.DBM;
import com.sruly.stu.gmach.logic.UserState;

import java.util.ArrayList;

public class AllUsersState extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users_state);
        recyclerView = findViewById(R.id.all_users_state_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ArrayList<UserState> userStateArrayList = DBM.getInstance(getApplicationContext()).getAllUsersStates();
        recyclerView.setAdapter(new AllUsersStateAdapter(userStateArrayList, getApplicationContext(), new ClickTransfer() {
            @Override
            public void onClick(long user_id) {
                Intent intent = new Intent(getApplicationContext(), HistoryForUser.class);
                intent.putExtra("user_id", user_id);
                startActivity(intent);
            }
        }));
    }
}
