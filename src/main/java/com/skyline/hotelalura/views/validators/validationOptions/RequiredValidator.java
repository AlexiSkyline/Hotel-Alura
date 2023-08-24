package com.skyline.hotelalura.views.validators.validationOptions;


public class RequiredValidator extends Validator {
    protected String message = "The field %s is required";

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
        return (value != null && value.length() > 0);
    }
}
