package com.beaksoo.shop.member;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.BCException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/register")
    String register(){
        return "register.html";
    }

    @PostMapping("/member")
    String addMember(
            String username,
            String password,
            String displayName) {

       Member member = new Member();
       member.setUsername(username);
       var hash = new BCryptPasswordEncoder().encode(password);
       member.setPassword(hash);
       member.setDisplayName(displayName);
        memberRepository.save(member);
        return "redirect:/list";
    }


}
