package requests;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import utils.TestConfig;

public class AuthRequest {

    public static String getToken() {

        String requestBody = """
                {
                    "email": "sulkhan@example.com",
                    "password": "Password123"
                }
                """;

        return given()
                .baseUri(TestConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("data.token");
    }
}