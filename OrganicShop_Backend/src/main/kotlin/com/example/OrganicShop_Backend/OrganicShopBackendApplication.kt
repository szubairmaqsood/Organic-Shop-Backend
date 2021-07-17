package com.example.OrganicShop_Backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*

@SpringBootApplication

class OrganicShopBackendApplication

fun main(args: Array<String>) {
	runApplication<OrganicShopBackendApplication>(*args)
}

