package com.sweetshop.base;

import com.sweetshop.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ProductsPage productsPage;
    protected LoginPage loginPage;
    protected BasketPage basketPage;
    protected AccountPage accountPage;

    private String url = "https://sweetshop.vivrichards.co.uk/";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);
        basketPage = new BasketPage(driver);
        accountPage = new AccountPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
