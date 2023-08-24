package com.skyline.hotelalura.views.validators.validationOptions;

public class NumberValidator extends Validator {
    protected String message = "The field %s must be a valid number";
    private final static String NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage( String message ) {
        this.message = message;
    }

    @Override
    public boolean isValid( String value ) {
        return value.matches( NUMBER_REGEX );
    }
}
