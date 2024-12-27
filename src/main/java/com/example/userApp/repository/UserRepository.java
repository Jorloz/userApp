package com.example.userApp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.userApp.model.Document;
import com.example.userApp.model.User;

@Repository
public class UserRepository {
        List<User> users = List.of(
                        new User(1110585463, Document.C, "Jorge", "Andrés", "Lozano", "Jiménez", "3115085818",
                                        "Carrera 60 #4-45", "Bogotá D.C."),
                        new User(23445322, Document.C, "Jhon", "", "Doe", "", "3100000000",
                                        "Carrera 60 #4-45", "Bogotá D.C."),
                        new User(2, Document.P, "test", "", "test", "", "300000000",
                                        "Carrera 60 #4-45", "Bogotá D.C."));

        public List<User> findAll() {
                return users; // Trae lista de todos los usuarios simulando select * from base de datos
        };
}
