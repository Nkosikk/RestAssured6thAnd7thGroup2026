package Tests;

import RequestBuilder.AdminRequestBuilder;
import RequestBuilder.RegisterUserRequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class NdosiApiTests {

    @Test(priority = 1)
    public void testRegisterUser()
    {
        Response response = RegisterUserRequestBuilder.registerUser();

        assertEquals(response.getStatusCode(),201,"Expected status code 201 for a successful user registration");
        assertNotNull(RegisterUserRequestBuilder.getRegisteredUserId(),"User Id should not be null");
        System.out.println("Registered User ID: " + RegisterUserRequestBuilder.getRegisteredUserId());

    }
    @Test(priority = 2)
    public void testAdminLogin()
    {
        Response response = AdminRequestBuilder.AdminLogin();

        assertEquals(response.getStatusCode(),200,"Expected status code 200 for a successful admin login");
        assertNotNull(AdminRequestBuilder.getAdminToken(),"Admin Token should not be null");
        System.out.println("Admin Token: " + AdminRequestBuilder.getAdminToken());
    }

    @Test(priority = 3)
    public void adminApproveUser()
    {
        String userId = RegisterUserRequestBuilder.getRegisteredUserId();

        Response response = AdminRequestBuilder.adminApproveUser(userId);
        assertEquals(response.getStatusCode(),200,"Expected status code 200 for a successful admin user approval");

    }
    @Test(priority = 4)
    public void viewAdminProfile()
    {
        Response response = AdminRequestBuilder.AdminUserProfile();
        assertEquals(response.getStatusCode(),200,"Expected status code 200 for a successful admin user profile");
        assertEquals(response.jsonPath().getString("data.FirstName"),"Sisa");
    }



}
