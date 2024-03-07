package com.withoutss.lwr.controllers;

import com.withoutss.lwr.dto.SignIn;
import com.withoutss.lwr.dto.SignUp;
import com.withoutss.lwr.entities.Member;
import com.withoutss.lwr.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody Member request){
        return ResponseEntity.ok(memberService.signUp(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<String> login(@RequestBody Member request){
        return ResponseEntity.ok(memberService.signIn(request));
    }

}
