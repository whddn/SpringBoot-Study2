package com.beaksoo.shop.member;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.BCException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    String register() {
        return "register.html";
    }

    @PostMapping("/member")
    String addMember(
            String username,
            String password,
            String displayName) {

        Member member = new Member();
        member.setUsername(username);
        var hash = passwordEncoder.encode(password);
        member.setPassword(hash);
        member.setDisplayName(displayName);
        memberRepository.save(member);
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login() {
        var result = memberRepository.findByUsername(getUser().username);
        System.out.println(result.get().getDisplayName());
        return "login.html";
    }

    @GetMapping("/my-page")
    public String myPage(Authentication auth) {
        CustomUser result = (CustomUser) auth.getPrincipal();
        return "mypage.html";
    }

    @GetMapping("/user/1")
    @ResponseBody
    public MemberDto getUser() {
        Optional<Member> byId = memberRepository.findById(1L);
//        var a = byId;
        Member member = byId.get();
//        var result = member;
        MemberDto memberDto = new MemberDto(member.getUsername(), member.getDisplayName());
       return memberDto;
    }
}

    class MemberDto{
        public String username;
        public String dispalyName;
        public Long id;

        MemberDto(String a, String b){
            this.username = a;
            this.dispalyName = b;
        }

}
