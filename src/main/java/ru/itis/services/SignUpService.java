package ru.itis.services;

import ru.itis.dto.UserForm;

public interface SignUpService {
    boolean signUp(UserForm userForm, String session);
    boolean isExistByEmail(String email);
}
