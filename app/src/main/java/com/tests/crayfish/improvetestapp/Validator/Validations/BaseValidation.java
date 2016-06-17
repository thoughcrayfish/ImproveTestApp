package com.tests.crayfish.improvetestapp.Validator.Validations;

import android.content.Context;



abstract class BaseValidation implements Validation
    {

        protected Context mContext;

        protected BaseValidation(Context context)
        {
            mContext = context;
        }

    }

