package tests;

import org.testng.annotations.Test;
import requests.AuthRequest;

import static org.testng.Assert.assertNotNull;

public class AuthTest {

    @Test
    public void testLogin() {

        String token = AuthRequest.getToken();

        assertNotNull(token);
    }
}