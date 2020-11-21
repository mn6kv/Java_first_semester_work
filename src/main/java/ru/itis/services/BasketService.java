package ru.itis.services;

import ru.itis.models.Product;
import ru.itis.models.User;

import java.util.List;

public interface BasketService {
    void save(User user, Product product);
    void saveById(Long productId, Long userId);
    void deleteForUser(Long userId);
    List<Product> getForUser(Long userId);
}
