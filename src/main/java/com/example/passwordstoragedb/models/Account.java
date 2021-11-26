package com.example.passwordstoragedb.models;

public class Account {
    String username;
    String email;
    String password;
    String reminderquestion;
    String reminderanswer;
    Boolean twofactor;

    public Account(String username, String email, String password, String reminderquestion, String reminderanswer, Boolean twofactor) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.reminderquestion = reminderquestion;
        this.reminderanswer = reminderanswer;
        this.twofactor = twofactor;
    }
}
