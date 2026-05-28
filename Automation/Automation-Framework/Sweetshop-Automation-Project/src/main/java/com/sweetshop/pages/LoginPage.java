package com.sweetshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By emailField = By.xpath("//input[@id='exampleInputEmail']");
    private By passwordField = By.xpath("//input[@id='exampleInputPassword']");
    private By loginButton = By.id("btn_login");
    private By emailErrorMessage = By.xpath("//div[@class='invalid-feedback invalid-email']");
    private By passwordErrorMessage = By.xpath("//div[@class='invalid-feedback invalid-password']");
    private By homePageLink = By.xpath("//a[contains(@class, 'navbar-brand)]");
    private By loginHeader = By.xpath("//h1[normalize-space()='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        set(emailField, email);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public AccountPage clickLoginButton() {
        click(loginButton);
        return new AccountPage(driver);
    }

    public AccountPage logIntoApplication(String email, String password) {
        setEmail(email);
        setPassword(password);
        return clickLoginButton();
    }

    public String getEmailErrorMessage() {
        return find(emailErrorMessage).getText();
    }

    public String getPasswordErrorMessage() {
        return find(passwordErrorMessage).getText();
    }

    public HomePage goToHomePage() {
        click(homePageLink);
        return new HomePage(driver);
    }

    public boolean isLoginHeaderDisplayed() {
        return find(loginHeader).isDisplayed();
    }


}
