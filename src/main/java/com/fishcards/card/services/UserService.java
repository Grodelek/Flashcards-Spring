package com.fishcards.card.services;

import com.fishcards.card.models.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
}
