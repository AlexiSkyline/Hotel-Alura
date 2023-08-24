package com.skyline.hotelalura.views.validators;

import com.skyline.hotelalura.views.validators.validationOptions.Validator;
import com.skyline.hotelalura.views.validators.validationOptions.message.FormatMessage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ItemForm {

    protected String name;
    protected String value;

    private final List<Validator> validators;
    private final List<String> errors;

    public ItemForm()
    {
        this.validators = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public ItemForm( String name, String value )
    {
        this();
        this.name = name;
        this.value = value;
    }

    public ItemForm addValidator( Validator validator )
    {
        this.validators.add( validator );
        return this;
    }

    public List<String> getErrors()
    {
        return this.errors;
    }

    public void cleanError()
    {
        this.errors.clear();
    }

    public boolean isValid() {
        for( Validator validator: this.validators ) {
            if( !validator.isValid( this.value ) ) {
                if( validator instanceof FormatMessage) {
                    this.errors.add( ((FormatMessage) validator).getFormatMessage( this.name ) );
                } else {
                    this.errors.add( String.format( validator.getMessage(), this.name ) );
                }
            }
        }

        return this.errors.isEmpty();
    }

    public void printMessage() {
        JOptionPane.showMessageDialog( null, this.errors.get(0), "Error when entering information",
                JOptionPane.WARNING_MESSAGE );
    }
}

