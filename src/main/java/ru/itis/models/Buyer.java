package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Buyer {
    private Long id;
    private Long userId;
    private String name;
}
