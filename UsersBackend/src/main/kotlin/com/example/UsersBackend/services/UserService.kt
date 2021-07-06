package com.example.UsersBackend.services

import com.example.UsersBackend.models.Users
import com.example.UsersBackend.repositories.UserRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService {
    var userRepository: UserRepository;

    @Autowired
    constructor(_userRepository:UserRepository){
        this.userRepository = _userRepository;
    }

    /* For adding User */
    fun addUser(user: Users): ResponseEntity<Users> {
        user.id= ObjectId().toString();
        userRepository.save(user)
        return  ResponseEntity(user, HttpStatus.CREATED)
    }

    fun authenticateUser(user: Users):Boolean{
       var users1:Optional<Users> = userRepository.findByEmailAndPassword(user.email,user.password);
        if(users1.isPresent){
            return true;
        }
            return false;
    }
}