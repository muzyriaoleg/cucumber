package com.bookdepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String fullName;
    private String deliveryCounty;
    private String addressLine1;
    private String addressLine2;
    private String townCity;
    private String countyState;
    private String postCode;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDeliveryCounty(String deliveryCounty) {
        this.deliveryCounty = deliveryCounty;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public void setCountyState(String countyState) {
        this.countyState = countyState;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDeliveryCounty() {
        return deliveryCounty;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getTownCity() {
        return townCity;
    }

    public String getCountyState() {
        return countyState;
    }

    public String getPostCode() {
        return postCode;
    }
}
