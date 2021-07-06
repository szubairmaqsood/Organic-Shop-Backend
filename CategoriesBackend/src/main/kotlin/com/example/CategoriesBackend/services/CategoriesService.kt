package com.example.CategoriesBackend.services

import com.example.CategoriesBackend.Repositories.CategoriesRepository
import com.example.CategoriesBackend.models.Category
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoriesService {
    var categoryRepositroy:CategoriesRepository;
    @Autowired
    constructor(_categoryRepositroy:CategoriesRepository){
         this.categoryRepositroy = _categoryRepositroy;
    }
    /*   List all categories */
   fun listAllCategories(): ResponseEntity<Collection<Category>> {
       return ResponseEntity(this.categoryRepositroy.findAll(), HttpStatus.OK);
   }
    /*   Show a particular Category  */
    fun showCategory(id:String): ResponseEntity<Optional<Category>> {
        var category:Optional<Category> = categoryRepositroy.findById(id)
        if(category.isPresent){
            return  ResponseEntity(category,HttpStatus.OK)
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    /* For adding Categories */
    fun addCategory(category:Category):ResponseEntity<Category>
    {
        category.id = ObjectId().toString();
        this.categoryRepositroy.save(category)
        return  ResponseEntity(category, HttpStatus.CREATED)
    }

    /* Delete by id */
    fun DeleteCategory(id:String): ResponseEntity<String> {
        var category:Optional<Category> = this.categoryRepositroy.findById(id)
        if(category.isPresent){
            categoryRepositroy.deleteById(id)
            //return ResponseEntity("The category with id " + id.toString()  + " deleted successfully",HttpStatus.OK)
            return ResponseEntity(true.toString(),HttpStatus.OK)
        }
        else{
            return ResponseEntity(false.toString(),HttpStatus.NOT_FOUND)
        }
    }

    /* Updating a Category*/
    fun updateCategory(id:String, category: Category):ResponseEntity<Category>{
        var _category:Optional<Category> =  categoryRepositroy.findById(id);

        if(_category.isPresent) {
            var category1:Category    =_category.get()
            category1.title = category.title;
            categoryRepositroy.save(category1)
            return ResponseEntity(category1,HttpStatus.OK)
        }
        else{
            return ResponseEntity.notFound().build()
        }
    }
}