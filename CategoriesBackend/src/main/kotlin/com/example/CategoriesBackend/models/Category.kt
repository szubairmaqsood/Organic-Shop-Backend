package com.example.CategoriesBackend.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Category {
    @Id
    var id:String;
    @Indexed(unique = true)
    var title:String;


    constructor(){
        id ="Empty key" ;
        this.title = "title";
    }

    constructor(_title:String){
        id="";
        this.title = _title;
    }
}