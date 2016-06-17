package com.tests.crayfish.improvetestapp.Services;


public class BaseService
{
    public IServiceHandler serviceHandler;

    public void BaseService(IServiceHandler serviceHandler)
    {
        this.serviceHandler = serviceHandler;
    }
}
