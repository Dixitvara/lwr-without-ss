package com.withoutss.lwr.repositories;

import com.withoutss.lwr.entities.CheckInOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CheckInOutRepository extends JpaRepository<CheckInOut, Long> {
    CheckInOut findByName(String name);

    @Query(value = "SELECT * FROM check_in_out WHERE status LIKE 'CHECKED_IN'", nativeQuery = true)
    List<CheckInOut> findAllByStatus();
}