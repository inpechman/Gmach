package com.sruly.stu.gmach;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.sruly.stu.gmach.logic.DBM;
import com.sruly.stu.gmach.logic.Loan;
import com.sruly.stu.gmach.logic.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

public class NewLoan extends AppCompatActivity {
    EditText fName, lName, userId, amount, rDate;
    Button saveBtn;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    Date date = new Date(System.currentTimeMillis());
    Calendar calendar = GregorianCalendar.getInstance();
    LocalDate localDate = LocalDate.of(2018, Month.MAY, 10);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_loan);
        fName = findViewById(R.id.new_loan_first_name_field);
        lName = findViewById(R.id.new_loan_last_name_field);
        userId = findViewById(R.id.new_loan_user_id_field);
        amount = findViewById(R.id.new_loan_amount_field);
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
          calendar.set(Calendar.YEAR, year);
          calendar.set(Calendar.MONTH, month);
          calendar.set(Calendar.DATE, dayOfMonth);
          updateDateFieldText();
            }
        };
        datePickerDialog = new DatePickerDialog(this, onDateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
        rDate = findViewById(R.id.new_loan_return_Date_field);
        rDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    datePickerDialog.show();
            }
        });
        saveBtn = findViewById(R.id.new_loan_save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(fName.getText().toString(),
                        lName.getText().toString(),
                        Long.parseLong("0" + userId.getText().toString()));
                System.out.println("AAA + " + rDate.getText().toString());
                System.out.println("AAA " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
                System.out.println("AAA " + localDate.format(DateTimeFormatter.ISO_DATE));
                Loan loan =new Loan(
                        new Random().nextLong(),
                        new Date(System.currentTimeMillis()),
//                            sdf.parse(rDate.getText().toString()),

                        new Date(calendar.getTimeInMillis()),
                        Double.parseDouble("0" + amount.getText().toString()),
                        user
                );
                DBM.getInstance(getApplicationContext()).insertLoan(loan);

            }
        });
    }

    private void updateDateFieldText() {
        rDate.setText(sdf.format(calendar.getTimeInMillis()));
    }
}
