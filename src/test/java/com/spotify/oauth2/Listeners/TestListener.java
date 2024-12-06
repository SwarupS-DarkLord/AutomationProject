package com.spotify.oauth2.Listeners;

import com.spotify.oauth2.Annotation.TestExecutionAnnotation;
import org.json.JSONException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Optional;

import static com.spotify.oauth2.TeamsIntegrationService.TeamsServiceProvider.sendTeamsMessage;
import static com.spotify.oauth2.jiraserviceprovider.JiraService.updateJiraExecutionStatus;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        try {
            sendTeamsMessage("Test Started", result.getName() + " has started.");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            sendTeamsMessage("This test has passed", result.getName() );
            String testExecutionKey = Optional.of(result.getMethod().getConstructorOrMethod().getMethod()
                    .getAnnotation(TestExecutionAnnotation.TestExecutionDetails.class).key()).get();
            System.out.println(testExecutionKey);
           updateJiraExecutionStatus("Pass",testExecutionKey);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            sendTeamsMessage("This test has Failed", result.getName() );
            String testExecutionKey = Optional.of(result.getMethod().getConstructorOrMethod().getMethod()
                    .getAnnotation(TestExecutionAnnotation.TestExecutionDetails.class).key()).get();
            updateJiraExecutionStatus("Fail",testExecutionKey);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }



}
