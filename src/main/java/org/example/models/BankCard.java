package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankCard {

    @JsonProperty
    private String cardNumber;
    @JsonProperty
    private String expirationDate;
    @JsonProperty
    private String cvv;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }
}
