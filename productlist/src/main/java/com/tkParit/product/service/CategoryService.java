package com.tkParit.product.service;

import com.tkParit.product.dto.CategoryDTO;
import com.tkParit.product.entity.Category;
import com.tkParit.product.mapper.CategoryMapper;
import com.tkParit.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //create category
//    public CategoryDTO createCategory(CategoryDTO categoryDTO){
//       Category category=CategoryMapper.toCategoryEntity(categoryDTO);
//        category=categoryRepository.save(category);
//        return CategoryMapper.toCategoryDTO(category);
//    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO){

        System.out.println(categoryDTO.getName());

        Category category = CategoryMapper.toCategoryEntity(categoryDTO);

        category = categoryRepository.save(category);

        return CategoryMapper.toCategoryDTO(category);
    }

    //get all Categories
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toCategoryDTO).toList();
    }

    //get category by id
    public CategoryDTO getCategoryById(Long id){
       Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }

    //delete category
    public String  deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category "+" has been deleted";
    }

}
