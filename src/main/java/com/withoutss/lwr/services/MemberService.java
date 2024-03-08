package com.withoutss.lwr.services;

import com.withoutss.lwr.dto.SignIn;
import com.withoutss.lwr.dto.SignUp;
import com.withoutss.lwr.entities.Member;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    String signUp(Member member);
    String signIn(Member member);
}
