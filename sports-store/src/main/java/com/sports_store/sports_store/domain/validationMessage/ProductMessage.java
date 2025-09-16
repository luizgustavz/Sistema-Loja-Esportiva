package com.sports_store.sports_store.domain.validationMessage;

public final class ProductMessage {

    public final static String REQUIRED_NAME = "The name field is required";
    public final static String INVALID_ARGUMENT = "The argument is invalid";
    public final static String REQUIRED_DESCRIPTION = "The description field is required";
    public final static String INVALID_PRICE = "The price must be greater than zero stock";
    public final static String INVALID_VALUE_STOCK = "The stock value must be greater than zero";

    private ProductMessage(){};
}
