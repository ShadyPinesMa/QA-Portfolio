package com.sweetshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private By chocolateCups = By.xpath("//*[@data-name='Chocolate Cups']");
    private By sherbertDiscs = By.xpath("//*[@data-name='Sherbet Discs']");
    private By bonbons = By.xpath("//*[@data-name='Strawberry Bon Bons']");
    private By jellies = By.xpath("//*[@data-name='Jellies']");
    private By fruitSalads = By.xpath("//*[@data-name='Fruit Salads']");
    private By whamBars = By.xpath("//*[@data-name='Wham Bar']");
    private By chocolateBeans = By.xpath("//*[@data-name='Chocolate Beans']");
    private By nerds = By.xpath("//*[@data-name='Nerds']");
    private By homePageLink = By.xpath("//a[contains(@class, 'navbar-brand)]");
    private By basketLink = By.xpath("//a[@href='/basket']");
    private By numItemsInBasket = By.xpath("//span[contains(@class, 'badge-success')]");
    private By productsHeader = By.xpath("//h1[text()='Browse sweets']");

    public void addChocolateCupsToBasket() {
        click(chocolateCups);
    }

    public void addSherbertDiscsToBasket() {
        click(sherbertDiscs);
    }

    public void addBonBonsToBasket() {
        click(bonbons);
    }

    public void addJelliesToBasket() {click(jellies);}

    public void addFruitSaladsToBasket() {
        click(fruitSalads);
    }

    public void addWhamBarsToBasket() {
        click(whamBars);
    }

    public void addChocolateBeansToBasket() {
        click(chocolateBeans);
    }

    public void addNerdsToBasket() {
        click(nerds);
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        click(homePageLink);
        return new HomePage(driver);
    }

    public BasketPage goToBasketPage() {
        click(basketLink);
        return new BasketPage(driver);
    }

    public boolean isProductsHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }

    public String getNumItemsInBasket() {
        return find(numItemsInBasket).getText();
    }


}
