package com.mycompany.app.repository;

import com.mycompany.app.domain.Account;

public class AccountRepository {

    private Account[] accounts;

    public AccountRepository() {
        this.accounts = new Account[2];
        Account accountA = new Account();
        Account accountB = new Account();

        this.accounts[0] = accountA;
        this.accounts[1] = accountB;

        // this is a starting balance but shouldn't be part of a repo
        accountA.setBalance(100);
        accountB.setBalance(200);
        accountA.setUniqueId(0);
        accountB.setUniqueId(1);
    }
    // super dumb implementation to get an account by it's index, which is set as their unique id for now
    public Account getAccountById(int uniqueId) {
        return this.accounts[uniqueId];
    }
}
