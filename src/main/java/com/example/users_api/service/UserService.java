package com.example.users_api.service;

import com.example.users_api.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class UserService {

    private final RestClient restClient = RestClient.create();

    @Value("${api.base-url}")
    private String baseUrl;

    // GET ALL USERS
    public List<User> getUsers() {
        return restClient.get()
                .uri(baseUrl)
                .retrieve()
                .body(new ParameterizedTypeReference<List<User>>() {});
    }

    // GET USER BY ID
    public User getUserById(Long id) {
        return restClient.get()
                .uri(baseUrl + "/" + id)
                .retrieve()
                .body(User.class);
    }
}