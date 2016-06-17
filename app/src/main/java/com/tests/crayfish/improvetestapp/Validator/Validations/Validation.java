package com.tests.crayfish.improvetestapp.Validator.Validations;


public interface Validation
{
    String getErrorMessage();

    boolean isValid(String text);
}
