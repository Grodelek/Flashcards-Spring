package com.fishcards.card;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
 
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 7 , message = "Minimum 7 letters")
    private String login;
    @NotNull
    @Size(min = 7,  message = "Minimum 7 letters")
    private String password;
}
