package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class BasketRepositoryJdbcImpl implements BasketRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Product> productRowMapper = (row, rowMapper) -> {
        return Product.builder()
                .id(row.getLong("id"))
                .productClass(row.getString("class"))
                .price(row.getInt("price"))
                .type(row.getString("type"))
                .build();
    };

    //language=SQL
    private static final String SQL_ADD_TO_BASKET = "insert into basket(userid, productid) values (?, ?)";
    //language=SQL
    private static final String SQL_DELETE_FOR_USER = "delete from basket where userid = ?";
    //language=SQL
    private static final String SQL_GET_FOR_USER = "select product.id, class, price, type from basket join product " +
            "on basket.productid = product.id where userid = ?";

    public BasketRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveById(Long productId, Long userId) {
        jdbcTemplate.update(SQL_ADD_TO_BASKET, userId, productId);
    }

    @Override
    public void deleteForUser(Long userId) {
        jdbcTemplate.update(SQL_DELETE_FOR_USER, userId);
    }

    @Override
    public List<Product> getForUser(Long userId) {
        return jdbcTemplate.query(SQL_GET_FOR_USER, productRowMapper, userId);
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
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
