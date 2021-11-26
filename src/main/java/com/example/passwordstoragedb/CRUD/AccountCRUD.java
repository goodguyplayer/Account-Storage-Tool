package com.example.passwordstoragedb.CRUD;

import com.example.passwordstoragedb.models.Account;

import java.util.List;

public class AccountCRUD implements CRUD<Account>, CRUDFields{
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
        return null;
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
}
