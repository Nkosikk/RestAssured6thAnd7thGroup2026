package Tests;

import RequestBuilder.RegisterUserRequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NdosiApiTests {

    @Test
    public void testRegisterUser()
    {
        Response response = RegisterUserRequestBuilder.registerUser();

        assertEquals(response.getStatusCode(),201,"Expected status code 201 for a successful user registration");

    }
}
