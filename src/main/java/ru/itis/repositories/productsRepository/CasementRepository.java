package ru.itis.repositories.productsRepository;

import ru.itis.models.Casement;
import ru.itis.repositories.CrudRepository;

import java.util.List;

public interface CasementRepository extends CrudRepository<Casement> {
    List<Casement> findAll();

}
