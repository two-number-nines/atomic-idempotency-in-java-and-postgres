package com.mycompany.app.domain;

public class Account {
    private int uniqueId = 0;
    private int balance = 0;


    public int getBalance() {
        return this.balance;
    }

    public int getUniqueId() {
        return this.uniqueId;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }
    public void transfer(Account destination, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be more than 0");
        }
        this.balance -= amount;
        destination.balance += amount;
    }

    public void withdraw(int amount) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deposit(int amount) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String toString() {
        return "Account [uniqueId=" + uniqueId + ", balance=" + balance + "]";
    }
    
}
