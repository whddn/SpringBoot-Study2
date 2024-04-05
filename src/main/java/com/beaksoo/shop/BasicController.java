package com.beaksoo.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello(){
        return "index.html";
    }
    @GetMapping("/date")
    public void getCurrentDate() {

    }

}
