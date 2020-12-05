package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.dto.SessionDto;
import ru.itis.models.Buyer;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_FIND_BY_EMAIL = "select * from account where email = ?";
    //language=SQL
    private static final String SQL_FIND_ALL = "select * from account";
    //language=SQL
    private static final String SQL_SAVE = "insert into account (email, name, hash_password, session) values (?, ?, ?, ?)";
    //language=SQL
    private static final String SQL_FIND_SESSION_BY_USER_ID = "select id, session from account where id = ?";
    //language=SQL
    private static final String SQL_ADD_SESSION_TO_USER = "update account set session = ? where id = ?";
    //language=SQL
    private static final String SQL_FIND_SESSION_BY_SESSION_ID = "select id, session from account where session = ?";
    //language=SQL
    private static final String SQL_FIND_USER_BY_ID = "select * from account where id = ?";
    //language=SQL
    private static final String SQL_FIND_USER_BY_SESSION_ID = "select * from account where session = ?";
    //language=SQL
    private static final String SQL_ADD_USER_TO_BUYERS = "insert into buyer(userId, name) values (?, ?)";
    //language=SQL
    private static final String SQL_FIND_BUYERS = "select * from buyer";

    private RowMapper<User> userRowMapper = (row, rowNumber) -> {
        return User.builder()
                .id(row.getLong("id"))
                .email(row.getString("email"))
                .name(row.getString("name"))
                .hashPassword(row.getString("hash_password"))
                .session(row.getString("session"))
                .build();
    };

    private RowMapper<SessionDto> sessionDtoRowMapper = (row, rowMapper) -> {
        return SessionDto.builder()
                .userId(row.getLong("id"))
                .sessionId(row.getString("session"))
                .build();
    };

    private RowMapper<User> buyerRowMapper = (row, rowMapper) -> {
        return User.builder()
                .id(row.getLong("userId"))
                .name(row.getString("name"))
                .build();
    };

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getBuyers() {
        return jdbcTemplate.query(SQL_FIND_BUYERS, buyerRowMapper);
    }

    @Override
    public void addUserToBuyers(User user) {
        jdbcTemplate.update(SQL_ADD_USER_TO_BUYERS, user.getId(), user.getName());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, userRowMapper, email));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findUserById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_USER_BY_ID, userRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<SessionDto> findSessionByUserId(Long userId) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_SESSION_BY_USER_ID, sessionDtoRowMapper, userId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findUserBySessionId(String session) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_USER_BY_SESSION_ID, userRowMapper, session));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<SessionDto> findSessionBySessionId(String sessionId) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_SESSION_BY_SESSION_ID, sessionDtoRowMapper, sessionId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void addSessionToUser(Long id, String session) {
        //"update account set session = ? where id = ?"
        jdbcTemplate.update(SQL_ADD_SESSION_TO_USER, session, id);
    }

    @Override
    public void save(User entity) {
        //"insert into account (id, email, name, hash_password, uuid) values (?, ?, ?, ?, ?)"
        jdbcTemplate.update(SQL_SAVE,
                entity.getEmail(),
                entity.getName(),
                entity.getHashPassword(),
                entity.getSession());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, userRowMapper);
    }
}
