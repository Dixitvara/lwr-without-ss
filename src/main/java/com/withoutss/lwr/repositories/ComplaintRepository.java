package com.withoutss.lwr.repositories;

import com.withoutss.lwr.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
//    @Query("SELECT u FROM Complaint u WHERE u.fk_mem_id LIKE :fkMemId")
//    List<Complaint> findAllByMember(Long fkMemId);

}
