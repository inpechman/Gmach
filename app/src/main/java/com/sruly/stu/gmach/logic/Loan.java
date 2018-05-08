package com.sruly.stu.gmach.logic;

import java.util.Date;


public class Loan {
    long id;
    Date lDate, rDate;
    double amount;
    User borrower;

    public Loan(long id, Date lDate, Date rDate, double amount, User borrower) {
        this.id = id;
        this.lDate = lDate;
        this.rDate = rDate;
        this.amount = amount;
        this.borrower = borrower;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getlDate() {
        return lDate;
    }

    public void setlDate(Date lDate) {
        this.lDate = lDate;
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

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }
}
