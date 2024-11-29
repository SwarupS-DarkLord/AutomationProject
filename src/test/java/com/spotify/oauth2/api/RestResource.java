package com.spotify.oauth2.api;

import io.restassured.response.Response;

import java.util.Map;

import static com.spotify.oauth2.api.Routes.API;
import static com.spotify.oauth2.api.Routes.TOKEN;
import static com.spotify.oauth2.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, String token, Object requestPlaylist) {
        return given(getRequestSpec()).
                 auth().oauth2(token)
                .body(requestPlaylist).when()
                .post(path)
                .then().spec(getResponseSpec()).extract().response();
    }

    public static Response postApi(Map<String, String> formParamMap) {
        return given(getAccountsRequestSpecForUrlEncoded())
                .formParams(formParamMap)
                .when()
                .post(API + TOKEN)
                .then()
                .extract().response();
    }

    public static Response get(String path, String token) {
        return given(getRequestSpec()).when()
                .auth().oauth2(token)
                .get(path)
                .then().spec(getResponseSpec()).extract().response();
    }

    public static Response update(String path, String token, Object requestPlaylist) {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(requestPlaylist)
                .when()
                .put(path)
                .then().spec(getResponseSpec()).extract().response();
    }
}
