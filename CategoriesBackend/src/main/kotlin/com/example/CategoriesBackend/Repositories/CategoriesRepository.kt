package com.example.CategoriesBackend.Repositories

import com.example.CategoriesBackend.models.Category
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriesRepository:MongoRepository<Category,String>{
}