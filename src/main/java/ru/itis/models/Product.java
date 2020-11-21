package ru.itis.models;

import lombok.*;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long id;
    private String productClass;
    private Integer price;
    private String type;

    public static Product fromOptional(Optional<Product> productOptional) {
        return productOptional.orElse(null);
    }
}
