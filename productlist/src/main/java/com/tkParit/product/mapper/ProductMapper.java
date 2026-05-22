package com.tkParit.product.mapper;

import com.tkParit.product.dto.ProductDTO;
import com.tkParit.product.entity.Category;
import com.tkParit.product.entity.Product;

public class ProductMapper {

    //toProduct entity to dto
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    //DTO to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product=new Product();
//        product.setId();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;
    }

}
