package com.tkParit.product.controller;

import com.tkParit.product.dto.ProductDTO;
import com.tkParit.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API crud operation",
        description = "Create read update delete operations for product REST API"
)

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
   private ProductService productService;


    //get All product
    @GetMapping
    public List<ProductDTO> getAllProduct(){
       return productService.getAllProduct();
    }

    //getProduct by id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
       return productService.getProductById(id);
    }

    //createProduct
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
      ProductDTO createdProduct= productService.createProduct(productDTO);
      return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    //updateProduct
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
       return productService.updateProduct(id,productDTO);
    }

    //delete By Id
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
       return productService.deleteProduct(id);
    }
}
