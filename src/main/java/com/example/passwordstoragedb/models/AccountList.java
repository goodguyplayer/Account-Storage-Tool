package com.example.passwordstoragedb.models;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accounts;

    public AccountList() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> returnList() {
        return this.accounts;
    }

    // Todo.: Find better alternatives than to return null
    public Account returnAccount(String username) {
        for (Account account : this.accounts) {
            if (account.username == username) {
                return account;
            }
        }
        return null;
    }

}
