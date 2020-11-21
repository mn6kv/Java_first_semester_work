package ru.itis.util;

import ru.itis.models.Casement;
import ru.itis.models.Door;
import ru.itis.models.Partition;
import ru.itis.models.Product;
import ru.itis.repositories.productsRepository.ProductsRepository;

import java.util.List;

public class ProductsUtil {

    static ProductsRepository productsRepository;

    public ProductsUtil(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Door> getDoors() {
        return productsRepository.findDoors();
    }

    public List<Casement> getCasements() {
        return productsRepository.findCasements();
    }

    public List<Partition> getPartitions() {
        return productsRepository.findPartitions();
    }

    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    public Product getById(Long id) {
        return Product.fromOptional(productsRepository.findById(id));
    }

    public Long getId(Product product) {
        return productsRepository.getId(product);
    }
}