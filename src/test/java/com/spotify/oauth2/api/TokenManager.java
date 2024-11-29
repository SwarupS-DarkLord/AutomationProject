package com.spotify.oauth2.api;

import com.spotify.oauth2.utils.ConfigLoader;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static com.spotify.oauth2.api.RestResource.postApi;

public class TokenManager {

    private static Instant expiredTime;
    private static String accessToken;

    public static String getAccessToken()
    {
        try {
            if (accessToken == null || Instant.now().isAfter(expiredTime)) {
                System.out.println("Renewing token...");
                Response response = renewToken();
                accessToken = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiredTime = Instant.now().plusSeconds(expiryDurationInSeconds);
            } else {
                System.out.println("Token looks good. No need to renew!");
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Abort! Failed to get token");
        }
         return accessToken;
    }

    private synchronized static Response renewToken()
    {
        Map<String,String> formParamMap = new HashMap<>();
        formParamMap.put("grant_type", ConfigLoader.getInstance().getGrantType());
        formParamMap.put("refresh_token",ConfigLoader.getInstance().getRefreshToken());
        formParamMap.put("client_id",ConfigLoader.getInstance().getClientId());
        formParamMap.put("client_secret",ConfigLoader.getInstance().getClientSecret());

        Response response = postApi(formParamMap);
        if(response.statusCode()!=200)
        {
            throw new RuntimeException("Abort! Renew token failed");
        }
        return  response;
    }
}
