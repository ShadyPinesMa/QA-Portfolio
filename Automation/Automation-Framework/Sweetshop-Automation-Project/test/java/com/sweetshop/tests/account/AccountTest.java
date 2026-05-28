package com.sweetshop.tests.account;

import com.sweetshop.base.BaseTest;
import com.sweetshop.pages.AccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void testAccountHeaderIsDisplayed() {
        homePage.clickLoginLink();
        AccountPage accountPage = loginPage.logIntoApplication(
                "twoorders@sweetshop.local",
                "abc123"
        );
        Assert.assertTrue(accountPage.isAccountHeaderDisplayed());
    }

    @Test
    public void testIsNumberOfOrdersDisplayed() {
        homePage.clickLoginLink();
        loginPage.logIntoApplication(
                "twoorders@sweetshop.local",
                "abc123"
        );
        int actual = accountPage.numberOfOrdersPlacedDisplayed();
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testNumberOfOrdersDisplayedNegative() {
        homePage.clickLoginLink();
        loginPage.logIntoApplication(
                "fiveorders@sweetshop.local",
                "defg909"
        );
        int actual = accountPage.numberOfOrdersPlacedDisplayed();
        int expected = 10;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testPastTransactionsDisplayed() {
        homePage.clickLoginLink();
        loginPage.logIntoApplication(
                "oneorder@sweetshop.local",
                "abc123"
        );
        Assert.assertTrue(accountPage.arePastTransactionsDisplayed());
    }
}
