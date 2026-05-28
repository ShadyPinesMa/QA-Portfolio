package com.sweetshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private By numberOfOrdersPlaced = By.id("accountOrderCount");
    private By pastTransactions = By.id("transactions");
    private By homePageLink = By.xpath("//a[contains(@class, 'navbar-brand)]");
    private By accountHeader = By.xpath("//h1[normalize-space()='Your Account']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public int numberOfOrdersPlacedDisplayed() {
        return Integer.parseInt(find(numberOfOrdersPlaced).getText());
    }

    public boolean arePastTransactionsDisplayed() {
        return find(pastTransactions).isDisplayed();
    }

    public HomePage goToHomePage() {
        click(homePageLink);
        return new HomePage(driver);
    }

    public boolean isAccountHeaderDisplayed() {
        return find(accountHeader).isDisplayed();
    }
}
