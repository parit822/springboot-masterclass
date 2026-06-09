package com.tkParit.product.service;

import com.tkParit.product.dto.ProductDTO;
import com.tkParit.product.entity.Category;
import com.tkParit.product.entity.Product;
import com.tkParit.product.exception.CategoryNotFoundException;
import com.tkParit.product.mapper.ProductMapper;
import com.tkParit.product.repository.CategoryRepository;
import com.tkParit.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){
        //id name description price categoryId
       Category category= categoryRepository
               .findById(productDTO.getCategoryId())
               .orElseThrow(()
                       ->new CategoryNotFoundException("Category id "
                       +productDTO.getCategoryId()+"  not found"));

       //DTO to Entity
       Product product= ProductMapper.toProductEntity(productDTO, category);
       //Save product
       product = productRepository.save(product);
       //entity to dto
       return ProductMapper.toProductDTO(product);
    }

    //Get All product
    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll().stream()
                .map(ProductMapper::toProductDTO).toList();
    }

    //get Product By id
    public ProductDTO getProductById(Long id){
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
        return ProductMapper.toProductDTO(product);
    }

    //update Product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product=productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product Not Found"));
        Category category= categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()->new RuntimeException("Product Not Found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    //delete Product
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product "+id+" has been deleted";
    }

}
