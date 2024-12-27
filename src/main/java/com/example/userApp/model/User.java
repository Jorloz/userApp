package com.example.userApp.model;

public class User {
    private Integer documentId;
    private Document documentType;
    private String firstName;
    private String secondFirstName;
    private String lastName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String city;

    // Constructor
    public User(Integer documentId, Document documentType, String firstName,
            String secondFirstName, String lastName, String secondLastName,
            String phoneNumber, String address, String city) {
        this.documentId = documentId;
        this.documentType = documentType;
        this.firstName = firstName;
        this.secondFirstName = secondFirstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
    }

    // Getters and Setters
    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Document getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Document documentType) {
        this.documentType = documentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondFirstName() {
        return secondFirstName;
    }

    public void setSecondFirstName(String secondFirstName) {
        this.secondFirstName = secondFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}