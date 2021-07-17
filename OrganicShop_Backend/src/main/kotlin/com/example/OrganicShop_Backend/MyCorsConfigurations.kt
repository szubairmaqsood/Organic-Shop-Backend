package com.example.OrganicShop_Backend

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@CrossOrigin("http://localhost:4200")
class MyCorsConfigurations {
    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/api/**").allowedOrigins("*")
                    .allowedHeaders("*")
                    .allowedMethods("*")
            }
        }
    }

}