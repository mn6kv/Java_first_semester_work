package ru.itis.services;

import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.repositories.BasketRepository;
import ru.itis.repositories.productsRepository.ProductsRepository;

import java.util.List;

public class BasketServiceImpl implements BasketService {

    BasketRepository basketRepository;
    ProductsRepository productsRepository;

    public BasketServiceImpl(BasketRepository basketRepository,ProductsRepository productsRepository) {
        this.basketRepository = basketRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public void save(User user, Product product) {
        saveById(user.getId(), productsRepository.getId(product));
    }

    @Override
    public void saveById(Long productId, Long userId) {
        System.out.println("Service " + productId + " " + userId);
        basketRepository.saveById(productId, userId);
    }

    @Override
    public void deleteForUser(Long userId) {
        basketRepository.deleteForUser(userId);
    }

    @Override
    public List<Product> getForUser(Long userId) {
        return basketRepository.getForUser(userId);
    }
}
