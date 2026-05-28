package com.sweetshop.pages;

public class CheckoutData {

    private String firstName;
    private String lastName;
    private String email;
    private String address1;
    private String address2;
    private String country;
    private String city;
    private String zip;
    private String ccName;
    private String ccNumber;
    private String expDate;
    private String cvv;


    public CheckoutData(
            String firstName,
            String lastName,
            String email,
            String address1,
            String address2,
            String country,
            String city,
            String zip,
            String ccName,
            String ccNumber,
            String expDate,
            String cvv
            )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.country = country;
        this.city = city;
        this.zip = zip;
        this.ccName = ccName;
        this.ccNumber = ccNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getCcName() {
        return ccName;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getCvv() {
        return cvv;
    }
}
