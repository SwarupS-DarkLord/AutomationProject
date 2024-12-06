package com.spotify.oauth2.jiraserviceprovider;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public final class JiraService {

    private JiraService()
    {

    }

    public static void updateJiraExecutionStatus(String status, String testExecutionId)
    {  String body = "{\n" +
            "  \"statusName\": \""+ status + "\",\n" +
            "  \"executedById\": \"5b10a2844c20165700ede21g\",\n" +
            "  \"assignedToId\": \"5b10a2844c20165700ede21g\"\n" +
            "\n" +
            "}";
        given().baseUri("https://api.zephyrscale.smartbear.com")
                .contentType(ContentType.JSON)
                .pathParam("testExecId",testExecutionId)
                .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVc" +
                        "mwiOiJodHRwczovL3FhZXBhbS5hdGxhc3NpYW4ubmV0IiwidXNlciI6eyJhY2NvdW50SWQiOiI3MTIwM" +
                        "jA6MTdiZWE4ZmUtYTUyNy00NGI2LWI5ZmMtN2FiZTRhNDBlMDcxIiwidG9rZW5JZCI6IjJmNThmO" +
                        "DM2LTAwNjktNDBlMS05MjliLTk2MDQ1OTYzOWViYiJ9fSwiaXNzIjoiY29tLmthbm9haC50ZXN0" +
                        "LW1hbmFnZXIiLCJzdWIiOiIzYWExYWYxYy0zMGE5LTNlZDAtYTkzMy00Mjk4ZjY0MjdjMzIi" +
                        "LCJleHAiOjE3NjQ5MzE5ODksImlhdCI6MTczMzM5NTk4O" +
                        "X0.TsFckLQTOT922l7QCGWUHjwRFABZda_sdQJKgHlh72A").body(body)
                .log().all()
                .when()
                .put("/v2/testexecutions/{testExecId}").then().log().all().assertThat().statusCode(200);
    }
}
