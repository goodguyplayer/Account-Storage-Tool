package com.example.passwordstoragedb.models;

import static org.junit.jupiter.api.Assertions.*;

class AccountListTest {
    Account account1 = new Account("username",
            "email",
            "password",
            "What was your first pet",
            "That one",
            true);

    Account account2 = new Account("username2",
            "email2",
            "password2",
            "What was your first pet2",
            "That one2",
            false);

}