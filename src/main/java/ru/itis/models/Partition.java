package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Partition extends Product {

    private String productClass;
    private Integer price;

    public static class PartitionBuilder extends ProductBuilder {
        PartitionBuilder() {
            super();
        }
    }
}
