package ru.itis.repositories.productsRepository.deprecated;

import ru.itis.models.Partition;
import ru.itis.repositories.CrudRepository;

import java.util.List;

public interface PartitionRepository extends CrudRepository<Partition> {
    List<Partition> findAll();
}
