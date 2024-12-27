package com.example.userApp.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.userApp.model.Document;
import com.example.userApp.model.User;
import com.example.userApp.service.UserService;

import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @SuppressWarnings("removal")
    @MockBean
    private UserService userService;

    @Test
    public void testGetUserByDocument_UserFound() {
        Integer documentId = 123;
        String documentType = "P";
        Document documentTypeTyped = Document.valueOf(documentType);
        User mockUser = new User(123, Document.P, "Jorge", "Andrés", "Lozano", "Jiménez", "3115085818",
                "Carrera 60 #4-45", "Bogotá D.C.");

        when(userService.findUserByDocument(documentId, documentTypeTyped)).thenReturn(mockUser);
        ResponseEntity<?> response = userController.getUserByDocument(documentId, documentType);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());
        User user = (User) response.getBody();
        assertEquals("Jorge", user.getFirstName());
    }

    @Test
    public void testGetUserByDocument_UserNotFound() {
        Integer documentId = 456;
        String documentType = "C";
        Document documentTypeTyped = Document.valueOf(documentType);

        when(userService.findUserByDocument(documentId, documentTypeTyped)).thenReturn(null);

        ResponseEntity<?> response = userController.getUserByDocument(documentId, documentType);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        assertNotNull(response.getBody());
        assertTrue(response.getBody() instanceof String);
        String errorMessage = (String) response.getBody();
        assertTrue(errorMessage.contains("User not found"));
    }

    @Test
    public void testGetUserByDocument_InvalidDocumentType() {
        Integer documentId = 789;
        String invalidDocumentType = "T"; // Tipo de documento inválido.

        ResponseEntity<?> response = userController.getUserByDocument(documentId, invalidDocumentType);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        assertNotNull(response.getBody());
        assertTrue(response.getBody() instanceof String);
        String errorMessage = (String) response.getBody();
        assertTrue(errorMessage.contains("Invalid document type"));
    }
}
