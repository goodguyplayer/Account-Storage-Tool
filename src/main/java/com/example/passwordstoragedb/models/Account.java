package com.example.passwordstoragedb.models;

public class Account {
    String website;
    String username;
    String email;
    String password;
    String reminderquestion;
    String reminderanswer;
    Boolean twofactor;

    public Account(String website, String username, String email, String password, String reminderquestion, String reminderanswer, Boolean twofactor) {
        this.website = website;
        this.username = username;
        this.email = email;
        this.password = password;
        this.reminderquestion = reminderquestion;
        this.reminderanswer = reminderanswer;
        this.twofactor = twofactor;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getReminderquestion() {
        return reminderquestion;
    }

    public String getReminderanswer() {
        return reminderanswer;
    }

    public Boolean getTwofactor() {
        return twofactor;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReminderquestion(String reminderquestion) {
        this.reminderquestion = reminderquestion;
    }

    public void setReminderanswer(String reminderanswer) {
        this.reminderanswer = reminderanswer;
    }

    public void setTwofactor(Boolean twofactor) {
        this.twofactor = twofactor;
    }
}
