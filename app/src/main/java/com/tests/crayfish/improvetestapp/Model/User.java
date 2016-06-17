package com.tests.crayfish.improvetestapp.Model;

// user creates locally for simpleness
public class User
{

    private String name;
    private String birth;
    private String email;
    private String userName;
    private String password;


    // just in case
    public void User(String name, String email, String userName, String password)
    {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }


    public void User(RegisterItem registerItem)
    {
        this.name = registerItem.name;
        this.email = registerItem.email;
        this.userName = registerItem.userName;
        this.password = registerItem.password;
    }

}
