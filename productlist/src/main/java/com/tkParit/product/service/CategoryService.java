package com.tkParit.product.service;

import com.tkParit.product.dto.CategoryDTO;
import com.tkParit.product.entity.Category;
import com.tkParit.product.mapper.CategoryMapper;
import com.tkParit.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    //get category by id
    //delete category

}
