package com.sruly.stu.gmach.logic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;


public class DBM {
    private static DBM instance;
    private Context context;
    private SQLiteDatabase db;

    private DBM(Context context) {
        this.context = context;
        this.db = context.openOrCreateDatabase("gmach.db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (" +
                "user_id INTEGER PRIMARY KEY," +
                "first_name TEXT," +
                "last_name TEXT" +
                ")");
        db.execSQL("CREATE TABLE IF NOT EXISTS loans (" +
                "loan_id INTEGER," +
                "loan_date INTEGER," +
                "return_date INTEGER," +
                "amount REAL," +
                "user_id INTEGER," +
                "FOREIGN KEY (user_id) REFERENCES users (user_id)" +
                ")");
        db.execSQL("CREATE TABLE IF NOT EXISTS deposits (" +
                "deposit_id INTEGER," +
                "deposit_date INTEGER," +
                "return_date INTEGER," +
                "amount REAL," +
                "user_id INTEGER," +
                "FOREIGN KEY (user_id) REFERENCES users (user_id)" +
                ")");
    }

    public static DBM getInstance(Context context) {
        if (instance == null) {
            instance = new DBM(context);
        }
        return instance;
    }

    public synchronized ArrayList<Operation> getOperationsForUser(User user) {
        ArrayList<Operation> operations = new ArrayList<Operation>();
        Cursor cursor = db.rawQuery("SELECT loan_id, user_id, first_name, last_name, loan_date, amount FROM users INNER JOIN loans ON users.user_id = loans.user_id", null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                do {
                    Operation operation = new Operation(
                            "loan",
                            new User(
                                    cursor.getString(cursor.getColumnIndex("first_name")),
                                    cursor.getString(cursor.getColumnIndex("last_name")),
                                    cursor.getLong(cursor.getColumnIndex("user_id"))
                            ),
                            new Date(cursor.getLong(cursor.getColumnIndex("loan_date"))),
                            cursor.getDouble(cursor.getColumnIndex("amount")),
                            0
                    );
                    operations.add(operation);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return operations;
    }

    public synchronized ArrayList<UserState> getAllUsersStates() {
        return null;
    }

    public synchronized ArrayList<Deposit> getAllDeposits() {
        return null;
    }

    public synchronized ArrayList<Loan> getAllLoans() {
        return null;
    }

    public synchronized ArrayList<Loan> getLoansBetweenDates(Date startD, Date endD) {
        return null;
    }

    public synchronized void insertLoan(Loan loan) {
        insertOrUpdateUser(loan.getBorrower());
        db.execSQL("INSERT INTO loans (loan_id, loan_date, return_date, amount, user_id) VALUES(" +
                loan.getId() + "," +
                loan.getlDate().getTime() + "," +
                loan.getrDate().getTime() + "," +
                loan.getAmount() + "," +
                loan.getBorrower().getId() +
                ")");
    }

    public synchronized void insertDeposit(Deposit deposit) {
        insertOrUpdateUser(deposit.getDepositor());
        db.execSQL("INSERT INTO loans (deposit_id, deposit_date, return_date, amount, user_id) VALUES(" +
                deposit.getId() + "," +
                deposit.getdDate().getTime() + "," +
                deposit.getrDate().getTime() + "," +
                deposit.getAmount() + "," +
                deposit.getDepositor().getId() +
                ")");
    }

    private void insertOrUpdateUser(User user) {
        db.execSQL("INSERT OR IGNORE INTO users (user_id, first_name, last_name) VALUES (" +
                user.getId() + ",'" +
                user.getFirstName() + "','" +
                user.getLastName() +
                "')");
        db.execSQL("UPDATE users SET " +
                "first_name = '" + user.getFirstName() + "'," +
                "last_name = '" + user.getLastName() + "'" +
                "WHERE user_id = " + user.getId());
    }


}
