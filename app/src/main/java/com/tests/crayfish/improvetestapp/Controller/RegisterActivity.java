package com.tests.crayfish.improvetestapp.Controller;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tests.crayfish.improvetestapp.Model.RegisterItem;
import com.tests.crayfish.improvetestapp.R;
import com.tests.crayfish.improvetestapp.Validator.Field;
import com.tests.crayfish.improvetestapp.Validator.Form;
import com.tests.crayfish.improvetestapp.Validator.FormUtils;
import com.tests.crayfish.improvetestapp.Validator.Validations.InRange;
import com.tests.crayfish.improvetestapp.Validator.Validations.IsEmailValid;
import com.tests.crayfish.improvetestapp.Validator.Validations.NotEmpty;



public class RegisterActivity extends AppCompatActivity
{
    EditText _nameText, _birthText, _emailText, _userNameText, _passwordText;
    public FloatingActionButton registrationButton;

    // Form used for validation
    private Form mForm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initializing
        RegisterItem registerItem = new RegisterItem();
        registrationButton = (FloatingActionButton) findViewById(R.id.registerbutton);
        // initing edittext fields
        initViews();
        initValidationForm();
        // animating edittexts
        AnimateEditViews();

        registrationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Register();
            }
        });
    }

    private void initViews()
    {
        _nameText = (EditText) findViewById(R.id.editname);
        _birthText = (EditText) findViewById(R.id.editbirth);
        _emailText = (EditText) findViewById(R.id.editemail);
        _userNameText = (EditText) findViewById(R.id.editusername);
        _passwordText = (EditText) findViewById(R.id.editpassword);
    }


    private void initValidationForm()
    {
        mForm = new Form(this);

        mForm.addField(Field.using(_nameText).validate(NotEmpty.build(this)));
        mForm.addField(Field.using(_birthText).validate(InRange.build(this, 0, 120)));
        mForm.addField(Field.using(_emailText).validate(NotEmpty.build(this)).validate(IsEmailValid.build(this)));
        mForm.addField(Field.using(_userNameText).validate(NotEmpty.build(this)));
        mForm.addField(Field.using(_passwordText).validate(NotEmpty.build(this)));
    }

    private void Register()
    {
        //Register logic
    FormUtils.hideKeyboard(RegisterActivity.this, _birthText);
    if (mForm.isValid())
        {
                RegisterItem registerItem = new RegisterItem();
                Toast.makeText(this, getString(R.string.form_is_valid), Toast.LENGTH_LONG).show();
                registerItem.name = _nameText.getText().toString();
                registerItem.birth =_birthText.getText().toString();
                registerItem.email = _emailText.getText().toString();
                registerItem.userName = _userNameText.getText().toString();
                registerItem.password = _passwordText.getText().toString();

                FinishRegistration(registerItem);
        }
    }
    // sending intent to default email client (if it exsists)
    private void FinishRegistration(RegisterItem registerItem)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"Improve@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Registration Info");


        String finalString = "Fullname: " + registerItem.name + "\n" + "Birthdate: " + registerItem.birth + "\n" + "Email Adress: " + registerItem.email + "\n" + "Username: "
                + registerItem.userName + "\n" + "Password: " + registerItem.password;
        i.putExtra(Intent.EXTRA_TEXT   , finalString);
        try
            {
            startActivity(Intent.createChooser(i, "Send mail..."));
            }
        catch (android.content.ActivityNotFoundException ex)
            {
                Toast.makeText(RegisterActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }

    }

    // applying animations
    private void AnimateEditViews()
    {
        final Animation slide_left_in = AnimationUtils.loadAnimation(
            getApplicationContext(), R.animator.slide_from_left);
        final Animation slide_right_in = AnimationUtils.loadAnimation(
                getApplicationContext(), R.animator.slide_from_right);

        _nameText.startAnimation(slide_left_in);
        _birthText.startAnimation(slide_right_in);
        _emailText.startAnimation(slide_left_in);
        _userNameText.startAnimation(slide_right_in);
        _passwordText.startAnimation(slide_left_in);

    }


}
