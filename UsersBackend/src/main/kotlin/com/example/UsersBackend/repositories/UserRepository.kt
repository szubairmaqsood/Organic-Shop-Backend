package com.example.UsersBackend.repositories

import com.example.UsersBackend.models.Users
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository:MongoRepository<Users,String> {
   fun findByEmailAndPassword(Email:String, Password:String): Optional<Users>;
}