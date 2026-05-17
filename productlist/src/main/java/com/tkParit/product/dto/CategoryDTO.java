package com.tkParit.product.dto;

import lombok.*;

import java.util.List;

@Data
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;

    private List<ProductDTO> products;

}
