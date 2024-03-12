package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.Member;

public interface MemberService {
    Boolean signUp(Member member);
    Boolean signIn(Member member);
}
