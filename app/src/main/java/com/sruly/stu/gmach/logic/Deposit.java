package com.sruly.stu.gmach.logic;

import java.util.Date;

/**
 * Created by stu on 5/7/2018.
 */

public class Deposit {
    long id;
    Date dDate, rDate;
    double amount;
    User depositor;

    public Deposit(long id, Date dDate, Date rDate, double amount, User depositor) {
        this.id = id;
        this.dDate = dDate;
        this.rDate = rDate;
        this.amount = amount;
        this.depositor = depositor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getDepositor() {
        return depositor;
    }

    public void setDepositor(User depositor) {
        this.depositor = depositor;
    }
}
