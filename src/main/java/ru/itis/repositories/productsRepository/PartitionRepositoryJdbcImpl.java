package ru.itis.repositories.productsRepository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Partition;
import ru.itis.models.Partition;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class PartitionRepositoryJdbcImpl implements PartitionRepository {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_FIND_ALL = "select * from partition";

    private RowMapper<Partition> partitionRowMapper = (row, rowMapper) -> {
        return Partition.builder()
                .productClass(row.getString("class"))
                .price(row.getInt("price"))
                .build();
    };

    public PartitionRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Partition> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, partitionRowMapper);
    }

    @Override
    public void save(Partition entity) {

    }

    @Override
    public void update(Partition entity) {

    }

    @Override
    public void delete(Partition entity) {

    }

    @Override
    public Optional<Partition> findById(Long id) {
        return Optional.empty();
    }
}
