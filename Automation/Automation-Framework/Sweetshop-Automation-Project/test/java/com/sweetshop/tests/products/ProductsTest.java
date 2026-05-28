package com.sweetshop.tests.products;

import com.sweetshop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void testViewProducts() {
        homePage.clickBrowseSweetsButton();
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(),
                "\n Products Header is not Displayed \n");
    }

    @Test
    public void testAddItemsToBasketNegative() {
        homePage.clickBrowseSweetsButton();
        productsPage.addBonBonsToBasket();
        productsPage.addChocolateCupsToBasket();
        productsPage.addNerdsToBasket();
        productsPage.addFruitSaladsToBasket();
        String numItemsInBasket = productsPage.getNumItemsInBasket();
        Assert.assertTrue(numItemsInBasket.contains("100"));
    }

    @Test
    public void testAddItemsToBasketPositive() {
        homePage.clickBrowseSweetsButton();
        productsPage.addWhamBarsToBasket();
        productsPage.addChocolateBeansToBasket();
        productsPage.addJelliesToBasket();
        productsPage.addSherbertDiscsToBasket();
        String numItemsInBasket = productsPage.getNumItemsInBasket();
        Assert.assertTrue(numItemsInBasket.contains("4"));
    }

    @Test
    public void testBasketLink() {
        productsPage.goToBasketPage();
        Assert.assertTrue(basketPage.isBasketHeaderDisplayed(),
                "\n Basket Header is not Displayed \n");
    }

}
