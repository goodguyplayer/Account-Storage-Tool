package com.example.passwordstoragedb.models;

public class Account {
    String username;
    String email;
    String password;
    String reminder;

    public Account(String username, String email, String password, String reminder) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.reminder = reminder;
    }
}
