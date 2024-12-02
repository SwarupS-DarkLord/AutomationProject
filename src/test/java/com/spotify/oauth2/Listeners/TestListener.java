package com.spotify.oauth2.Listeners;
import com.spotify.oauth2.utils.UrlLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
