package ru.itis.util;


import ru.itis.dto.UserDto;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

public class UserUtil {

    private UsersRepository usersRepository;

    public UserUtil(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<User> getUserById(Long id) {
        return usersRepository.findUserById(id);
    }

    public User getUserBySessionId(String session) {
        return User.fromOptional(usersRepository.findUserBySessionId(session));
    }

    public void addUserToBuyers(User user) {
        usersRepository.addUserToBuyers(user);
    }

    public List<User> getBuyers() {
        return usersRepository.getBuyers();
    }
}
