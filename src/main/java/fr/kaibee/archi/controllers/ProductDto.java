package fr.kaibee.archi.controllers;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductDto {
    private String id;
    private String name;
    private Long code;
    private String description;
    private String createdAt;

}
