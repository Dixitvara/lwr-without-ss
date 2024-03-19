package com.withoutss.lwr.repositories;

import com.withoutss.lwr.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    Member findByEmailAndPassword(String email, String password);
    @Query(value = "SELECT id FROM Member", nativeQuery = true)
    List<Long> getAllId();
}
