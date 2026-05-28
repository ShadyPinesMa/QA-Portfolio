package com.sweetshop.tests.home;

import com.sweetshop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void testGoToProducts() {
        homePage.clickBrowseSweetsButton();
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(),
                "\n Products Header is not Displayed \n");
    }

    @Test
    public void testGoToLogin() {
        homePage.clickLoginLink();
        Assert.assertTrue(loginPage.isLoginHeaderDisplayed(),
                "\n Login Header is not Displayed \n");
    }

    @Test
    public void testHomePageHeader() {
        homePage.isHomeHeaderDisplayed();
        Assert.assertTrue(homePage.isHomeHeaderDisplayed(),
                "\n Home Page Header is not Displayed \n");
    }
}
