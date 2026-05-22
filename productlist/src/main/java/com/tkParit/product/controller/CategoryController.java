package com.tkParit.product.controller;

import com.tkParit.product.dto.CategoryDTO;
import com.tkParit.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

//    @Autowired
    private CategoryService categoryService;

    //Get All Category
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }
    //createProduct
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //get category by id
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
       return categoryService.getCategoryById(id);
    }

    //delete category
    @DeleteMapping("/{id}")
    public String  deleteCategory(@PathVariable Long id){
       return categoryService.deleteCategory(id);
    }

}
