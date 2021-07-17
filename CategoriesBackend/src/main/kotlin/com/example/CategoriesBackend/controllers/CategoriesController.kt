package com.example.CategoriesBackend.controllers

import com.example.CategoriesBackend.models.Category
import com.example.CategoriesBackend.services.CategoriesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/categories")
//@CrossOrigin( "http://localhost:4200")
class CategoriesController {
    var categoryService:CategoriesService;
    @Autowired
    constructor(_categoryService:CategoriesService){
        this.categoryService = _categoryService;
    }

    @GetMapping("/list")
    fun index(): ResponseEntity<Collection<Category>>{
        return this.categoryService.listAllCategories();
    }

    @GetMapping("/show/{id}")
    fun getCategoryById(@PathVariable id:String): ResponseEntity<Optional<Category>> {
        return this.categoryService.showCategory(id);
    }

    @PostMapping ("/add")
    fun saveCategory(@RequestBody category: Category): ResponseEntity<Category> {
        return this.categoryService.addCategory(category);
    }



    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<String> {
       // return labortoryService.DeleteLabortory(id)
        return this.categoryService.DeleteCategory(id);
    }


    @PutMapping("/update/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody category:Category):ResponseEntity<Category>{
        return this.categoryService.updateCategory(id,category)

    }


}