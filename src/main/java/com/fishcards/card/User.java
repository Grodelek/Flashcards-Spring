package com.fishcards.card;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
}
