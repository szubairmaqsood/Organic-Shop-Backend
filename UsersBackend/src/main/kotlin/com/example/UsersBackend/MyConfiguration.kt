package com.example.UsersBackend

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import java.util.*

@Configuration
class MyConfiguration {

    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/api/**").allowedOrigins("http://localhost:8081")
                    .allowedHeaders("*")
                    .allowedMethods("*")
            }
        }
    }


    //@Bean
    //fun corsConfigurer(): WebMvcConfigurer? {
    //return object : WebMvcConfigurerAdapter() {
          //override fun addCorsMappings(registry: CorsRegistry) {
         //      registry.addMapping("/**").allowedOrigins("http://localhost:4200")
       //    }
     //  }
   //}

    //@Bean
    //fun corsFilter(): CorsFilter? {
    //    val source = UrlBasedCorsConfigurationSource()
     //   val config = CorsConfiguration()
     //   config.allowCredentials = true
        // Don't do this in production, use a proper list  of allowed origins
   //     config.allowedOrigins = listOf("*")
   //     config.allowedHeaders = Arrays.asList("Origin", "Content-Type", "Accept")
    //    config.allowedMethods = Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
    //    source.registerCorsConfiguration("/**", config)
   //     return CorsFilter(source)
   // }


}

