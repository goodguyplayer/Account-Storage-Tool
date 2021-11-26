package com.example.passwordstoragedb.CRUD;

import com.example.passwordstoragedb.models.Account;
import com.example.passwordstoragedb.models.AccountList;
import org.apache.log4j.Logger;

import java.util.List;
import java.sql.*;
import java.util.List;

public class AccountCRUD implements CRUD<Account>, CRUDFields{
    private Connection connection;
    static Logger logger = Logger.getLogger(AccountCRUD.class);

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
        logger.trace("");
        AccountList accountList = new AccountList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                accountList.addAccount(new Account(
                        result.getString("website"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("reminderquestion"),
                        result.getString("reminderanswer"),
                        result.getBoolean("twotwofactor")
                ));
            }
            result.close();
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return accountList.returnList();
    }

    @Override
    public List getAll() {
        logger.trace("");
        AccountList accountList = new AccountList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                accountList.addAccount(new Account(
                        result.getString("website"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("reminderquestion"),
                        result.getString("reminderanswer"),
                        result.getBoolean("twotwofactor")
                ));
            }
            result.close();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return accountList.returnList();
    }

    private Boolean isToReturn(int result){
        if (result == 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean update(Account account) {
        logger.trace("");
        int toreturn = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, account.getWebsite());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setString(5, account.getReminderquestion());
            preparedStatement.setString(6, account.getReminderanswer());
            preparedStatement.setBoolean(7, account.getTwofactor());
            preparedStatement.setString(8, account.getWebsite());
            preparedStatement.setString(9, account.getUsername());
            toreturn = preparedStatement.executeUpdate();
        } catch (Exception e){
            logger.error(e.getMessage());
        }

        return isToReturn(toreturn);
    }

    @Override
    public Boolean delete(Account account) {
        logger.trace("");
        int toreturn = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, account.getWebsite());
            preparedStatement.setString(2, account.getUsername());
            toreturn = preparedStatement.executeUpdate();
        } catch (Exception e){
            logger.error(e.getMessage());
        }

        return isToReturn(toreturn);
    }

    @Override
    public Boolean create(Account account) {
        logger.trace("");
        int toreturn = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, account.getWebsite());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setString(5, account.getReminderquestion());
            preparedStatement.setString(6, account.getReminderanswer());
            preparedStatement.setBoolean(7, account.getTwofactor());
            toreturn = preparedStatement.executeUpdate();
        } catch (Exception e){
            logger.error(e.getMessage());
        }

        return isToReturn(toreturn);
    }

    @Override
    public String getTableName() {
        logger.trace("");
        return "accounts";
    }

    @Override
    public String getDeleteString(String table) {
        logger.trace("");
        return "DELETE FROM "+ table +" WHERE website = ? AND username = ?;";
    }

    @Override
    public String getUpdateString(String table) {
        logger.trace("");
        return "UPDATE "+ table +" SET " +
                "website = ?, " +
                "username = ?, " +
                "email = ?, " +
                "password = ?, " +
                "reminderquestion = ?, " +
                "reminderanswer = ?, " +
                "twofactor = ? " +
                "WHERE website = ? AND username = ?;";
    }

    @Override
    public String getInsertString(String table) {
        logger.trace("");
        return "INSERT INTO "+ table + " (website, username, email, password, reminderquestion, reminderanswer, twofactor) VALUES (?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectAllString(String table) {
        logger.trace("");
        return "SELECT * FROM " + table;
    }

    @Override
    public String getSelectConditionalString(String table) {
        logger.trace("");
        return "SELECT * FROM " + table + " WHERE ";
    }

    private String createTableString(String table){
        logger.trace("");
        return "CREATE TABLE IF NOT EXISTS " + table +
                " (" +
                " website VARCHAR NOT NULL," +
                " username VARCHAR NOT NULL," +
                " email VARCHAR NOT NULL," +
                " password VARCHAR NOT NULL," +
                " reminderquestion VARCHAR," +
                " reminderanswer VARCHAR," +
                " twofactor BOOLEAN" +
                ");";
    }
}
