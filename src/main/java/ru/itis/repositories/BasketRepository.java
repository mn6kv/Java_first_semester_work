package ru.itis.repositories;

import ru.itis.models.Product;

import java.util.List;

public interface BasketRepository extends CrudRepository<Product> {
    void saveById(Long productId, Long userId);
    void deleteForUser(Long userId);
    List<Product> getForUser(Long userId);
}
