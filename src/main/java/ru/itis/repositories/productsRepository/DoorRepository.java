package ru.itis.repositories.productsRepository;

import ru.itis.models.Door;
import ru.itis.repositories.CrudRepository;

import java.util.List;

public interface DoorRepository extends CrudRepository<Door> {
    List<Door> findAll();
}
