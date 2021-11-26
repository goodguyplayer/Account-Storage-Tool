package com.example.passwordstoragedb.CRUD;

import com.example.passwordstoragedb.models.Account;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountCRUDTest {
    AccountCRUD crud = new AccountCRUD();

    @Disabled
    @Test
    public void testConstructor() throws Exception{
        // TODO.: Test if table exists
    }

    @Test
    public void testAddValidAccount(){
        Account account = new Account(
                "www.google.com",
                "username",
                "email@email.com",
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "it was here",
                true
        );
        assertTrue(crud.create(account));
        crud.delete(account);
    }

    @Test
    public void testAddInvalidAccountNull(){
        Account account = new Account(
                null,
                null,
                null,
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "it was here",
                true
        );
        assertFalse(crud.create(account));
        crud.delete(account);
    }

    @Test
    public void testAddInvalidAccountEmpty(){
        Account account = new Account(
                null,
                null,
                null,
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "it was here",
                true
        );
        assertFalse(crud.create(account));
        crud.delete(account);
    }

}