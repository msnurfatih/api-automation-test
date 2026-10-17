package requests;

import io.restassured.response.Response;
import utils.TestConfig;

import static io.restassured.RestAssured.given;

public class StudentRequest {

    public static Response getAllStudent() {

        String token = AuthRequest.getToken();

        return given()
                .baseUri(TestConfig.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/siswa?page=1&limit=11");
    }

    public static Response getStudentByUuid() {

        String token = AuthRequest.getToken();

        return given()
                .baseUri(TestConfig.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/siswa/" + TestConfig.STUDENT_UUID);
    }

    public static Response createStudent() {

        String token = AuthRequest.getToken();

        String uniqueId = String.valueOf(System.currentTimeMillis());

        String requestBody = """
                {
                    "nama": "Muhammad Sulkhan Nurfatih",
                    "nis": "%s",
                    "kelas": "X-IPA-1",
                    "jurusan": "IPA",
                    "email": "msulkhannf%s@example.com",
                    "telepon": "+628123456789",
                    "alamat": "Jl. Contoh No. 2"
                }
                """.formatted(uniqueId, uniqueId);

        return given()
                .baseUri(TestConfig.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/siswa");
    }

    public static Response updateStudent() {

        String token = AuthRequest.getToken();

        String requestBody = """
                {
                    "nama": "Muhammad Sulkhan",
                    "email": "sulkhan@example.com"
                }
                """;

        return given()
                .baseUri(TestConfig.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/siswa/" + TestConfig.STUDENT_UUID);
    }

    public static Response patchStudent() {

        String token = AuthRequest.getToken();

        String requestBody = """
                {
                    "nama": "M Sulkhan"
                }
                """;

        return given()
                .baseUri(TestConfig.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/api/siswa/" + TestConfig.STUDENT_UUID);
    }

    public static Response updateStudentInvalid() {

        String token = AuthRequest.getToken();

        String requestBody = """
                {
                    "nama": "M@#$%",
                    "email": "sulkhan@example.com"
                }
                """;

        return given()
                .baseUri(TestConfig.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/api/siswa/" + TestConfig.STUDENT_UUID);
    }
}