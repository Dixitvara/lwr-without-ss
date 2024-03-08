package com.withoutss.lwr.services.impl;

import com.withoutss.lwr.entities.Member;
import com.withoutss.lwr.repositories.MemberRepository;
import com.withoutss.lwr.services.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private HttpSession session;

    @Override
    public String signUp(Member member) {
        var email = memberRepository.findByEmail(member.getEmail());
        try {
            if (email == null) {
                memberRepository.save(member);
                return "Registered Successfully";
            }
        } catch (Exception e) {
            System.out.println("Internal server error");
        }
        return "Internal Server Error!";
    }

    @Override
    public String signIn(Member member) {
        var record = memberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
        try {
            if (record.getEmail().equals(member.getEmail()) && record.getPassword().equals(member.getPassword())) {
                session.setAttribute("userId", record.getId());
                return "Login Successfully";
            }
        } catch (Exception e) {
            log.error(String.valueOf(e));
            System.out.println("Invalid credentials");
        }
        return "Invalid credentials!";
    }

}
