package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static Commons.BasePaths.BASE_URL;
import static Commons.BasePaths.REGISTER_PATH;
import static Commons.TestData.*;
import static PayloadBuilder.RegisterUserPayload.registerUserPayload;

public class RegisterUserRequestBuilder {

    public static Response registerUser()
    {
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String email = generateEmail();
        String password = generatePassword();
        String confirmPassword = password;

        Response response = RestAssured.given()
                .log().all()
                .baseUri(BASE_URL)
                .basePath(REGISTER_PATH)
                .header("Content-Type","application/json")
                .body(registerUserPayload(firstName,lastName,email,password,confirmPassword,GroupID))
                .post()
                .then()
                .log().all()
                .extract()
                .response();
        return response;
    }

}
