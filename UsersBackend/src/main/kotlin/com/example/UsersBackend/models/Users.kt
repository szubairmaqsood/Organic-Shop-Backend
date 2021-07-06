package com.example.UsersBackend.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document


@Document
class Users {
    @Id
    var id:String;
    var name:String;
    var role:String;
    @Indexed(unique = true)
    var email:String;
    var password:String;

    constructor(){
        id ="Empty key" ;
        this.name = "name";
        this.email = "email";
        this.password = "password";
        this.role = "user"
    }
    constructor(_name:String,_email:String,_password:String,_role:String){
        id="";
        this.name = _name;
        this.email = _email;
        this.password = _password;
        this.role = _role;

    }
}