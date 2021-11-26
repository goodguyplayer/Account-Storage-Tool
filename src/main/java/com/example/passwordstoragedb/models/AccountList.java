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

    // Todo.: Loop within loop. Dislike this. Look for better way.
    public boolean isTherePasswordRepeat() {
        for (Account account : this.accounts) {
            for (Account account1 : this.accounts) {
                if (!isTheSameAccount(account, account1)) {
                    if (isTheSamePassword(account, account1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isTheSameAccount(Account account, Account account1){
        return (account == account1);
    }

    private boolean isTheSamePassword(Account account, Account account1){
        return (account.password == account1.password);
    }
}
