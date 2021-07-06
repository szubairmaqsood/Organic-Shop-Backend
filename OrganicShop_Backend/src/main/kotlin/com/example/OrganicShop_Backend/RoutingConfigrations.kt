package com.example.OrganicShop_Backend

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RoutingConfigrations {

    @Value("\${users.Path}")
    var users: String?=null;

    @Value("\${orders.Path}")
    var orders: String?=null;

    @Value("\${products.Path}")
    var products:String? =null;

    @Value("\${categories.Path}")
    var categories:String? =null;


    @Bean
    fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? {
        return builder.routes()
            .route { r ->
                r.path("/api/users/**")
                    .uri(users)
            }

            .route { r ->
                r.path("/api/orders/**")
                    .uri(orders)
            }
            .route { r ->
                r.path("/api/products/**")
                    .uri(products)
            }
            .route { r ->
                r.path("/api/categories/**")
                    .uri(categories)
            }
            .build()
    }

}