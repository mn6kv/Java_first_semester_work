package ru.itis.util;

import ru.itis.models.Casement;
import ru.itis.models.Door;
import ru.itis.models.Partition;
import ru.itis.models.Product;
import ru.itis.repositories.productsRepository.CasementRepository;
import ru.itis.repositories.productsRepository.DoorRepository;
import ru.itis.repositories.productsRepository.PartitionRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductsUtil {

    static DoorRepository doorRepository;
    static CasementRepository casementRepository;
    static PartitionRepository partitionRepository;

    public ProductsUtil(
            DoorRepository doorRepository,
            CasementRepository casementRepository,
            PartitionRepository partitionRepository) {

        this.doorRepository = doorRepository;
        this.casementRepository = casementRepository;
        this.partitionRepository = partitionRepository;
    }

    public List<Door> getDoors() {
        return doorRepository.findAll();
    }

    public List<Casement> getCasements() {
        return casementRepository.findAll();
    }

    public List<Partition> getPartitions() {
        return partitionRepository.findAll();
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        products.addAll(this.getDoors());
        products.addAll(this.getCasements());
        products.addAll(this.getPartitions());

        return products;
    }
}
