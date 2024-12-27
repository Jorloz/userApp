package com.example.userApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userApp.model.User;
import com.example.userApp.repository.UserRepository;
import com.example.userApp.model.Document;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUserByDocument(Integer documentId, Document documentTypeTyped) {
        List<User> userslist = userRepository.findAll();
        return userslist.stream()
                .filter(user -> (user.getDocumentId().equals(documentId)
                        && user.getDocumentType().equals(documentTypeTyped)))
                .findFirst()
                .orElse(null);
    }
}
