package com.tests.crayfish.improvetestapp.Validator.Validations;


import android.content.Context;

import com.tests.crayfish.improvetestapp.R;

public class IsPositiveInteger extends BaseValidation
{

    public static final String POSITIVE_INT_PATTERN = "\\d+";

    private IsPositiveInteger(Context context)
    {
        super(context);
    }

    public static Validation build(Context context)
    {
        return new IsPositiveInteger(context);
    }

    @Override
    public String getErrorMessage()
    {
        return mContext.getString(R.string.v_not_positive_integer);
    }

    @Override
    public boolean isValid(String text)
    {
        return text.matches(POSITIVE_INT_PATTERN);
    }
}