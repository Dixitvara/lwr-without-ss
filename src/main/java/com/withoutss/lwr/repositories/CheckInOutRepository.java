package com.withoutss.lwr.repositories;

import com.withoutss.lwr.entities.CheckInOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInOutRepository extends JpaRepository<CheckInOut, Long> {
    CheckInOut findByName(String name);
}