package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class ApiTest {
    String TEST_USER_ID = "1";
    String TEST_POST_BODY = "This post is created as a test post by restAssured";
    String TEST_POST_TITLE = "Test New Created Post";

    @BeforeClass
    public void init() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @Test
    public void verifyGetUserEmail() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("users/" + TEST_USER_ID)
                .then()
                .assertThat().statusCode(200)
                .and()
                .extract().response();

        // print the user email in the console
        System.out.println("Email for userId [" + TEST_USER_ID + "] is: " + response.jsonPath().getString("email"));
    }

    @Test
    public void verifyGetUserPostsIds() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("posts?userId={userId}", TEST_USER_ID)
                .then()
                .assertThat().statusCode(200)
                .and()
                .extract().response();

        // get all Ids from User Posts List
        List<Integer> userPostsIds = response.jsonPath().getList("id");

        // print number of posts found for this user
        System.out.println("Number of posts for userId [" + TEST_USER_ID + "] is: " + userPostsIds.size());

        // verify that all posts ids is valid (between 0-100)
        Assert.assertTrue(isAllListValuesBetween(userPostsIds, 0, 100));
    }

    @Test
    public void verifyPostNewUserPost() {
        String newPostRequest = buildNewUserPostRequest();

        Response response = given()
                .contentType("application/json")
                .when()
                .body(newPostRequest)
                .post("posts")
                .then()
                .assertThat().statusCode(201)
                .and()
                .extract().response();

        // Assert that The returned Post should contains all request values and newly generated id (101)
        Assert.assertEquals(response.jsonPath().getString("userId"), TEST_USER_ID);
        Assert.assertEquals(response.jsonPath().getString("body"), TEST_POST_BODY);
        Assert.assertEquals(response.jsonPath().getString("title"), TEST_POST_TITLE);
        Assert.assertEquals(response.jsonPath().getString("id"), "101");

        // print the new created post id
        System.out.println("The new post is created with id: " + response.jsonPath().getString("id"));
    }

    private String buildNewUserPostRequest(){
        return new JSONObject()
                .put("userId", TEST_USER_ID)
                .put("body", TEST_POST_BODY)
                .put("title", TEST_POST_TITLE).toString();
    }

    private boolean isAllListValuesBetween(List<Integer> items, int start, int end) {
        for (Integer id : items) {
            if (!(id >= start && id <= end)) return false;
        }
        return true;
    }

}
