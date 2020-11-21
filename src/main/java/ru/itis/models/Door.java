package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Door extends Product {

    private String productClass;
    private Integer price;

    public static class DoorBuilder extends ProductBuilder {
        DoorBuilder() {
            super();
        }
    }

}
