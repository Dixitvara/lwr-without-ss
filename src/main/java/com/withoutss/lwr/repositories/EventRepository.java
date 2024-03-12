package com.withoutss.lwr.repositories;

import com.withoutss.lwr.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "SELECT * FROM Event WHERE fkmemid LIKE :memId", nativeQuery = true)
    List<Event> findAllByFkMemId(@Param("memId")Long FkMemId);
}
