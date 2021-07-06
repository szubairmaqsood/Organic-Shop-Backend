package com.example.UsersBackend.controllers

import com.example.UsersBackend.models.Users
import com.example.UsersBackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UsersController {
    var userService:UserService;
    @Autowired
    constructor(_userService:UserService){
        this.userService = _userService;
    }

    @GetMapping("/users/authenticate")
    fun authenticateUser(@RequestBody user: Users):Boolean{
        return this.userService.authenticateUser(user);

    }

    @PostMapping("/users/add")
    fun saveLabortiry(@RequestBody user: Users): ResponseEntity<Users> {
        return userService.addUser(user);
    }




}