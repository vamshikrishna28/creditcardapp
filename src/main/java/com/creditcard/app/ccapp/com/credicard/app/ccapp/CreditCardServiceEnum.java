package com.creditcard.app.ccapp.com.credicard.app.ccapp;

public enum  CreditCardServiceEnum {

    //(bin_start,bin_end, cardtype, cardsubtype)

    VISADEBIT("455561","", "VISA","DEBIT"),

    AMEXCREDIT("387765","", "AMEX","CREDIT"),

    VISACREDIT("454545", "","VISA", "CREDIT"),

    MCCREDIT("546626", "","MC","CREDIT"),

    VISAPREMIUMCREDIT("444433333","444532332", "VISA", "PREMIUM CREDIT"),

    MCGOLDCREDIT("512176622","512189239", "MC", "GOLD CREDIT"),

    MCBUSINESS("546626193","546691237", "MC", "BUSINESS");

    private String binStart;
    private String binEnd;
    private String cardType;
    private String cardSubType;

    CreditCardServiceEnum(String binStart, String binEnd, String cardType, String cardSubType) {
        this.binEnd = binEnd;
        this.binStart = binStart;
        this.cardSubType = cardSubType;
        this.cardType = cardType;
    }
}
