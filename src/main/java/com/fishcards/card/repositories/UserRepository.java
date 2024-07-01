package com.fishcards.card.repositories;

import com.fishcards.card.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
