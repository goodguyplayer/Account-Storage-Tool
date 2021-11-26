package com.example.passwordstoragedb.CRUD;

import com.example.passwordstoragedb.models.Account;

import java.util.List;
import java.sql.*;
import java.util.List;

public class AccountCRUD implements CRUD<Account>, CRUDFields{
    private Connection connection;

    public AccountCRUD() {
        try {
            String myDBConnectionString = "jdbc:sqlite:accounts.db";
            connection = DriverManager.getConnection(myDBConnectionString);
            connection.prepareStatement(createTableString(getTableName())).executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List get(String condition) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public int update(Account account) {
        return 0;
    }

    @Override
    public int delete(Account account) {
        return 0;
    }

    @Override
    public int create(Account account) {
        return 0;
    }

    @Override
    public String getTableName() {
        return "accounts";
    }

    @Override
    public String getDeleteString(String table) {
        return null;
    }

    @Override
    public String getUpdateString(String table) {
        return null;
    }

    @Override
    public String getInsertString(String table) {
        return null;
    }

    @Override
    public String getSelectAllString(String table) {
        return null;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return null;
    }

    private String createTableString(String table){
        return "CREATE TABLE IF NOT EXISTS " + table +
                " (username VARCHAR NOT NULL," +
                " email VARCHAR NOT NULL," +
                " password VARCHAR NOT NULL," +
                " reminderquestion VARCHAR," +
                " reminderanswer VARCHAR," +
                " twofactor BOOLEAN);";
    }
}
