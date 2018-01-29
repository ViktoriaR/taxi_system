package com.taxi_system.variables;

import java.util.ResourceBundle;

/**
 * Created by Victoria on 29.01.2018.
 */
public enum Variables {
    LOCALE_NAME,
    PAGE_NAME,
    LOGIN_NAME,
    PASSWORD_NAME,
    NAME_NAME,
    FROM_ADDRESS_NAME,
    TO_ADDRESS_NAME,
    CAR_TYPE_NAME,
    CAR_TYPES_NAME,
    USER_NAME,
    ORDER_NAME,
    SAVED_ORDER_NAME,
    EXCEPTION_NAME,

    INDEX_PAGE,
    ORDER_FORM_PAGE,
    PRICE_PAGE,
    DETAILS_PAGE,
    HEADER_PAGE,
    LOGIN_FORM_PAGE,
    REGISTRATION_FORM_PAGE,

    ORDER_DETAILS_COMMAND,

    PRICE_EXCEPTION_MESSAGE,
    LOG_IN_EXCEPTION_MESSAGE,
    BLANK_LOGIN_PASSWORD_EXCEPTION_MESSAGE,
    NO_AVAILABLE_CAR_EXCEPTION_MESSAGE,
    EXCEPTION_MESSAGE,
    LOGIN_EXISTS_EXCEPTION_MESSAGE;

    private String value;

    Variables() {
        ResourceBundle resource = ResourceBundle.getBundle("variables");
        value = (String) resource.getObject(this.name());
    }

    public String getValue() {
        return value;
    }
}
