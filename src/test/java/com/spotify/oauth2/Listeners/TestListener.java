package com.spotify.oauth2.Listeners;

import com.spotify.oauth2.utils.PropertyUtils;
import com.spotify.oauth2.utils.UrlLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final String WEBHOOK_URL = "https://epam.webhook.office.com/webhookb2/ca558ccc-a760-4486-84fc-a1c986e317dc@b41b72d0-4e9f-4c26-8a69-f949f367c91d/IncomingWebhook/7c0bf4dc2a9a4a8db127ec764b301896/b8e34ee0-4b5e-4070-8e1f-e40d1af2ab69/V24uJa_2Vm7TQKbG15NOOO_AJXnZufyZkUJ0N1OnItfFU1";


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
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            sendTeamsMessage("This test has Failed", result.getName() );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendTeamsMessage(String title, String message) throws JSONException {
        // Create the JSON payload for Teams message
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("text", message);

        // Send the message to Teams via Rest Assured
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toString())
                .post(UrlLoader.getInstance().getUrlWebHook());

    }
}
