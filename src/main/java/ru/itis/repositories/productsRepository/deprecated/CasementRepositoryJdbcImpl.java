package ru.itis.repositories.productsRepository.deprecated;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Casement;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class CasementRepositoryJdbcImpl implements CasementRepository {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_FIND_ALL = "select * from casement";

    private RowMapper<Casement> casementRowMapper = (row, rowMapper) -> {
        return Casement.builder()
                .productClass(row.getString("class"))
                .price(row.getInt("price"))
                .build();
    };

    public CasementRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Casement> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, casementRowMapper);
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Casement entity) {

    }

    @Override
    public void update(Casement entity) {

    }

    @Override
    public void delete(Casement entity) {

    }
}
