package com.sweetshop.tests.basket;

import com.sweetshop.base.BaseTest;
import com.sweetshop.pages.CheckoutData;
import com.sweetshop.tests.utils.CsvUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {

    private void addProductsToBasket() {
        homePage.clickBrowseSweetsButton();
        productsPage.addChocolateCupsToBasket();
        productsPage.addBonBonsToBasket();
        productsPage.addWhamBarsToBasket();
        productsPage.goToBasketPage();
    }

    @Test
    public void isBasketHeaderDisplayedTest() {
        homePage.clickBasketLink();
        Assert.assertTrue(basketPage.isBasketHeaderDisplayed());
    }

    @Test
    public void doesBasketDisplayCorrectItemsTest() {
        homePage.clickBrowseSweetsButton();
        productsPage.addJelliesToBasket();
        productsPage.addChocolateBeansToBasket();
        productsPage.addNerdsToBasket();
        productsPage.goToBasketPage();
        Assert.assertTrue(basketPage.isProductInBasket("Jellies"));
        Assert.assertTrue(basketPage.isProductInBasket("Chocolate Beans"));
        Assert.assertTrue(basketPage.isProductInBasket("Nerds"));
    }

    @Test
    public void testErrorMessagesCustomerInfo() {
        homePage.clickBasketLink();
        addProductsToBasket();
        basketPage.setCardName("Alphonse Elric");
        basketPage.setCardNum("8900888800009999");
        basketPage.setExpDate("01/27");
        basketPage.setCvv("398");
        basketPage.clickCheckoutButton();
        String firstNameError = basketPage.getFirstNameError();
        Assert.assertTrue(firstNameError.contains("Valid first name"));
        String lastNameError = basketPage.getLastNameError();
        Assert.assertTrue(lastNameError.contains("Valid last name"));
        String emailError = basketPage.getEmailError();
        Assert.assertTrue(emailError.contains("valid email address"));
        String address1Error = basketPage.getAddress1Error();
        Assert.assertTrue(address1Error.contains("enter your shipping address"));
        String countryError = basketPage.getCountryError();
        Assert.assertTrue(countryError.contains("valid country"));
        String cityError = basketPage.getCityError();
        Assert.assertTrue(cityError.contains("valid state"));
        String zipError = basketPage.getZipError();
        Assert.assertTrue(zipError.contains("Zip code required"));
    }

    @Test
    public void testErrorMessagesCreditCard() {
        homePage.clickBasketLink();
        addProductsToBasket();
        basketPage.setFirstName("Suzie");
        basketPage.setLastName("Smith");
        basketPage.setEmail("ssmith@mail.com");
        basketPage.setAddress1("5678 Cherry St");
        basketPage.setCountry("United Kingdom");
        basketPage.setCity("Bristol");
        basketPage.setZip(55555);
        basketPage.clickCheckoutButton();
        String cardNameError = basketPage.getCardNameError();
        Assert.assertTrue(cardNameError.contains("Name on card"));
        String cardNumError = basketPage.getCardNumError();
        Assert.assertTrue(cardNumError.contains("Credit card number"));
        String expError = basketPage.getExpDateError();
        Assert.assertTrue(expError.contains("Expiration date"));
        String cvvError = basketPage.getCvvError();
        Assert.assertTrue(cvvError.contains("Security code"));
    }

    @DataProvider(name = "checkoutData")
    public Object[][] getData() throws Exception {
        return CsvUtils.getCsvData("checkoutData.csv");
    }

    @Test(dataProvider = "checkoutData")
    public void verifyCheckoutProcess(CheckoutData checkoutData) {
        addProductsToBasket();
        basketPage.completeCheckout(checkoutData);
        Assert.assertTrue(basketPage.checkoutFormIsCleared());
    }

}
