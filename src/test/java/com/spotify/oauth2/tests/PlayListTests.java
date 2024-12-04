package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.StatusCodeEnum;
import com.spotify.oauth2.api.applicationapi.PlaylistApi;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.spotify.oauth2.utils.FakerUtils.generateDescription;
import static com.spotify.oauth2.utils.FakerUtils.generateName;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("Allure examples")
@Feature("Junit 4 support")
public class PlayListTests extends BaseTest {


    @BeforeClass
    public void setUp() {
        useRelaxedHTTPSValidation();

    }

    @Step
    public Playlist playlistBuilder(String description, String name, boolean _public) {
        return Playlist.builder().description(description).name(name)._public(_public).build();

    }

    @Step
    public void assertPlaylistEqual(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(responsePlaylist.getName(), is(equalTo(requestPlaylist.getName())));
        assertThat(responsePlaylist.getDescription(), is(equalTo(requestPlaylist.getDescription())));
        assertThat(responsePlaylist.get_public(), is(equalTo(requestPlaylist.get_public())));
    }

    @Step
    public void assertStatusCode(int actualStatusCode, StatusCodeEnum expectedStatusCode) {
        assertThat(actualStatusCode, is(equalTo(expectedStatusCode.getCode())));
    }

    //    @Step
//    public void assertError(Error error, String expectedErrorMessage, int statusCode) {
//        assertThat(error.getError().getMessage(), is(equalTo(expectedErrorMessage)));
//        assertThat(error.getError().getStatus(), is(equalTo(statusCode)));
//    }
    @Step
    public void assertError(Error error, StatusCodeEnum statusCode) {
        assertThat(error.getError().getMessage(), is(equalTo(statusCode.getMessage())));
        assertThat(error.getError().getStatus(), is(equalTo(statusCode.getCode())));
    }

    @Story("Create a playlist")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Description("This is the description")
    @Test(description = "Create a playlist")
    public void createAPlaylist() {
        Playlist requestPlaylist = playlistBuilder("New playlist description",
                "New Playlist", false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCodeEnum.CODE_201);
        Playlist responsePlaylist = response.as(Playlist.class);
        assertPlaylistEqual(responsePlaylist, requestPlaylist);

    }

//    @Issue("432")
//    @Description("This is the description")
//    @Test(description = "Gets the playlist")
//    public void getAPlaylist() {
//        Playlist requestPlaylist = playlistBuilder("New playlist description",
//                "New Playlist", false);
//        Response response = PlaylistApi.get(DataLoader.getInstance().getGetPlaylistId());
//        assertStatusCode(response.statusCode(), StatusCodeEnum.CODE_200);
//        Playlist responsePlaylist = response.as(Playlist.class);
//        assertPlaylistEqual(responsePlaylist, requestPlaylist);
//
//    }

    @TmsLink("test-2")
    @Description("This is the description")
    @Test(description = "Updates the playlist")
    public void updatePlaylist() {
        Playlist requestPlaylist = playlistBuilder(generateDescription(),
                generateName(),
                false);
        Response response = PlaylistApi.update(DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);
        assertStatusCode(response.getStatusCode(), StatusCodeEnum.CODE_200);

    }

    @Story("Create a playlist")
    @TmsLink("test-6")
    @Description("This is the description")
    @Test(description = "Should not create a playlist with no name")
    public void shouldNotCreateAPlaylistWithNoName() {

        Playlist requestPlaylist = playlistBuilder(generateDescription(),
                "", false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertStatusCode(response.getStatusCode(), StatusCodeEnum.CODE_400);
        Error error = response.as(Error.class);
        assertError(error, StatusCodeEnum.CODE_400);

    }

    @Story("Create a playlist")
    @Description("This is the description")
    @Test(description = "Should not create a playlist with expired token")
    public void shouldNotCreateAPlaylistWithExpiredToken() {
        Playlist requestPlaylist = playlistBuilder(generateDescription(),
                generateName(), false);
        String error_accesstoken = "2e232436";
        Response response = PlaylistApi.post(error_accesstoken, requestPlaylist);
        assertStatusCode(response.getStatusCode(), StatusCodeEnum.CODE_401);
        Error error = response.as(Error.class);
        assertError(error, StatusCodeEnum.CODE_401);
    }
}
