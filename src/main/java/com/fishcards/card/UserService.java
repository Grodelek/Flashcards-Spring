package com.fishcards.card;

import java.util.List;

public interface UserService {
    void save(User user);
    User findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
}
