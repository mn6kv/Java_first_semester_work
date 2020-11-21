package ru.itis.models;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private Long id;
    private String email;
    private String name;
    private String hashPassword;
    private String session;

    public static User fromOptional(Optional<User> optionalUser) {
        return optionalUser.orElse(null);
    }
}