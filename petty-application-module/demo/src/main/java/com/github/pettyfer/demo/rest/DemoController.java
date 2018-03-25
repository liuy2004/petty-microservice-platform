package com.github.pettyfer.demo.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(){
        return "Demo";
    }

    @GetMapping("user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }
}
