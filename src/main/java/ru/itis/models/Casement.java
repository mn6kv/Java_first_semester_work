package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Casement extends Product {
        private String productClass;
        private Integer price;
}
