package com.sruly.stu.gmach.logic;

/**
 * Created by stu on 5/7/2018.
 */

public class UserState {
    User user;
    double loanSum, depoSum;

    public UserState(User user, double loanSum, double depoSum) {
        this.user = user;
        this.loanSum = loanSum;
        this.depoSum = depoSum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getLoanSum() {
        return loanSum;
    }

    public void setLoanSum(double loanSum) {
        this.loanSum = loanSum;
    }

    public double getDepoSum() {
        return depoSum;
    }

    public void setDepoSum(double depoSum) {
        this.depoSum = depoSum;
    }
}
