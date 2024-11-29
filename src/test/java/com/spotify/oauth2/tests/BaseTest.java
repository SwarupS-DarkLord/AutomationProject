package com.spotify.oauth2.tests;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;


public class BaseTest {

//    protected String
    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("Method name = " + m.getName());
        System.out.println("Thread Id = " + Thread.currentThread().getId());

    }
}
