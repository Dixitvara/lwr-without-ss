package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.Event;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    Boolean registerFunction(Event event);
    List<Event> getMyEvents(Long fkId);
    // event api
//    Boolean checkDate(LocalDate date1, LocalDate date2);
}
