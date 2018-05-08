package com.sruly.stu.gmach.logic;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by stu on 5/7/2018.
 */

public class Operation {
    String type;
    User user;
    Date date;
    double amount, sum;

    public Operation(String type, User user, Date date, double amount, double sum) {
        this.type = type;
        this.user = user;
        this.date = date;
        this.amount = amount;
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
