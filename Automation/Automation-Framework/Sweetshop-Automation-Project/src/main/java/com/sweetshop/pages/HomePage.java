package com.sweetshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By loginLink = By.xpath("//a[@href='/login']");
    private By browseSweetsButton = By.xpath("//a[@href='/sweets']");
    private By homeHeader = By.xpath("//h1[normalize-space()='Welcome to the sweet shop!']");
    private By basketLink = By.xpath("//a[@href='/basket']");

    public LoginPage clickLoginLink() {
        click(loginLink);
        return new LoginPage(driver);
    }

    public ProductsPage clickBrowseSweetsButton() {
        click(browseSweetsButton);
        return new ProductsPage(driver);
    }

    public boolean isHomeHeaderDisplayed() {
        return find(homeHeader).isDisplayed();
    }

    public BasketPage clickBasketLink() {
        click(basketLink);
        return new BasketPage(driver);
    }



}
