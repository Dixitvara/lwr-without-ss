package com.withoutss.lwr.repositories;

import com.withoutss.lwr.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    Member findByEmailAndPassword(String email, String password);
}
