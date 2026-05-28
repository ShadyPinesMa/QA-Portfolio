package com.sweetshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class BasketPage extends BasePage{

    private By firstNameField = By.xpath(" //label[normalize-space()='First name']/following-sibling::input");
    private By lastNameField = By.xpath( "//label[normalize-space()='Last name']/following-sibling::input");
    private By emailField = By.id("email");
    private By address1Field = By.id("address");
    private By address2Field = By.id("address2");
    private By countryDropDown = By.id("country");
    private By cityDropDown = By.id("city");
    private By zipField = By.id("zip");
    private By cardNameField = By.id("cc-name");
    private By cardNumField = By.id("cc-number");
    private By expDateField = By.id("cc-expiration");
    private By cvvField = By.id("cc-cvv");
    private By checkoutButton = By.xpath("//button[contains(text(), 'checkout')]");
    private By radioBtnFreeShipping = By.xpath("//label[@for='exampleRadios1']");
    private By radioBtnStandardShipping = By.xpath("//label[@for='exampleRadios1']");
    private By emptyBasketLink = By.xpath("//a[@href='#']");
    private By basketHeader = By.xpath("//h1[normalize-space()='Your Basket']");
    private By yourBasket = By.xpath("//ul[@id='basketItems']");

    //ERRORS

    private By firstNameError = By.xpath("//div[normalize-space()='Valid first name is required.']");
    private By lastNameError = By.xpath("//div[normalize-space()='Valid last name is required.']");
    private By emailError = By.xpath("//div[normalize-space()='Please enter a valid email address for shipping updates.']");
    private By address1Error = By.xpath("//div[normalize-space()='Please enter your shipping address.']");
    private By countryError = By.xpath("//div[normalize-space()='Please select a valid country.']");
    private By cityError = By.xpath("//div[normalize-space()='Please provide a valid state.']");
    private By zipError = By.xpath("//div[normalize-space()='Zip code required.']");
    private By cardNameError = By.xpath("//div[normalize-space()='Name on card is required']");
    private By cardNumError = By.xpath("//div[normalize-space()='Credit card number is required']");
    private By expDateError = By.xpath("//div[normalize-space()='Expiration date required']");
    private By cvvError = By.xpath("//div[normalize-space()='Security code required']");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(String firstName) {set(firstNameField, firstName);}

    public void setLastName(String lastName) {set(lastNameField, lastName);}

    public void setEmail(String email) {set(emailField, email);}

    public void setAddress1(String addressPt1) {set(address1Field, addressPt1);}

    //Address 2 not required, so it got skipped
    public void setAddress2(String addressPt2) {set(address2Field, addressPt2);}

    public void setCountry(String country) {
        Select countrySelect = new Select(find(countryDropDown));
        countrySelect.selectByVisibleText(country);
    }

    public void setCity(String city) {
        Select citySelect = new Select(find(cityDropDown));
        citySelect.selectByVisibleText(city);
    }

    public void setZip(int zip) {set(zipField, String.valueOf(zip));}

    public void setCardName(String cardName) {set(cardNameField, cardName);}

    public void setCardNum(String cardNum) {set(cardNumField, cardNum);}

    public void setExpDate(String expDate) {set(expDateField, expDate);}

    public void setCvv(String cvv) {set(cvvField, cvv);}

    public void clickCheckoutButton() {click(checkoutButton);}

    public void clickFreeShipping() {click(radioBtnFreeShipping);}

    public void clickStandardShipping() {click(radioBtnStandardShipping);}

    public void clearBasket() {click(emptyBasketLink);}

    public String getFirstNameValue() {
        return find(firstNameField).getAttribute("value");
    }

    public String getLastNameValue() {
        return find(lastNameField).getAttribute("value");
    }

    public String getEmailValue() {
        return find(emailField).getAttribute("value");
    }

    public String getAddress1Value() {
        return find(address1Field).getAttribute("value");
    }

    public String getAddress2Value() {
        return find(address2Field).getAttribute("value");
    }

    public String getZipValue() {
        return find(zipField).getAttribute("value");
    }

    public String getCardNameValue() {
        return find(cardNameField).getAttribute("value");
    }

    public String getCardNumberValue() {
        return find(cardNumField).getAttribute("value");
    }

    public String getExpDateValue() {
        return find(expDateField).getAttribute("value");
    }

    public String getCvvValue() {
        return find(cvvField).getAttribute("value");
    }

    public boolean isBasketHeaderDisplayed() {
        return find(basketHeader).isDisplayed();
    }

    public String getFirstNameError() {
        return find(firstNameError).getText();
    }

    public String getLastNameError() {
        return find(lastNameError).getText();
    }

    public String getEmailError() {
        return find(emailError).getText();
    }

    public String getAddress1Error() {
        return find(address1Error).getText();
    }

    public String getCountryError() {
        return find(countryError).getText();
    }

    public String getCityError() {
        return find(cityError).getText();
    }

    public String getZipError() {
        return find(zipError).getText();
    }

    public String getCardNameError() {
        return find(cardNameError).getText();
    }

    public String getCardNumError() {
        return find(cardNumError).getText();
    }

    public String getExpDateError() {
        return find(expDateError).getText();
    }

    public String getCvvError() {
        return find(cvvError).getText();
    }

    public boolean isProductInBasket(String productName) {
        List<WebElement> items = driver.findElements(yourBasket);
        for (WebElement item : items) {
            if(item.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public void completeCheckout(CheckoutData data) {
        find(firstNameField).sendKeys(data.getFirstName());
        find(lastNameField).sendKeys(data.getLastName());
        find(emailField).sendKeys(data.getEmail());
        find(address1Field).sendKeys(data.getAddress1());
        if (data.getAddress2() != null && !data.getAddress2().isEmpty()) {
            find(address2Field).sendKeys(data.getAddress2());
        }
        find(address2Field).sendKeys(data.getAddress2());
        Select countrySelect = new Select(find(countryDropDown));
        countrySelect.selectByVisibleText(data.getCountry());
        Select citySelect = new Select(find(cityDropDown));
        citySelect.selectByVisibleText(data.getCity());
        find(zipField).sendKeys(data.getZip());
        find(cardNameField).sendKeys(data.getCcName());
        find(cardNumField).sendKeys(data.getCcNumber());
        find(expDateField).sendKeys(data.getExpDate());
        find(cvvField).sendKeys(data.getCvv());
        clickStandardShipping();
        clickCheckoutButton();
    }

    public boolean checkoutFormIsCleared() {
        return getFirstNameValue().isEmpty()
                && getLastNameValue().isEmpty()
                && getEmailValue().isEmpty()
                && getAddress1Value().isEmpty()
                && getAddress2Value().isEmpty()
                && getZipValue().isEmpty()
                && getCardNameValue().isEmpty()
                && getCardNumberValue().isEmpty()
                && getExpDateValue().isEmpty()
                && getCvvValue().isEmpty();
    }
}
