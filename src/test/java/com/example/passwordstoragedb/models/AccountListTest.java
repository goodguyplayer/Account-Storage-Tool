package com.example.passwordstoragedb.models;

import com.example.passwordstoragedb.HelloApplication;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountListTest {
    Account account1 = new Account("username",
            "email",
            "password",
            "What was your first pet",
            "That one",
            "");

    Account account2 = new Account("username2",
            "email2",
            "password2",
            "What was your first pet2",
            "That one2",
            "");

    Account account3 = new Account("username3",
            "email3",
            "password3",
            "What was your first pet3",
            "That one3",
            "");

    AccountList accountList = new AccountList();
    static Logger logger = Logger.getLogger(AccountListTest.class);

    @BeforeEach
    public void setAccounts(){
        logger.trace("BeforeEach method");
        accountList.addAccount(account1);
        accountList.addAccount(account2);
        accountList.addAccount(account3);
    }


    @Test
    public void sameAccounts(){
        logger.trace("Test method");
        assertSame(accountList.returnAccount(account1.getUsername()).getUsername(), account1.getUsername());
        assertSame(accountList.returnAccount(account2.getUsername()).getUsername(), account2.getUsername());
        assertSame(accountList.returnAccount(account3.getUsername()).getUsername(), account3.getUsername());
    }

    @Test
    public void differentAccounts(){
        logger.trace("Test method");
        assertNotSame(accountList.returnAccount(account2.getUsername()).getUsername(), account1.getUsername());
        assertNotSame(accountList.returnAccount(account2.getUsername()).getUsername(), account3.getUsername());
        assertNotSame(accountList.returnAccount(account1.getUsername()).getUsername(), account3.getUsername());
    }

    @Test
    public void returnNullIfNotFound(){
        logger.trace("Test method");
        assertNull(accountList.returnAccount("None"));
    }

    @Test
    public void listNotNegative(){
        logger.trace("Test method");
        assertTrue(accountList.returnList().size() >= 0);
    }


}