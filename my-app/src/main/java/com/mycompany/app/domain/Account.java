package com.mycompany.app.domain;

public class Account {
    private int uniqueId = 0;
    private String name = "";
    private int balance = 0;


    public int getUniqueId() {
        return this.uniqueId;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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
        return "Account [uniqueId=" + uniqueId + ", name=" + name + ", balance=" + balance + "]";
    }
    
}
