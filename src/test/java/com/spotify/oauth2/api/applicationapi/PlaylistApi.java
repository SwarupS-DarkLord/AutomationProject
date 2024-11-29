package com.spotify.oauth2.api.applicationapi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Routes.PLAYLISTS;
import static com.spotify.oauth2.api.Routes.USERS;
import static com.spotify.oauth2.api.TokenManager.getAccessToken;

public class PlaylistApi {

    @Step
    public static Response post(Playlist requestPlaylist) {
        String path = USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS;
        return RestResource.post(path, getAccessToken(), requestPlaylist);

    }

    @Step
    public static Response post(String token, Playlist requestPlaylist) {
        String path = USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS;
        return RestResource.post(path, token, requestPlaylist);

    }

    @Step
    public static Response get(String playlistId) {
        String path = PLAYLISTS + "/" + playlistId;
        return RestResource.get(path,getAccessToken());

    }

    @Step
    public static Response update(String playlistId, Playlist requestPlaylist) {
        String path = PLAYLISTS + "/" + playlistId;
        return RestResource.update(path,getAccessToken(),requestPlaylist);

    }
}
