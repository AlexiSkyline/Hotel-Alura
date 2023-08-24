package com.skyline.hotelalura.views.validators.validationOptions;

public abstract class Validator {
    protected String message;
    abstract public String getMessage();
    abstract public void setMessage( String message );
    abstract public boolean isValid( String value );
}
