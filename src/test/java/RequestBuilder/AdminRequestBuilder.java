package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;

import static Commons.BasePaths.*;
import static Commons.TestData.*;
import static PayloadBuilder.AdminPayload.AdminUserLoginPayload;


public class AdminRequestBuilder {

    private static String adminToken;

    public static Response AdminLogin(){

        Response response = RestAssured.given()
                .log().all()
                .baseUri(BASE_URL)
                .basePath(LOGIN_PATH)
                .header("Content-Type","application/json")
                .body(AdminUserLoginPayload(adminEmail,adminPassword))
                .post()
                .then()
                .log().all()
                .extract()
                .response();
        adminToken = response.jsonPath().getString("data.token");
        return response;


    }
    public static String getAdminToken(){
        return adminToken;
    }

    public static Response AdminUserProfile(){
        Response response = RestAssured.given()
                .log().all()
                .baseUri(BASE_URL)
                .basePath(VIEW_PROFILE)


    }


}
