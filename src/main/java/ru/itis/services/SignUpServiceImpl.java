package ru.itis.services;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.dto.UserDto;
import ru.itis.dto.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

@Data
public class SignUpServiceImpl implements SignUpService {

    UsersRepository usersRepository;
    PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean signUp(UserForm userForm, String session) {

        User user = User.builder()
                .email(userForm.getEmail())
                .name(userForm.getName())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .session(session)
                .build();

        if (User.fromOptional(usersRepository.findByEmail(user.getEmail())) != null)
            return false;

        usersRepository.save(user);
        return true;
    }

    @Override
    public boolean isExistByEmail(String email) {
        return usersRepository.findByEmail(email).isPresent();
    }
}
