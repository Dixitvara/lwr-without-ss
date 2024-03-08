package com.withoutss.lwr.repositories;

import com.withoutss.lwr.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
