package ru.itis.repositories.productsRepository;

import ru.itis.models.Casement;
import ru.itis.models.Door;
import ru.itis.models.Partition;
import ru.itis.models.Product;
import ru.itis.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends CrudRepository<Product> {
    List<Door> findDoors();
    List<Casement> findCasements();
    List<Partition> findPartitions();
    Optional<List<Product>> findByType(String type);
    Long getId(Product product);
}
