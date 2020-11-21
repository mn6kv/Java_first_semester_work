package ru.itis.repositories.productsRepository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Casement;
import ru.itis.models.Door;
import ru.itis.models.Partition;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_FIND_DOORS = "select * from product where type = 'door'";
    //language=SQL
    private static final String SQL_FIND_CASEMENTS = "select * from product where type = 'casement'";
    //language=SQL
    private static final String SQL_FIND_PARTITION = "select * from product where type = 'partition'";
    //language=SQL
    private static final String SQL_FIND_ALL = "select * from product";
    //language=SQL
    private static final String SQL_FIND_BY_ID = "select * from product where id = ?";
    //language=SQL
    private static final String SQL_FIND_BY_TYPE = "select * from product where type = ?";
    //language=SQL
    private static final String SQL_GET_ID = "select id from product " +
            "where class = ? and type = ?";


    private RowMapper<Door> doorRowMapper = (row, rowMapper) -> {
        return Door.builder()
                .productClass(row.getString("class"))
                .price(row.getInt("price"))
                .build();
    };

    private RowMapper<Casement> casementRowMapper = (row, rowMapper) -> {
        return Casement.builder()
                .productClass(row.getString("class"))
                .price(row.getInt("price"))
                .build();
    };

    private RowMapper<Partition> partitionRowMapper = (row, rowMapper) -> {
        return Partition.builder()
                .productClass(row.getString("class"))
                .price(row.getInt("price"))
                .build();
    };

    private RowMapper<Product> productRowMapper = (row, rowMapper) -> {
        return Product.builder()
                .id(row.getLong("id"))
                .productClass(row.getString("class"))
                .price(row.getInt("price"))
                .type(row.getString("type"))
                .build();
    };

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public void save(Product entity) {
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, productRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Long getId(Product product) {
        return jdbcTemplate.queryForObject(SQL_GET_ID, Long.class, product.getProductClass(), product.getType());
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, productRowMapper);
    }

    @Override
    public List<Door> findDoors() {
        return jdbcTemplate.query(SQL_FIND_DOORS, doorRowMapper);
    }

    @Override
    public List<Casement> findCasements() {
        return jdbcTemplate.query(SQL_FIND_CASEMENTS, casementRowMapper);
    }

    @Override
    public List<Partition> findPartitions() {
        return jdbcTemplate.query(SQL_FIND_PARTITION, partitionRowMapper);
    }

    @Override
    public Optional<List<Product>> findByType(String type) {
        return Optional.of(jdbcTemplate.query(SQL_FIND_BY_TYPE, productRowMapper, type));
    }
}
