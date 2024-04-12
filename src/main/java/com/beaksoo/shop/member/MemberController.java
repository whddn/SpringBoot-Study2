package com.beaksoo.shop.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/register")
    String register(){
        return "register.html";
    }
}
