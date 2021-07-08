package com.example.OrganicShop_Backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.CrossOrigin

@SpringBootApplication
@CrossOrigin
class OrganicShopBackendApplication

fun main(args: Array<String>) {
	runApplication<OrganicShopBackendApplication>(*args)
}
