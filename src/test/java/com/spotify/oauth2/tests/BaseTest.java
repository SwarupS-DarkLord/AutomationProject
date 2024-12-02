package com.spotify.oauth2.tests;

import org.json.JSONException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static com.spotify.oauth2.Listeners.TestListener.sendTeamsMessage;


public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("Method name = " + m.getName());
        System.out.println("Thread Id = " + Thread.currentThread().getId());

    }

//    @AfterMethod
//    public void tearDown(ITestResult result,Method m) throws JSONException {
//
//        String methodName = m.getName();
//        int testResult = result.getStatus();
//        if (testResult == 1) {
//            System.out.println("Method name after method is passed is " + methodName + "  " + ITestResult.SUCCESS);
//        } else if (testResult == 2) {
//            System.out.println("Method name after method is failed is " + methodName + "  " + ITestResult.FAILURE);
//        }
//        sendTeamsMessage("Test End", result.getName() + " has ended");
//
//    }
}
