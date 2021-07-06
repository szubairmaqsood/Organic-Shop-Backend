package com.example.CategoriesBackend.controllers

import com.example.CategoriesBackend.models.Category
import com.example.CategoriesBackend.services.CategoriesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class CategoriesController {
    var categoryService:CategoriesService;
    @Autowired
    constructor(_categoryService:CategoriesService){
        this.categoryService = _categoryService;
    }

    @GetMapping("/category/list")
    fun index(): Optional<MutableList<Category>>{
        return this.categoryService.listAllCategories();
    }

    @GetMapping("/category/show/{id}")
    fun getCategoryById(@PathVariable id:Int): Optional<Category> {
        return this.categoryService.showCategory(id);
    }


}