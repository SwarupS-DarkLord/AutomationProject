package com.spotify.oauth2.TeamsIntegrationService;

import com.spotify.oauth2.utils.UrlLoader;
import io.restassured.RestAssured;
import org.json.JSONException;
import org.json.JSONObject;

public final class TeamsServiceProvider {

    private TeamsServiceProvider()
    {

    }

    public static void sendTeamsMessage(String title, String message) throws JSONException {
    // Create the JSON payload for Teams message
    JSONObject json = new JSONObject();
    json.put("title", title);
    json.put("text", message);

    // Send the message to Teams via Rest Assured
    RestAssured.given()
            .header("Content-Type", "application/json")
            .body(json.toString())
            .post(UrlLoader.getInstance().getUrlWebHook());

}
}
