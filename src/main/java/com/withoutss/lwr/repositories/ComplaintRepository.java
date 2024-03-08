package com.withoutss.lwr.repositories;

import com.withoutss.lwr.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
