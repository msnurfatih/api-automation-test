package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import requests.StudentRequest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StudentTest {

    @Test
    public void testGetAllStudent() {

        Response response = StudentRequest.getAllStudent();

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("success"));
    }

    @Test
    public void testGetStudentByUuid() {

        Response response = StudentRequest.getStudentByUuid();

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("success"));
    }

    @Test
    public void testCreateStudent() {

        Response response = StudentRequest.createStudent();

        assertEquals(response.getStatusCode(), 201);
        assertTrue(response.getBody().asString().contains("success"));
    }

    @Test
    public void testUpdateStudent() {

        Response response = StudentRequest.updateStudent();

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("success"));
    }

    @Test
    public void testPatchStudent() {

        Response response = StudentRequest.patchStudent();

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.getBody().asString().contains("success"));
    }

    @Test
    public void testUpdateStudentInvalid() {

        Response response = StudentRequest.updateStudentInvalid();

        assertEquals(response.getStatusCode(), 400);
        assertTrue(response.getBody().asString().contains("success"));
        assertTrue(response.getBody().asString().contains("false"));
    }

}