package com.example.ProductsBackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductsBackendApplication

fun main(args: Array<String>) {
	runApplication<ProductsBackendApplication>(*args)
}
