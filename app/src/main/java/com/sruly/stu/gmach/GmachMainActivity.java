package com.sruly.stu.gmach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GmachMainActivity extends AppCompatActivity {
    Button showAllUsersBtn, newLoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAllUsersBtn = findViewById(R.id.open_all_user_state_btn);
        showAllUsersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AllUsersState.class);
                startActivity(intent);
            }
        });
        newLoan = findViewById(R.id.opent_new_loan_btn);
        newLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewLoan.class);
                startActivity(intent);
            }
        });
    }
}
