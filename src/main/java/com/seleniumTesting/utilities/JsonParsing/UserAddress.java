package com.seleniumTesting.utilities.JsonParsing;

/**
 * Created by jerem on 5/14/2016.
 */
public class UserAddress {
    private String city;
    private String state;
    private String zipcode;
    private String street;

    public String getCity (){ return city;}
    public String getState(){return state;}
    public String getZipcode(){return zipcode;}
    public String getStreet() {return street;}

    public void setCity(String newCity){ city = newCity;}
    public void setState(String newState){ state = newState;}
    public void setZipcode(String newZipcode){zipcode = newZipcode;}
    public void setStreet(String newStreet) {street = newStreet;}

}