package com.amazon.marketplace.Amazon.Marketplace.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String testRoot(){
        return "<h1> Test succesful </h1>";
    }
}
