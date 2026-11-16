package Tests;

import RequestBuilder.RegisterUserRequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class NdosiApiTests {

    @Test
    public void testRegisterUser()
    {
        Response response = RegisterUserRequestBuilder.registerUser();

        assertEquals(response.getStatusCode(),201,"Expected status code 201 for a successful user registration");
        assertNotNull(RegisterUserRequestBuilder.getRegisteredUserId(),"User Id should not be null");
        System.out.println("Registered User ID: " + RegisterUserRequestBuilder.getRegisteredUserId());

    }
}
