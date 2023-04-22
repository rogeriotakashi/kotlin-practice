package rogi.main.kotlinpractice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import rogi.main.kotlinpractice.service.HelloService

@RestController
class HelloController (val helloService: HelloService){

    @GetMapping("/hello")
    fun helloKotlin(): String {
        return helloService.getHello()
    }

    @GetMapping("/hello-dto")
    fun helloDto(): HelloDto {
        return HelloDto("Hello from the dto")
    }
}

data class HelloDto(val greeting: String)