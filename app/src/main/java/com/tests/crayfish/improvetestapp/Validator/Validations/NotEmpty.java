package com.tests.crayfish.improvetestapp.Validator.Validations;


import android.content.Context;
import android.text.TextUtils;

import com.tests.crayfish.improvetestapp.R;

public class NotEmpty extends BaseValidation
{

    public static Validation build(Context context)
    {
        return new NotEmpty(context);
    }

    private NotEmpty(Context context)
    {
        super(context);
    }

    @Override
    public String getErrorMessage()
    {
        return mContext.getString(R.string.v_empty);
    }

    @Override
    public boolean isValid(String text)
    {
        return !TextUtils.isEmpty(text);
    }

}
