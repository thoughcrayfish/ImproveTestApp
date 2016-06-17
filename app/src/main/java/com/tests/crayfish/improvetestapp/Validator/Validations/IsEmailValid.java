package com.tests.crayfish.improvetestapp.Validator.Validations;


import android.content.Context;

import com.tests.crayfish.improvetestapp.R;

public class IsEmailValid extends BaseValidation
{

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private IsEmailValid(Context context)
    {
        super(context);
    }

    public static Validation build(Context context)
    {
        return new IsEmailValid(context);
    }

    @Override
    public String getErrorMessage()
    {
        return mContext.getString(R.string.v_not_email);

    }

    @Override
    public boolean isValid(String text) {
        return text.matches(EMAIL_PATTERN);
    }
}
