package com.example.passwordstoragedb.CRUD;

import com.example.passwordstoragedb.models.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountCRUDTest {
    AccountCRUD crud = new AccountCRUD();

    @Disabled
    @Test
    public void testTableExistence() throws Exception{
        // TODO.: Test if table exists
    }

    private Account getTestAccount(List<Account> list){
        for (Account account:list) {
            if (account.getReminderanswer().equals("for test account")){
                return account;
            }
        }
        return list.get(list.size() - 1);
    }

    @Test
    public void testAddValidAccount(){
        Account account = new Account(
                "www.google.com",
                "username",
                "email@email.com",
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "for test account");
        assertTrue(crud.create(account));
        crud.delete(getTestAccount(crud.getAll()));
    }

    @Test
    public void testAddInvalidAccountNull(){
        Account account = new Account(
                null,
                null,
                null,
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "for test account");
        assertFalse(crud.create(account));
    }

    @Test
    public void testAddInvalidAccountEmpty(){
        Account account = new Account(
                "",
                "",
                "",
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "for test account");
        assertFalse(crud.create(account));
    }

    @Test
    public void testUpdateValidAccount(){
        Account account = new Account(
                "www.google.com",
                "username",
                "email@email.com",
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "for test account");

        crud.create(account);
        account.setUsername("super");
        account.setId(getTestAccount(crud.getAll()).getId());
        assertTrue(crud.update(account));
        crud.delete(account);
    }

    @Test
    public void testUpdateInvalidAccountNull(){
        Account account = new Account(
                "www.google.com",
                "username",
                "email@email.com",
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "for test account");

        crud.create(account);
        account.setUsername(null);
        account.setId(getTestAccount(crud.getAll()).getId());
        assertFalse(crud.update(account));
        crud.delete(account);
    }

    @Test
    public void testUpdateInvalidAccountEmpty(){
        Account account = new Account(
                "www.google.com",
                "username",
                "email@email.com",
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "for test account");

        crud.create(account);
        account.setUsername("");
        account.setId(getTestAccount(crud.getAll()).getId());
        assertFalse(crud.update(account));
        account.setUsername("username");
        crud.delete(account);
    }

}