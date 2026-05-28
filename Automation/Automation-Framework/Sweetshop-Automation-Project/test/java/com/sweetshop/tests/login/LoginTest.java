package com.sweetshop.tests.login;

import com.sweetshop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testEmailErrorMessage() {
        homePage.clickLoginLink();
        loginPage.setEmail("tenorders@sweetshop.local");
        loginPage.setPassword("abc123");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getEmailErrorMessage();
        Assert.assertTrue(actualMessage.contains("demo email addresses"));
    }

    @Test
    public void testPasswordErrorMessage() {
        homePage.clickLoginLink();
        loginPage.setEmail("twoorders@sweetshop.local");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        String message = loginPage.getPasswordErrorMessage();
        Assert.assertTrue(message.contains("Please enter a valid"));
    }


}
