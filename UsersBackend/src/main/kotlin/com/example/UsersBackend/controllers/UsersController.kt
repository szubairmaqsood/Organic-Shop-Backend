package com.example.UsersBackend.controllers

import com.example.UsersBackend.models.Users
import com.example.UsersBackend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
//@CrossOrigin("*")
class UsersController {
    var userService:UserService;
    @Autowired
    constructor(_userService:UserService){
        this.userService = _userService;
    }

    @GetMapping("/authenticate")
    fun authenticateUser(@RequestBody user: Users):Boolean{
        return this.userService.authenticateUser(user);

    }
    //@CrossOrigin("http://localhost:8081")
    @PostMapping("/add")
    fun saveUser(@RequestBody user: Users): ResponseEntity<Users> {

        System.out.println("Hello");
        //return ResponseEntity.ok("H");
        return userService.addUser(user);
    }

    @GetMapping("/dummy")
    fun dummy():String{
        return "Hello User"
    }




}