package com.tkParit.product.controller;

import com.tkParit.product.dto.CategoryDTO;
import com.tkParit.product.exception.CategoryAlreadyExistsException;
import com.tkParit.product.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Category REST API crud operation",
        description = "Create read update delete operations for category REST API"
)
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
    //createCategory
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
           CategoryDTO savedCategory= categoryService.createCategory(categoryDTO);
           return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
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
