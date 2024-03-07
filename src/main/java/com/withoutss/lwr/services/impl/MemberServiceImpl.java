package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.Member;
import com.withoutss.lwr.repositories.MemberRepository;
import com.withoutss.lwr.services.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public String signUp(Member member) {
        var email = memberRepository.findByEmail(member.getEmail());
        if (email == null) {
            memberRepository.save(member);
            return "Registered successfully!";
        } else {
            return "Email already exists!";
        }
    }

    @Override
    public String signIn(Member member) {
        try {
            var record = memberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
            if (record.getEmail().equals(member.getEmail()) && record.getPassword().equals(member.getPassword())) {
                return "Login Successfully!";
            }
        } catch (Exception e) {
            System.out.println("Invalid credentials!");
        }
        return "Invalid credentials";
    }

}
