package ru.itis.services;

import ru.itis.dto.UserDto;
import ru.itis.dto.UserForm;
import ru.itis.models.User;

public interface SignInService {
    UserDto signIn(UserForm userForm);
    User signInWithUser(UserForm userForm);
}
