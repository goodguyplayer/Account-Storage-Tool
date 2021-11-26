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
                "",
                "",
                "",
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "it was here",
                true
        );
        assertFalse(crud.create(account));
        crud.delete(account);
    }

    @Test
    public void testUpdateValidAccount(){
        Account account = new Account(
                "www.google.com",
                "username",
                "email@email.com",
                "123456789!@#$%¨&*()_+",
                "where was it?",
                "it was here",
                true
        );

        crud.create(account);
        account.setPassword("987654321");
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
                "it was here",
                true
        );

        crud.create(account);
        account.setPassword(null);
        assertFalse(crud.update(account));
        account.setPassword("three");
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
                "it was here",
                true
        );

        crud.create(account);
        account.setPassword("");
        assertFalse(crud.update(account));
        account.setPassword("three");
        crud.delete(account);
    }

}