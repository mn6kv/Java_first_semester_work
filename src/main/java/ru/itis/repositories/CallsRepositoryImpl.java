package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class CallsRepositoryImpl implements CallsRepository {

    private JdbcTemplate jdbcTemplate;

    public CallsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_ADD_CALL = "insert into call(number) values (?)";

    @Override
    public void addNumber(String number) {
        jdbcTemplate.update(SQL_ADD_CALL, number);
    }
}
