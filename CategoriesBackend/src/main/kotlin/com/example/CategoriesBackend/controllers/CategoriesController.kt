package com.example.CategoriesBackend.controllers

import com.example.CategoriesBackend.models.Category
import com.example.CategoriesBackend.services.CategoriesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
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

    @GetMapping("/categories/list")
    fun index(): ResponseEntity<Collection<Category>>{
        return this.categoryService.listAllCategories();
    }

    @GetMapping("/categories/show/{id}")
    fun getCategoryById(@PathVariable id:String): ResponseEntity<Optional<Category>> {
        return this.categoryService.showCategory(id);
    }

    @PostMapping ("/categories/add")
    fun saveCategory(@RequestBody category: Category): ResponseEntity<Category> {
        return this.categoryService.addCategory(category);
    }



    @DeleteMapping("/categories/delete/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<String> {
       // return labortoryService.DeleteLabortory(id)
        return this.categoryService.DeleteCategory(id);
    }


    @PutMapping("/categories/update/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody category:Category):ResponseEntity<Category>{
        return this.categoryService.updateCategory(id,category)

    }


}