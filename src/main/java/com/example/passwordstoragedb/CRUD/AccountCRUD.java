package com.example.passwordstoragedb.CRUD;

import com.example.passwordstoragedb.models.Account;
import com.example.passwordstoragedb.models.AccountList;
import org.apache.log4j.Logger;

import java.util.List;
import java.sql.*;

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
        logger.trace("get method");
        AccountList accountList = new AccountList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                Account account = new Account(result.getString("website"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("reminderquestion"),
                        result.getString("reminderanswer"));
                account.setId(result.getInt("id"));
                accountList.addAccount(account);
            }
            result.close();
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        return accountList.returnList();
    }

    @Override
    public List getAll() {
        logger.trace("getAll method");
        AccountList accountList = new AccountList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                Account account = new Account(result.getString("website"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("reminderquestion"),
                        result.getString("reminderanswer"));
                account.setId(result.getInt("id"));
                accountList.addAccount(account);
            }
            result.close();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return accountList.returnList();
    }

    @Override
    public Boolean update(Account account) {
        logger.trace("update method");
        int toreturn = 0;
        if (isAccountValid(account)){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
                preparedStatement.setString(1, account.getWebsite());
                preparedStatement.setString(2, account.getUsername());
                preparedStatement.setString(3, account.getEmail());
                preparedStatement.setString(4, account.getPassword());
                preparedStatement.setString(5, account.getReminderquestion());
                preparedStatement.setString(6, account.getReminderanswer());
                preparedStatement.setInt(7, account.getId());
                toreturn = preparedStatement.executeUpdate();
            } catch (Exception e){
                logger.error(e.getMessage());
            }
        }
        return isToReturn(toreturn);
    }

    @Override
    public Boolean delete(Account account) {
        logger.trace("delete method");
        int toreturn = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setInt(1, account.getId());
            toreturn = preparedStatement.executeUpdate();
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return isToReturn(toreturn);
    }

    @Override
    public Boolean create(Account account) {
        logger.trace("create method");
        int toreturn = 0;
        if (isAccountValid(account)){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
                preparedStatement.setString(1, account.getWebsite());
                preparedStatement.setString(2, account.getUsername());
                preparedStatement.setString(3, account.getEmail());
                preparedStatement.setString(4, account.getPassword());
                preparedStatement.setString(5, account.getReminderquestion());
                preparedStatement.setString(6, account.getReminderanswer());
                toreturn = preparedStatement.executeUpdate();
            } catch (Exception e){
                logger.error(e.getMessage());
            }
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
        return "DELETE FROM "+ table +" WHERE id = ?;";
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
                "reminderanswer = ? " +
                "WHERE id = ?;";
    }

    @Override
    public String getInsertString(String table) {
        logger.trace("");
        return "INSERT INTO "+ table + " (website, username, email, password, reminderquestion, reminderanswer) VALUES (?, ?, ?, ?, ?, ?);";
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
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " website VARCHAR NOT NULL," +
                " username VARCHAR NOT NULL," +
                " email VARCHAR," +
                " password VARCHAR NOT NULL," +
                " reminderquestion VARCHAR," +
                " reminderanswer VARCHAR" +
                ");";
    }

    private Boolean isAccountValid(Account account){
        logger.trace("Boolean check");
        return (isValueEmpty(account.getUsername()) && isValueEmpty(account.getWebsite()));
    }

    private Boolean isToReturn(int result){
        logger.debug("Number to check.: " + result);
        if (result == 1){
            return true;
        }
        return false;
    }

    private Boolean isValueNull(String value){
        logger.debug("Value to check.: " + value);
        if (value == null){
            return true;
        }
        return false;
    }

    private Boolean isValueEmpty(String value){
        logger.debug("Value to check.: " + value);
        if (!isValueNull(value)){
            if (value.length() > 0){
                return true;
            }
        }
        return false;
    }
}
