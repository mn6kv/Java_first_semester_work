package ru.itis.repositories.productsRepository.deprecated;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Door;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


public class DoorRepositoryJdbcTemplateImpl implements DoorRepository {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_FIND_ALL = "select * from door";

    private RowMapper<Door> doorRowMapper = (row, rowMapper) -> {
        return Door.builder()
                .productClass(row.getString("class"))
                .price(row.getInt("price"))
                .build();
    };

    public DoorRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Door> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, doorRowMapper);
    }

    @Override
    public void save(Door entity) {

    }

    @Override
    public void update(Door entity) {

    }

    @Override
    public void delete(Door entity) {

    }

    @Override
    public Optional<Door> findById(Long id) {
        return Optional.empty();
    }
}
