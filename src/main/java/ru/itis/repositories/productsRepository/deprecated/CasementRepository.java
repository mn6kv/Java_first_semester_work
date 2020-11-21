package ru.itis.repositories.productsRepository.deprecated;

import ru.itis.models.Casement;
import ru.itis.repositories.CrudRepository;

import java.util.List;

public interface CasementRepository extends CrudRepository<Casement> {
    List<Casement> findAll();

}
