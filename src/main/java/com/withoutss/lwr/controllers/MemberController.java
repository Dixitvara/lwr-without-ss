package com.withoutss.lwr.controllers;

import com.withoutss.lwr.entities.Member;
import com.withoutss.lwr.services.MemberService;
import com.withoutss.lwr.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/lwresident/v1/auth")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody Member request){
        if(memberService.signUp(request))
        {
            return Utils.getResponseEntity("Registered successfully!", HttpStatus.OK);
        }
        else{
            return Utils.getResponseEntity("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<String> login(@RequestBody Member request){
        if(memberService.signIn(request))
        {
            return Utils.getResponseEntity("Login successfully", HttpStatus.OK);
        }
        else{
            return Utils.getResponseEntity("Invalid credentials", HttpStatus.BAD_REQUEST);
        }
    }

}