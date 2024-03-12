package com.withoutss.lwr.services;

import com.withoutss.lwr.entities.Event;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventService {
    Boolean registerFunction(Event event);
    List<Event> getMyEvents(Long fkId);
}
